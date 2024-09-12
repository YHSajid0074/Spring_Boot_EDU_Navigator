package org.Edu.navigator.Authentication.security;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Authentication.Jwt.JwtAuthFilter;
import org.Edu.navigator.Authentication.service.CustomAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter authFilter;

    private final JwtAuthenticationEntryPoint entryPoint;

    private final CustomAccessDeniedHandler accessDeniedHandler;

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .cors(cors -> cors.configurationSource(new CorsConfig()))
                // disabling csrf since we won't use form login
                .csrf(AbstractHttpConfigurer::disable)
                // giving every permission to every request for public endpoint
                .authorizeHttpRequests(request -> request.requestMatchers("PUBLIC_ENDPOINTS")
                        .permitAll().anyRequest().authenticated())
                // setting custom access denied handler for not authorized request
                .exceptionHandling(exception -> exception.accessDeniedHandler(accessDeniedHandler))
                // setting custom entry point for unauthenticated request
                .exceptionHandling(exception -> exception.authenticationEntryPoint(entryPoint))
                // setting auth provider of dao authentication of user details service
                .authenticationProvider(authenticationProvider())
                // adding the custom filter before UsernamePasswordAuthenticationFilter in the filter chain
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                // setting stateless session, because we choose to implement Rest API
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
