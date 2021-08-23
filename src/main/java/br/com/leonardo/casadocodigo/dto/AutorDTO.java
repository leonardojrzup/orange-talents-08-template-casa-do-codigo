package br.com.leonardo.casadocodigo.dto;

import br.com.leonardo.casadocodigo.modelo.Autor;

public class AutorDTO {


    private String nome;
    private String email;
    private String descricao;

    public AutorDTO(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
    }

}
