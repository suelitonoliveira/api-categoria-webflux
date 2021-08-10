package com.apiwebfluxibm.webfluxibm.controller;


import com.apiwebfluxibm.webfluxibm.dto.CategoryRequestDTO;
import com.apiwebfluxibm.webfluxibm.dto.CategoryResponseDTO;
import com.apiwebfluxibm.webfluxibm.mapper.CategoryMapper;
import com.apiwebfluxibm.webfluxibm.model.Category;
import com.apiwebfluxibm.webfluxibm.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    private final CategoryMapper categoryMapper;

    @GetMapping("/categories")
    public Flux<CategoryRequestDTO> list() {
        return categoryMapper.categoriesRequestDTOToCategories(categoryService.findAll());
    }

    @GetMapping("/category/{id}")
    public CategoryResponseDTO findById(@PathVariable Long id) {
        return categoryMapper.categoryResponseDTOToEntity(categoryService.findById(id));
    }

    @PostMapping("/category")
    public Mono<Category> insert(@Valid @RequestBody CategoryRequestDTO category) {
        return categoryService.save(categoryMapper.categoryToCategoryRequestDTO(category));
    }

    @DeleteMapping(path = "/category/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/category")
    public ResponseEntity<Category> update(@Valid @RequestBody CategoryRequestDTO category) {
        categoryService.update(categoryMapper.categoryToCategoryRequestDTO(category));
        return ResponseEntity.noContent().build();
    }

}
