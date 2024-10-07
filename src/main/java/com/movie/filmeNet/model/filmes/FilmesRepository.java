package com.movie.filmeNet.model.filmes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmesRepository extends JpaRepository<FilmesDTO, Long> {
}
