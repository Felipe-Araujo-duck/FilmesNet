package com.movie.filmeNet.model.generos;

import com.movie.filmeNet.model.filmes.DadosAlteracaoFilme;
import com.movie.filmeNet.model.filmes.FilmesDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="generosDTO")
public class GenerosDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenero;
    private String nomeGenero;

    @OneToMany(mappedBy = "genero")
    private List<FilmesDTO> listaFilmes = new ArrayList<>();


    public Long getIdGenero() {
        return idGenero;
    }


    public List<FilmesDTO> getListaFilmes() {
        return listaFilmes;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public GenerosDTO(CadastroGenero genero) {
        this.nomeGenero = genero.nomeGenero();
    }

    public void atualizaDados(DadosAlteracaoGenero dados){
        this.nomeGenero = dados.nomeGenero();
    }

    public GenerosDTO() {}

}
