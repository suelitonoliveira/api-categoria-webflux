package com.apiwebfluxibm.webfluxibm.mapper;

import com.apiwebfluxibm.webfluxibm.dto.CategoryRequestDTO;
import com.apiwebfluxibm.webfluxibm.dto.CategoryResponseDTO;
import com.apiwebfluxibm.webfluxibm.model.Category;
import org.bson.json.Converter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryResponseDTO categoryResponseDTOToEntity(Mono<Category> category);

    Category categoryToDTO(CategoryResponseDTO categoryResponseDTO);

    Category categoryToCategoryRequestDTO(CategoryRequestDTO categoryRequestDTO);

    CategoryRequestDTO categoryRequestDTOToCategory(Category category);

    Flux<CategoryRequestDTO> categoriesRequestDTOToCategories(Flux<Category> category);

}
