package org.Edu.navigator.Config.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.TreeMap;

@Configuration
@RequiredArgsConstructor
public class OpenAPIConfig {

//    @Value("${openapi.local-url}")
//    private String localUrl;
//
//    @Value("${openapi.dev-url}")
//    private String devUrl;

    @Bean
    public OpenApiCustomizer sortSchemasAlphabetically() {
        return openApi -> {
            Map<String, Schema> schemas = openApi.getComponents().getSchemas();
            openApi.getComponents().setSchemas(new TreeMap<>(schemas));
        };
    }

    @Bean
    public OpenAPI myOpenAPI() {

//        Server localServer = new Server();
//        localServer.setUrl(localUrl);
//        localServer.setDescription("Server URL in Local environment");
//
//        Server devServer = new Server();
//        devServer.setUrl(devUrl);
//        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
//        contact.setEmail("yeamim.hossain@technonext.com");
//        contact.setName("TechnoNext Ltd");
//        contact.setUrl("https://www.technonext.com");

        Info info = new Info()
                .title("Backend Service API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints");

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
//                .servers(List.of(localServer, devServer))
                .info(info);
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
