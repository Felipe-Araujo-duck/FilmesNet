package com.movie.filmeNet.controller;

import com.movie.filmeNet.model.filmes.CadastroFilme;
import com.movie.filmeNet.model.filmes.DadosAlteracaoFilme;
import com.movie.filmeNet.model.filmes.FilmesDTO;
import com.movie.filmeNet.model.filmes.FilmesRepository;
import com.movie.filmeNet.model.generos.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/generos")
public class generoController {
    @Autowired
    private GeneroRepository repository;

    @Autowired
    private FilmesRepository filmesRepository;

    @GetMapping("/lista")
    public String listaGeneros(Model model){
        model.addAttribute("lista", repository.findAll());
        return "/generos/listagem";
    }

    @GetMapping("/filmes")
    public String listaFilmeByGenero(Model model, Long idGenero) {
        if(idGenero != null){
            model.addAttribute("filmes", filmesRepository.findByGenero_IdGenero(idGenero));
        }
        model.addAttribute("listaGenero", repository.findAll());
        return "/generos/listaFilmes";
    }

    @PostMapping("/formulario")
    public String cadastraGenero(CadastroGenero dados)
    {
        GenerosDTO G1 = new GenerosDTO(dados);
        repository.save(G1);
        return "redirect:/generos/lista";
    }

    @DeleteMapping
    @Transactional
    public String removeGenero(Long id) {
        repository.deleteById(id);
        return "redirect:/generos/lista";
    }

    @GetMapping("/formulario")
    public String carregaFormulario(Long id, Model model){
        if(id != null){
            GenerosDTO G1 = repository.getReferenceById(id);
            model.addAttribute("generosDTO", G1);
        }
        return "/generos/formulario";
    }

    @PutMapping("/formulario")
    @Transactional
    public String alterarGenero(DadosAlteracaoGenero dados){
        GenerosDTO G1 = repository.getReferenceById((dados.id()));
        G1.atualizaDados(dados);
        repository.save(G1);
        return "redirect:/generos/lista";
    }
}
