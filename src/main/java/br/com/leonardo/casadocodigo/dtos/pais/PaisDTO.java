package br.com.leonardo.casadocodigo.dtos.pais;

import br.com.leonardo.casadocodigo.models.Pais;

public class PaisDTO {

    private Long id;
    private String nome;

    public PaisDTO(Pais novoPais) {
        this.id = novoPais.getId();
        this.nome = novoPais.getNome();
    }

    public String getNome() {
        return nome;
    }
    public Long getId() {return id;
    }
}
