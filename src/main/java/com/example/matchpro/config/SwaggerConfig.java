package com.example.matchpro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The main configuration for Swagger.
 *
 * @author Alben Bustamante
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String REST_PACKAGE = "com.example.matchpro.controller";

    /**
     * Define a bean with the api configuration.
     * @return the {@link Docket}
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(REST_PACKAGE))
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * @return an {@link ApiInfo} with the main information.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Match Pro")
                .description("Tus gestor de apuestas de confianza")
                .build();
    }

}
