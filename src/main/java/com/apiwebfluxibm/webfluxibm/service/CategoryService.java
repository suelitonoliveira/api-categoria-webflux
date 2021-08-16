package com.apiwebfluxibm.webfluxibm.service;

import com.apiwebfluxibm.webfluxibm.model.Category;
import com.apiwebfluxibm.webfluxibm.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    public Flux<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Mono<Category> findById(String id) {
        return  categoryRepository.findById(id).switchIfEmpty(monoResponseStatusNotFoundException());
    }

    public Flux<Category> findByName(String name) {
        return  categoryRepository.findByNameContainingIgnoreCase(name);
    }


    public <T> Mono<T> monoResponseStatusNotFoundException() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    @Transactional
    public Mono<Category> save(Category category) {
        return categoryRepository.save(category);

    }

    @Transactional
    public Mono<Category> update(Category category) {
          return categoryRepository.
                  findById(category.getId())
                          .map(c -> new Category(category.getId(), category.getName()))
                                  .flatMap(categoryRepository::save);
    }

    public Mono<Void> delete(String id) {
        return findById(id)
                .flatMap(categoryRepository::delete);
     }

}


