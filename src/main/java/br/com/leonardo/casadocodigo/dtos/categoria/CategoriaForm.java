package br.com.leonardo.casadocodigo.dtos.categoria;

import br.com.leonardo.casadocodigo.annotations.isUnique;
import br.com.leonardo.casadocodigo.models.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank(message = "Nome")
    @isUnique(fieldName = "nome", domainClass = Categoria.class, message = "Nome da categoria")
    private String nome;

    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public CategoriaForm() {
    }

    public Categoria converterParaEntidade() {
        return new Categoria(nome);
    }


    public String getNome() {
        return nome;
    }
}




