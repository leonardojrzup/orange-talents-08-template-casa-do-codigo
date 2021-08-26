package br.com.leonardo.casadocodigo.dto.autor;

import br.com.leonardo.casadocodigo.modelo.Autor;


//Classe que representa DTO, o autor que iremos exibir nos endpoints e listagens

public class AutorDTO {
    private String nome;
    private String email;
    private String descricao;

    public AutorDTO(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
//Metodo estatico que converte um autor como parametro para um DTO
    public static AutorDTO converterParaDTO(Autor autor) {
        return new AutorDTO(autor.getNome(), autor.getEmail(), autor.getDescricao());
    }
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
