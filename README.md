# Rick and Morty Backend 🔥
Este proyecto es una API REST construida con Spring Boot que permite buscar personajes de la serie **Rick and Morty** por nombre, consultando la API pública: https://rickandmortyapi.com/
y devolviendo información sobre el personaje y sus episodios.

## 🚀 Cómo consumir la ruta /characters
**GET** http://localhost:8081/characters?name=Rick 

**Query Params** : name

En el parámetro name escribir el personaje que desea ver sus datos.

## Respuesta esperada (200) ✔:
```json
[
  {
    "nombre": "Rick Sanchez",
    "estado": "Alive",
    "especie": "Human",
    "location": "Citadel of Ricks",
    "imagen": "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
    "episodios": [
      "Pilot - S01E01",
      ...
    ]
  }
]
```
## Personaje no encontrado (404) ❌:
```json
{"error":"No se encontro el personaje"}
```
