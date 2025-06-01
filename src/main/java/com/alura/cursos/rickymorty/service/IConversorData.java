package com.alura.cursos.rickymorty.service;

public interface IConversorData {

    <T> T getData(String json, Class<T> clase);
}
