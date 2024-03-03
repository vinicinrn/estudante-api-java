package com.creator.vini.estudanteapijava.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "estudante")
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false, length = 30)
    private String endereco;
    @Column(nullable = false)
    private Long meioPagamento;
    @Column(nullable = false)
    private String curso;

    @CreationTimestamp
    @Column(name="criado em", nullable = false, updatable = false)
    private LocalDateTime criadoEm;

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    @UpdateTimestamp
    @Column(name="atualizado em", nullable = false)
    private LocalDateTime atualizadoEm;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(Long meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
