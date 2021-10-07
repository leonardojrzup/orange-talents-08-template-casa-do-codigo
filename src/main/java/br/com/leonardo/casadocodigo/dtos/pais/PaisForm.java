package br.com.leonardo.casadocodigo.dtos.pais;

import br.com.leonardo.casadocodigo.models.Pais;
import br.com.leonardo.casadocodigo.annotations.isUnique;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @isUnique(fieldName = "nome", domainClass = Pais.class, message = "Nome")
    @NotBlank(message = "Nome")
    private String nome;

    public String getNome() {
        return nome;
    }
}
