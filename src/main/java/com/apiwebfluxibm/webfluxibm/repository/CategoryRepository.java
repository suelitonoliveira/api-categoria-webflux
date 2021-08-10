package com.apiwebfluxibm.webfluxibm.repository;

import com.apiwebfluxibm.webfluxibm.model.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category,Long> {
}
