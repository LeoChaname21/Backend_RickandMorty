package com.alura.cursos.rickymorty.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataCharacter(
        @JsonAlias("id") Integer id,
        @JsonAlias("name") String nombre,
        @JsonAlias("status") String estado,
        @JsonAlias("species") String especie,
        @JsonAlias("gender") String genero,
        @JsonAlias("image") String imagen,
        @JsonAlias("location") DataLocation location,
        @JsonAlias("episode") List<String> episodios){

}
