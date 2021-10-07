package br.com.leonardo.casadocodigo.dtos.autor;

import br.com.leonardo.casadocodigo.annotations.isUnique;
import br.com.leonardo.casadocodigo.models.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


//Classe que representa o autor que será enviado através de requisições.
public class AutorForm {

    @NotBlank(message = "Email")
    @Email(message = "Email")
    @isUnique(fieldName = "email", domainClass = Autor.class, message = "Email")
    private String email;


    @NotBlank(message = "Nome")
    private String nome;

    @NotBlank(message = "Descrição")
    @Size(min = 1, max = 400)
    private String descricao;

    //Converte um Autor form para autor
    public Autor converterParaEntidade() {
        return new Autor(nome, email, descricao);
    }


    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
