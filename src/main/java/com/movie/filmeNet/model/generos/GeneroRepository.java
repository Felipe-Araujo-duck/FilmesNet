package com.movie.filmeNet.model.generos;

import com.movie.filmeNet.model.filmes.FilmesDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneroRepository extends JpaRepository<GenerosDTO, Long> {
    List<GenerosDTO> findByIdGenero(Long idGenero);

}
