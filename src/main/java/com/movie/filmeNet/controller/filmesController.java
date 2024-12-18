package com.movie.filmeNet.controller;


import com.movie.filmeNet.model.filmes.CadastroFilme;
import com.movie.filmeNet.model.filmes.DadosAlteracaoFilme;
import com.movie.filmeNet.model.filmes.FilmesDTO;
import com.movie.filmeNet.model.filmes.FilmesRepository;
import com.movie.filmeNet.model.generos.GeneroRepository;
import com.movie.filmeNet.model.generos.GenerosDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class filmesController {

    @Autowired
    private FilmesRepository repository;
    @Autowired
    private GeneroRepository repositoryGenero;

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

    @DeleteMapping
    @Transactional
    public String removeFilme(Long id) {
        repository.deleteById(id);
        return "redirect:/filmes/lista";
    }

    @GetMapping("/formulario")
    public String carregaFormulario(Long id, Model model){
        if(id != null){
            FilmesDTO F1 = repository.getReferenceById(id);
            model.addAttribute("filmesDTO", F1);
        }
        model.addAttribute("listaGenero", repositoryGenero.findAll());
        return "/filmes/formulario";
    }

    @PutMapping("/formulario")
    @Transactional
    public String alterarFilme(DadosAlteracaoFilme dados){
        FilmesDTO filme = repository.getReferenceById((dados.id()));
        filme.atualizaDados(dados);
        repository.save(filme);
        return "redirect:/filmes/lista";
    }

    @GetMapping("/maiorgenero")
    public  String buscarGeneroComMaisFilmes(Model model)
    {
        //List<GenerosDTO> generosDTOList = repository.findGeneroWithMostFilmes();
        //GenerosDTO g1 = generosDTOList.get(0);
        Long idGenero = repository.GeneroWithMostFilmes();
        GenerosDTO genero = repositoryGenero.findById(idGenero).orElse(null);
        if(idGenero != null)
        {
            List<FilmesDTO> filmesDTOList = repository.findByGenero_IdGenero(idGenero);
            model.addAttribute("filmes", filmesDTOList);
            model.addAttribute("nomeGenero", genero.getNomeGenero());
        }
        model.addAttribute("listaGenero", repositoryGenero.findAll());
        return "/filmes/maiorgenero";
    }

}
