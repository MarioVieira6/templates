package br.com.springboot.model;

import lombok.*;

/**
 * Objeto que contem os atributos de um livro.
 */
@EqualsAndHashCode(exclude = {"note"})
@ToString(includeFieldNames = true)
public class Book {

    @Getter
    @Setter
    private Long code;

    @Getter
    @Setter
    private String title;
    
    @Getter
    @Setter
    private String author;
    
    @Getter
    @Setter
    private String note;
}
