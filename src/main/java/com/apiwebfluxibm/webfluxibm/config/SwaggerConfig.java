package com.apiwebfluxibm.webfluxibm.config;

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
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.apiwebfluxibm.webfluxibm.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("API Category-Teste", "API REST com WebFlux para teste IBM", "Versão 1.0", "http://www.livroteste.com.br",
                new Contact("IBM", "http://www.livroteste.com.br", "sueliton.de.oliveira@ibm.com"), "opensource",
                "http://www.livroteste.com.br/terms", Collections.emptyList());
    }

}
