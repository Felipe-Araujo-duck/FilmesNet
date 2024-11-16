package com.movie.filmeNet.model.filmes;

import com.movie.filmeNet.model.generos.GenerosDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmesRepository extends JpaRepository<FilmesDTO, Long>{
    List<FilmesDTO> findByGenero_IdGenero(Long idGenero);

    //JQL
    @Query("SELECT f.genero FROM FilmesDTO f GROUP BY f.genero ORDER BY COUNT(f) DESC")
    List<GenerosDTO> findGeneroWithMostFilmes();

    //Native Query
    @Query(value = "SELECT g.id_genero FROM generosDTO g " +
                    "JOIN filmesDTO f ON f.id_genero " +
                    "GROUP BY g.id_genero " +
                    "ORDER BY COUNT(f.id) DESC " +
                    "LIMIT 1", nativeQuery = true)
    Long GeneroWithMostFilmes();

}
