package org.Edu.navigator.Config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Config.security.jwt.JWTFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class GlobalWebSecurityConfig {
    private final JWTFilter jwtFilter;
    private final UserDetailsService customUserDetailsService;  // Injected UserDetailsService

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .cors(cors -> cors.configurationSource(new CustomCORSConfig()))
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS
                ))
                .authorizeHttpRequests((httpRequests) -> {
                    httpRequests
                            .requestMatchers(
                                    "/register",
                                    "/Role",
                                    "/User",
                                    "/auth/**",
                                    "/v2/api-docs",
                                    "/v3/api-docs",
                                    "/v3/api-docs/**",
                                    "/swagger-resources",
                                    "/swagger-resources/**",
                                    "/configuration/ui",
                                    "/configuration/security",
                                    "/swagger-ui/**",
                                    "/webjars/**",
                                    "/User",
                                    "/User/",
                                    "Log",
                                    "/User/change-roles",
                                    "/Role",
                                    "/Role/",
                                    "/swagger-ui.html"
                            )
                            .permitAll()
                            .anyRequest()
                            .permitAll();  // Secure all other endpoints
                })
              //  .authenticationManager(authentication -> authentication.)
                .authenticationProvider(daoAuthenticationProvider())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();  // Default manager using DAO
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);  // Set the custom UserDetailsService
        authProvider.setPasswordEncoder(passwordEncoder());  // Set the password encoder
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   // @Bean
   // public void configure(AuthenticationManagerBuilder auth) throws Exception {
     //   auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
  //  }


    @Component
    public static class customAccess implements AccessDeniedHandler {

        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
            request.setAttribute("javax.servlet.error.status_code", HttpServletResponse.SC_FORBIDDEN);
        }
    }
}

