package com.apiwebfluxibm.webfluxibm.mapper;

import com.apiwebfluxibm.webfluxibm.dto.CategoryRequestDTO;
import com.apiwebfluxibm.webfluxibm.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category categoryToCategoryRequestDTO(CategoryRequestDTO categoryRequestDTO);

    default Mono<CategoryRequestDTO> categoryRequestDTOToCategory(Mono<Category> category){
        return category.map(this::map);
    }

    default Flux<CategoryRequestDTO> categoriesRequestDTOToCategories(Flux<Category> category){
        return category.map(this::map);
    }

    CategoryRequestDTO map(Category category);
}
