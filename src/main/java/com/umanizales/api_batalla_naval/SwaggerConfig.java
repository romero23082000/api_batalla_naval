package com.umanizales.api_batalla_naval;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiBatallaNavalDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Batalla Naval")
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "com.umanizales.api_batalla_naval.controller"))
                .paths(PathSelectors.any()).build()
                .apiInfo(getApiInfo());
    }
    //Agregar método información o documentación de mi api
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "API Batalla Naval ",
                "Api que permite gestionar todo el backend del juego batalla naval y implementacion de listas SE Y DE",
                "1.0",
                "http://www.umanizales.com/",
                new Contact("Andres Romero", "http://www.umanizales.edu.co/",
                        "afromero69882@umanizales.edu.co"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}

