package br.com.leonardo.casadocodigo.dtos.estado;

import br.com.leonardo.casadocodigo.dtos.pais.PaisDTO;
import br.com.leonardo.casadocodigo.models.Estado;
import br.com.leonardo.casadocodigo.models.Pais;

public class EstadoDTO {

    private Long id;
    private String nome;
    private PaisDTO paisDTO;


    public EstadoDTO(Long id,String nome, PaisDTO paisDTO) {
        this.id = id;
        this.nome = nome;
        this.paisDTO = paisDTO;
    }

    public EstadoDTO(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.paisDTO = new PaisDTO(estado.getPais());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PaisDTO getPaisDTO() {
        return paisDTO;
    }
}
