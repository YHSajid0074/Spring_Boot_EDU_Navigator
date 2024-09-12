package org.Edu.navigator.Authentication.Jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;



    @Component
    public class JwtAuthFilter extends OncePerRequestFilter {

        public static final String AUTHORIZATION_HEADER = "Bearer ";
        public static final String AUTHORIZATION_HEADER_NAME = "Authorization";
        private static final Logger logger = LoggerFactory.getLogger(JwtAuthFilter.class);
        private final JwtHelper jwtHelper;
        private final UserService userService;

        @Autowired
        public JwtAuthFilter(JwtHelper jwtHelper, UserService userService) {
            this.jwtHelper = jwtHelper;
            this.userService = userService;
        }

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                        FilterChain filterChain) throws ServletException, IOException {

            try {
                String jwt = parseJwt(request);
                if (jwt != null) {
                    String username = jwtHelper.extractUsername(jwt);
                    User user = userService.findByUserName(username);
                    UserDetails userDetails = prepareUserDetails(user);
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (IllegalArgumentException e) {
                logger.info("Illegal Argument while fetching the username !!");
                e.printStackTrace();
            } catch (ExpiredJwtException e) {
                logger.info("Given jwt token is expired !!");
                e.printStackTrace();
            } catch (MalformedJwtException e) {
                logger.info("Some changed has done in token !! Invalid Token");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("Invalid header value" + e.getMessage());
            }

            filterChain.doFilter(request, response);
        }


        private String parseJwt(HttpServletRequest request) {
            String headerAuth = request.getHeader(AUTHORIZATION_HEADER_NAME);
            if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(AUTHORIZATION_HEADER)) {
                return headerAuth.substring(7);
            }
            return null;
        }

        private UserDetails prepareUserDetails(User user) {
            return CustomUserDetails.build(user);
        }



    }
