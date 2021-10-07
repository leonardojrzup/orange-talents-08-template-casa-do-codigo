package br.com.leonardo.casadocodigo.dtos.cliente;

import br.com.leonardo.casadocodigo.annotations.isUnique;
import br.com.leonardo.casadocodigo.dtos.pais.PaisDTO;
import br.com.leonardo.casadocodigo.models.Autor;
import br.com.leonardo.casadocodigo.models.Cliente;
import br.com.leonardo.casadocodigo.models.Pais;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private PaisDTO pais;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.email = cliente.getEmail();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getNome();
        this.pais = new PaisDTO(cliente.getPais());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public PaisDTO getPais() {
        return pais;
    }
}
