/*
package com.apiwebfluxibm.webfluxibm.config;

import com.apiwebfluxibm.webfluxibm.dto.CategoryRequestDTO;
import com.apiwebfluxibm.webfluxibm.model.Category;
import com.apiwebfluxibm.webfluxibm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
public class CategoryHandler {

    @Autowired
    private CategoryService categoryService;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(categoryService.findAll(), CategoryRequestDTO.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request){
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(categoryService.findById(id), CategoryRequestDTO.class);
    }

    public Mono<ServerResponse> delete(ServerRequest request){
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(categoryService.delete(id), CategoryRequestDTO.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        final Mono<Category> categoryMono = request.bodyToMono(Category.class);
        final Mono<ServerResponse> body = ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(categoryMono.flatMap(categoryService::save), Category.class));
        return body;
    }

    public Mono<ServerResponse> update(ServerRequest request){
        final Mono<Category> categoryMono = request.bodyToMono(Category.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(categoryMono.flatMap(categoryService::update), Category.class));
    }

}
*/
