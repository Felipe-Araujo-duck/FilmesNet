package com.movie.filmeNet.model.filmes;

import com.movie.filmeNet.model.generos.GenerosDTO;

public record DadosAlteracaoFilme(Long id, String nome, GenerosDTO genero) {
}
