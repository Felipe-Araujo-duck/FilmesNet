package com.movie.filmeNet.model.filmes;

import jakarta.persistence.*;

@Entity
@Table(name="filmesDTO")
public class FilmesDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String genero;

    public Long getId(){
        return id;
    }
    public String getNome() {
        return nome;
    }


    public String getGenero() {
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
