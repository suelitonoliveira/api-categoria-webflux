/*
package com.apiwebfluxibm.webfluxibm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class CategoryRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(CategoryHandler categoryHandler){
        return RouterFunctions
                .route(GET("/categories").and(accept(MediaType.APPLICATION_JSON)), categoryHandler::findAll)
                .andRoute(GET("/category/{id}").and(accept(MediaType.APPLICATION_JSON)), categoryHandler::findById)
                .andRoute(DELETE("/category/{id}").and(accept(MediaType.APPLICATION_JSON)), categoryHandler::delete)
                .andRoute(POST("/category").and(accept(MediaType.APPLICATION_JSON)), categoryHandler::save)
                .andRoute(PUT("/category").and(accept(MediaType.APPLICATION_JSON)), categoryHandler::update);

    }

}
*/
