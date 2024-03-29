package com.creator.vini.estudanteapijava.repository;

import com.creator.vini.estudanteapijava.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    @Query(value = "SELECT c FROM Estudante c WHERE c.nome = :name", nativeQuery = false)
    Optional<Estudante> findByName(String name);

    @Query("SELECT c FROM Estudante c WHERE c.curso = :curso")
    List<Estudante> findByCurso(String curso);

    List<Estudante> findByNomeStartingWith(String nome);

    List<Estudante> findByNomeStartingWithAndCurso(String nome, String curso);

    List<Estudante> findByEnderecoStartingwithWithOrderByEnderecoDesc(String endereco);

    List<Estudante> findByIdLessThanEqual(Long id);
}