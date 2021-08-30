package br.com.leonardo.casadocodigo.dto.pais;

import br.com.leonardo.casadocodigo.modelo.Pais;
import br.com.leonardo.casadocodigo.validacao.isUnique;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @isUnique(fieldName = "nome", domainClass = Pais.class, message = "Nome")
    @NotBlank(message = "Nome")
    private String nome;

    public String getNome() {
        return nome;
    }
}
