package com.apiwebfluxibm.webfluxibm.controller;


import com.apiwebfluxibm.webfluxibm.dto.CategoryRequestDTO;
import com.apiwebfluxibm.webfluxibm.mapper.CategoryMapper;
import com.apiwebfluxibm.webfluxibm.model.Category;
import com.apiwebfluxibm.webfluxibm.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Retorna uma lista de categorias")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 200, message = "Retorna uma lista de categorias"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public Flux<CategoryRequestDTO> listAll() {
        return categoryMapper.categoriesRequestDTOToCategories(categoryService.findAll());
    }

    @GetMapping("/category/{id}")
    @ApiOperation(value = "Buscar categoria por id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 404, message = "Categoria Não existe"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public Mono<CategoryRequestDTO> findById(@PathVariable String id) {
        return  categoryMapper.categoryRequestDTOToCategory(categoryService.findById(id));
    }

    @GetMapping("/category/name/{name}")
    public Flux<CategoryRequestDTO> findByName(@PathVariable String name) {
        return  categoryMapper.categoriesRequestDTOToCategories(categoryService.findByName(name));
    }

    @PostMapping("/category")
    @ApiOperation(value = "Adiciona uma Categoria")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Categoria Cadastrada"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Category> insert(@Valid @RequestBody CategoryRequestDTO category) {
        return categoryService.save(categoryMapper.categoryToCategoryRequestDTO(category));
    }

    @PutMapping(path = "/category")
    @ApiOperation(value = "Atualiza uma Categoria")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Solicitação bem sucedida"),
            @ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui livros vinculados"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Categoria não existe"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Category> update(@Valid @RequestBody CategoryRequestDTO category) {
        return categoryService.update(categoryMapper.categoryToCategoryRequestDTO(category));
    }


    @DeleteMapping(path = "/category/{id}")
    @ApiOperation(value = "Deleta uma Categoria")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Solicitação bem sucedida"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Categoria não existe"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return categoryService.delete(id);
    }


}
