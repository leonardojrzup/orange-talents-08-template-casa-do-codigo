package br.com.leonardo.casadocodigo.dto.categoria;

import br.com.leonardo.casadocodigo.modelo.Categoria;
import br.com.leonardo.casadocodigo.validacao.ValidarNomeDuplicado;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank(message = "Nome")
    @ValidarNomeDuplicado(message = "Nome ")
    private String nome;

    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    public CategoriaForm() {
    }

    public Categoria converterParaEntidade() {
        return new Categoria(nome);
    }

    public CategoriaDTO converterParaDTO() {
        return new CategoriaDTO(nome);
    }

    public String getNome() {
        return nome;
    }
}




