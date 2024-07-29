package com.wl.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    private static final String SECURITY_AUTHENTICATION = "authentication";

    @Value("${api-docs.title}")
    private String apiTitle;
    @Value("${api-docs.description}")
    private String description;
    @Value("${api-docs.version}")
    private String version;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title(apiTitle)
                                .description(description)
                                .version(version)
//                    .license(new License().name("Apache 2.0").url(""))
                )
                .schemaRequirement(SECURITY_AUTHENTICATION, this.securityScheme())
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_AUTHENTICATION))
                ;
    }

    private SecurityScheme securityScheme() {
        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.setType(SecurityScheme.Type.APIKEY);
        securityScheme.setName(SECURITY_AUTHENTICATION);
        securityScheme.setIn(SecurityScheme.In.HEADER);
        return securityScheme;
    }
}
