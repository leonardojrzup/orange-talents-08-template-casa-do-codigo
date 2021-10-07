package br.com.leonardo.casadocodigo.dtos.categoria;

import br.com.leonardo.casadocodigo.models.Categoria;

public class CategoriaDTO {

    private Long id;
    private String nome;


    public CategoriaDTO(){

    }

    public CategoriaDTO(Long id, String nome) {;
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static CategoriaDTO converterParaCategoriaDTO(Categoria categoria) {
        return new CategoriaDTO(categoria.getId(),categoria.getNome());
    }

}

