package com.creator.vini.estudanteapijava.controller;

import com.creator.vini.estudanteapijava.model.Estudante;
import com.creator.vini.estudanteapijava.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class EstudanteController {

    @Autowired //dependency injection
    private EstudanteService estudanteService;

    @PostMapping("/estudantes")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudante criarEstudante(@RequestBody Estudante estudante){ //RequestBody pq vai receber alguma info
        return estudanteService.criarEstudante(estudante);
    }

    @GetMapping("/estudantes")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarEstudantes (){
        return estudanteService.listarEstudante();
    }


    @GetMapping("/estudantes/{id}") //pegar o ID especifico, usar @PathVariable
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> listarEstudantes (@PathVariable(value = "id") Long id){
        return estudanteService.buscarEstudantePeloId(id);
    }

    @PutMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> atualizarEstudantePeloId (@PathVariable(value = "id") Long id, @RequestBody Estudante estudante){
        return estudanteService.atualizarEstudantePeloID(estudante, id);
    }

    @DeleteMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> excluirEstudantePeloId (@PathVariable(value ="id") Long id){
        return estudanteService.excluirEstudantePeloId(id);
    }

    @GetMapping("/estudantes/nome/{nome}") //pegar o NOME especifico, usar @PathVariable
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> buscarEstudantePeloNome (@PathVariable(value = "nome") String nome){
        return estudanteService.buscarEstudantePeloNome(nome);
    }

    @GetMapping("/estudantes/curso") //pegar o NOME especifico, usar @PathVariable
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> buscarEstudantePeloCurso (@RequestParam String nome_curso){
        return estudanteService.listarEstudantePeloCurso(nome_curso);
    }



}
