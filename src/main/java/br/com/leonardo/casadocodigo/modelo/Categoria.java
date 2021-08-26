package br.com.leonardo.casadocodigo.modelo;

import br.com.leonardo.casadocodigo.dto.categoria.CategoriaDTO;
import br.com.leonardo.casadocodigo.validacao.ValidarNomeDuplicado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaDTO converterParaDTO() {
        return new CategoriaDTO(nome);
    }
}


