package com.apiwebfluxibm.webfluxibm.service;

import com.apiwebfluxibm.webfluxibm.model.Category;
import com.apiwebfluxibm.webfluxibm.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public Flux<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Mono<Category> findById(Long id) {
        return  categoryRepository.findById(id)
                .switchIfEmpty(monoResponseStatusNotFoundException());
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
        findById(category.getId());
        return categoryRepository.save(category);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
             categoryRepository.deleteById(id);
     }

}
