/*
package com.apiwebfluxibm.webfluxibm.config;

import com.apiwebfluxibm.webfluxibm.model.Category;
import com.apiwebfluxibm.webfluxibm.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.UUID;

@Configuration
public class DummyData implements CommandLineRunner {


    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {
        categoryRepository.deleteAll()
                .thenMany(
                        Flux.just("Ficcção Cientifica", "Informática", "Romance", "Auto Ajuda", "Romance")
                                .map(name -> new Category(UUID.randomUUID().toString(), name))
                                .flatMap(categoryRepository::save))
                .subscribe(System.out::println);

}
*/
