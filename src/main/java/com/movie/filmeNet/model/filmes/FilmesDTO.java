package com.movie.filmeNet.model.filmes;

import com.movie.filmeNet.model.generos.GenerosDTO;
import jakarta.persistence.*;

@Entity
@Table(name="filmesDTO")
public class FilmesDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "idGenero")
    private GenerosDTO genero;

    public Long getId(){
        return id;
    }
    public String getNome() {
        return nome;
    }


    public GenerosDTO getGenero() {
        return genero;
    }

    public FilmesDTO(CadastroFilme dados){
        this.nome = dados.nome();
        this.genero = dados.genero();
    }

    public FilmesDTO(){}

    public void atualizaDados(DadosAlteracaoFilme dados){
        this.nome = dados.nome();
        this.genero = dados.genero();
    }

    @Override
    public String toString(){
        return "Filmes{" +
                "nome='" + nome + '\''+
                ", genero='"+ genero + '\'' +
                '}';
    }
}
