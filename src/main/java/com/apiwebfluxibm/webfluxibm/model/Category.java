package com.apiwebfluxibm.webfluxibm.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Document
@Data
public class Category implements Serializable {

    @Id
    private String id;
    @NotEmpty(message = "Campo NOME é requerido")
    @Length(min = 3, max = 100 , message = "O campo NOME deve ter entre 3 e 100 caracteres")
    private String name;

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
