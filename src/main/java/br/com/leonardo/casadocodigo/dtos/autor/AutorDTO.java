package br.com.leonardo.casadocodigo.dtos.autor;

import br.com.leonardo.casadocodigo.models.Autor;


//Classe que representa DTO, o autor que iremos exibir nos endpoints e listagens

public class AutorDTO {
    private Long id;
    private String nome;
    private String email;
    private String descricao;

    public AutorDTO(Long id,String nome, String email, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
//Metodo estatico que converte um autor como parametro para um DTO
public static AutorDTO converterParaDTO(Autor autor) {
    return new AutorDTO(autor.getId(),autor.getNome(), autor.getEmail(), autor.getDescricao());
}

    public Long getId() {return id;}

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
