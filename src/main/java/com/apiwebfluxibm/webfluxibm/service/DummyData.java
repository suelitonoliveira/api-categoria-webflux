/*
package com.apiwebfluxibm.webfluxibm.service;

import com.apiwebfluxibm.webfluxibm.model.Category;
import com.apiwebfluxibm.webfluxibm.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
@AllArgsConstructor
public class DummyData implements CommandLineRunner {

    private final CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {
        categoryRepository.deleteAll()
                .thenMany(
                        Flux.just("Ficcção Cientifica","Informática","Romance","Auto Ajuda")
                        .map(name -> new Category(UUID.randomUUID().toString(),name))
                        .flatMap(categoryRepository::save))
                .subscribe(System.out::println);
    }
}
*/
