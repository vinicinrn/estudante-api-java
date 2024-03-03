package com.creator.vini.estudanteapijava.service;

import com.creator.vini.estudanteapijava.model.Estudante;
import com.creator.vini.estudanteapijava.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public Estudante criarEstudante(Estudante estudante){
        return estudanteRepository.save(estudante);
    }

    public List<Estudante> listarEstudante(){
        return estudanteRepository.findAll();
    }

    public ResponseEntity<Estudante> buscarEstudantePeloId(Long id){
        return estudanteRepository.findById(id)
                .map(estudante -> ResponseEntity.ok().body(estudante)) //map pra transformar obj estudante em um lambda
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Estudante> atualizarEstudantePeloID(Estudante estudante, Long id){
        return estudanteRepository.findById(id)
                .map(estudanteToUpdate -> {
                    estudanteToUpdate.setCurso(estudante.getCurso());
                    estudante.setEndereco(estudante.getEndereco());
                    estudanteToUpdate.setNome(estudante.getNome());
                    estudanteToUpdate.setMeioPagamento(estudante.getMeioPagamento());
                    Estudante updated = estudanteRepository.save(estudanteToUpdate);
                    return ResponseEntity.ok().body(estudante);

                }) .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> excluirEstudantePeloId(Long id){
        return estudanteRepository.findById(id)
                .map(estudanteToDelete -> {
                    estudanteRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }) .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Estudante> buscarEstudantePeloNome(String nome){
        return estudanteRepository.findByName(nome)
                .map(estudante -> ResponseEntity.ok().body(estudante))
                .orElse(ResponseEntity.notFound().build());
    }

    public List<Estudante> listarEstudantePeloCurso(String curso){
        return estudanteRepository.findByCurso(curso);
    }

}