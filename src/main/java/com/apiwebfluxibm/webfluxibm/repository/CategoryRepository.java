package com.apiwebfluxibm.webfluxibm.repository;

import com.apiwebfluxibm.webfluxibm.model.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CategoryRepository extends ReactiveMongoRepository<Category,String> {

    Flux<Category> findByNameContainingIgnoreCase(String name);

}
