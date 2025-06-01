package com.alura.cursos.rickymorty.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({ "nombre", "estado", "especie", "location", "imagen", "episodios" })
public class Character {
    private String nombre;
    private String estado;
    private String especie;
    private String location;
    private String imagen;
    private List<String> episodios;

    public Character(DataCharacter d, List<String> episodios) {
        this.nombre = d.nombre();
        this.estado = d.estado();
        this.especie = d.especie();
        this.location = d.location().nombre();
        this.imagen = d.imagen();
        this.episodios = episodios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<String> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<String> episodios) {
        this.episodios = episodios;
    }


}
