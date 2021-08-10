package com.apiwebfluxibm.webfluxibm.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Category implements Serializable {

    @Id
    private Long id;
    @NotEmpty(message = "Campo NOME é requerido")
    @Length(min = 3, max = 100 , message = "O campo NOME deve ter entre 3 e 100 caracteres")
    private String name;

}
