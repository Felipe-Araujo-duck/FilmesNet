package com.movie.filmeNet.model.filmes;

import com.movie.filmeNet.model.generos.GenerosDTO;

public record CadastroFilme(String nome, GenerosDTO genero) {

}
