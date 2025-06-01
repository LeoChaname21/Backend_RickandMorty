package com.alura.cursos.rickymorty.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataCharacters(
        @JsonAlias("info") DataInfo info,
        @JsonAlias("results") List<DataCharacter> character) {
}
