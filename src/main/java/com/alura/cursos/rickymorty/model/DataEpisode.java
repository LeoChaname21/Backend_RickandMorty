package com.alura.cursos.rickymorty.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataEpisode(
    @JsonAlias("id") Integer id,
    @JsonAlias("name") String nombre,
    @JsonAlias("episode") String episodio
) {
}
