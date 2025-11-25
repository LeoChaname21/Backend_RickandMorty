package com.alura.cursos.rickymorty.controller;

import com.alura.cursos.rickymorty.model.Character;
import com.alura.cursos.rickymorty.model.DataCharacters;
import com.alura.cursos.rickymorty.model.DataEpisode;
import com.alura.cursos.rickymorty.service.ConsumoAPI;
import com.alura.cursos.rickymorty.service.ConversorData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/characters")
public class CharacterController {

    ConsumoAPI api = new ConsumoAPI();
    ConversorData conv = new ConversorData();
    String URL = "https://rickandmortyapi.com/api/character/?name=";

    @GetMapping
    public List<Character> character(@RequestParam String name){
        try {
            var json = api.getdata(URL + name.replace(" ", "+"));
            var datos = conv.getData(json, DataCharacters.class);

            List<String> datosEpisode = datos.character().stream()
                    .limit(1)
                    .flatMap(e -> e.episodios().stream())
                    .collect(Collectors.toList());

            List<String> episodes = datosEpisode.parallelStream()
                    .map(e -> {
                        var jsonepisode = api.getdata(e);
                        var datosE = conv.getData(jsonepisode, DataEpisode.class);
                        return datosE.nombre() +" - "+datosE.episodio();
                    })
                    .collect(Collectors.toList());

            List<Character> datosCharacter = datos.character().stream()
                    .limit(1)
                    .map(t->new Character(t,episodes))
                    .collect(Collectors.toList());

            return datosCharacter;
        }  catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el personaje", e);
    }
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, String>> handleError(ResponseStatusException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getReason());
        return new ResponseEntity<>(error, ex.getStatusCode());
    }

}
