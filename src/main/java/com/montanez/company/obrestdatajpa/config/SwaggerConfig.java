package com.montanez.company.obrestdatajpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

//http://localhost:8080/swagger-ui/
@Configuration//para que spring lo reconozca como una clase de configuracion
public class SwaggerConfig {
    @Bean
    public Docket api(){//Docket es un tipo de clase que se usa para documentar los servicios de la api
        return new Docket(DocumentationType.SWAGGER_2)

                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiDetails() {
        return new ApiInfo("REST API",
                "Some custom description of API.",
                "API TOS",
                "Terms of service",
                new Contact("John Doe", "www.example.com","example@example.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
}
