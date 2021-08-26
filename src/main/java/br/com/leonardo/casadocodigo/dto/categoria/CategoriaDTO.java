package br.com.leonardo.casadocodigo.dto.categoria;

import br.com.leonardo.casadocodigo.modelo.Categoria;

public class CategoriaDTO {

    private String nome;


    public CategoriaDTO(){

    }

    public CategoriaDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static CategoriaDTO converterParaCategoriaDTO(Categoria categoria) {
        return new CategoriaDTO(categoria.getNome());
    }

}

