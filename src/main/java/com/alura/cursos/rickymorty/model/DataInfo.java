package com.alura.cursos.rickymorty.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataInfo(
        @JsonAlias("count") Integer encontrados) {
}
