package org.Edu.navigator.Config.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

public class CustomCORSConfig implements CorsConfigurationSource {
    @Override
    public CorsConfiguration getCorsConfiguration( @NotNull HttpServletRequest request ) {
        CorsConfiguration corsConfig = new CorsConfiguration();

        corsConfig.setAllowedOrigins( Collections.singletonList( "*" ) );
        corsConfig.setAllowedMethods( Collections.singletonList( "*" ) );
        corsConfig.setAllowCredentials( true );
        corsConfig.setAllowedHeaders( Collections.singletonList( "*" ) );
       // corsConfig.setExposedHeaders( Collections.singletonList( "Authorization" ) );
        corsConfig.setMaxAge( 3600L );

        return corsConfig;
    }
}