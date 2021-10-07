package br.com.leonardo.casadocodigo.models;

import br.com.leonardo.casadocodigo.dtos.categoria.CategoriaDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Categoria() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaDTO converterParaDTO() {
        return new CategoriaDTO(id,nome);
    }
}


