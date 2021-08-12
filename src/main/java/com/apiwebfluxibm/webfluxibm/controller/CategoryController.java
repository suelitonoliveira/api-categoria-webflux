package com.apiwebfluxibm.webfluxibm.controller;


import com.apiwebfluxibm.webfluxibm.dto.CategoryRequestDTO;
import com.apiwebfluxibm.webfluxibm.mapper.CategoryMapper;
import com.apiwebfluxibm.webfluxibm.model.Category;
import com.apiwebfluxibm.webfluxibm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping("/categories")
    public Flux<CategoryRequestDTO> listAll() {
        return categoryMapper.categoriesRequestDTOToCategories(categoryService.findAll());
    }

    @GetMapping("/category/{id}")
    public Mono<CategoryRequestDTO> findById(@PathVariable String id) {
        return  categoryMapper.categoryRequestDTOToCategory(categoryService.findById(id));
    }

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Category> insert(@Valid @RequestBody CategoryRequestDTO category) {
        return categoryService.save(categoryMapper.categoryToCategoryRequestDTO(category));
    }

    @PutMapping(path = "/category")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Category> update(@Valid @RequestBody CategoryRequestDTO category) {
        return categoryService.update(categoryMapper.categoryToCategoryRequestDTO(category));
    }


    @DeleteMapping(path = "/category/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return categoryService.delete(id);
    }


}
