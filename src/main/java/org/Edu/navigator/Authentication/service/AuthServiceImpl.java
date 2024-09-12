package org.Edu.navigator.Authentication.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;


    private final RefreshTokenService refreshTokenService;

    private final JwtHelper jwtHelper;

    private final LogInHistoryRepository logInHistoryRepository;

    private final EmployeeService employeeService;

    private final RoleService roleService;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, RefreshTokenService refreshTokenService, JwtHelper jwtHelper, LogInHistoryRepository logInHistoryRepository, EmployeeService employeeService, RoleService roleService) {
        this.authenticationManager = authenticationManager;
        this.refreshTokenService = refreshTokenService;
        this.jwtHelper = jwtHelper;
        this.logInHistoryRepository = logInHistoryRepository;
        this.employeeService = employeeService;
        this.roleService = roleService;
    }

    @Override
    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername().trim().toLowerCase(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        String jwtToken = jwtHelper.generateToken(userDetails.getUsername());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        Employee employee = employeeService.findByUserId(userDetails.getId());
        List<MenuTreeDto> accessibleMenus = roleService.getMenuListByRole(userDetails.getRoleId());

        final String ip = HttpRequestResponseUtils.getClientIpAddress();
        final String userAgent = HttpRequestResponseUtils.getUserAgent();

        //  String s = roles.stream().findAny().get();
        //  List<AccessRight> menuWithAccessRight = menuFacadeService.getMenuWithAccessRight(Long.parseLong(s));

        try {
            LogInHistory history = new LogInHistory();

            User user = new User();
            user.setId(userDetails.getId());
            history.setLoginBy(user);
            history.setUserIP(ip);
            history.setUserAgent(userAgent);

            logInHistoryRepository.saveAndFlush(history);

        } catch (Exception e) {
            log.error(e.getMessage());
        }

//        if (CollectionUtils.isEmpty(roles)) {
//            throw new RmsServerException();
//        }

        return JwtResponse.builder()
                .token(jwtToken)
                .refreshToken(refreshToken.getRefreshToken())
                .roleName(userDetails.getRole())
                .roleId(userDetails.getRoleId())
                .userId(userDetails.getId())
                .userName(userDetails.getUsername())
                .fullName(userDetails.getFullName())
                .type(ApplicationConstant.AUTHORIZATION_TYPE_BEARER)
                .employeeId((employee != null) ? employee.getId() : null)
                .accessibleMenu(accessibleMenus)
                .build();
    }
}