package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BookRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String author;
    @NotNull
    private Double price;
    @NotEmpty
    @NotNull
    @NotBlank
    private String isbn;
    @NotEmpty
    private String classification;
}
