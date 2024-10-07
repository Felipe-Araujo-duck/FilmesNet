package com.movie.filmeNet.controller;


import com.movie.filmeNet.model.filmes.CadastroFilme;
import com.movie.filmeNet.model.filmes.FilmesDTO;
import com.movie.filmeNet.model.filmes.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class filmesController {

    @Autowired
    private FilmesRepository repository;

    @GetMapping("/formulario")
    public String carregaFilmes()
    {
        return "filmes/formulario";
    }

    @GetMapping("/lista")
    public String listaFilmes(Model model){
        model.addAttribute("lista", repository.findAll());
        return "/filmes/listagem";
    }

    @PostMapping("/formulario")
    public String cadastraFilme(CadastroFilme dados)
    {
        FilmesDTO F1 = new FilmesDTO(dados);
        repository.save(F1);
        return "redirect:/filmes/lista";
    }

}
