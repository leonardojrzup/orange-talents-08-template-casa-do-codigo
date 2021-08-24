package br.com.leonardo.casadocodigo.dto;

import br.com.leonardo.casadocodigo.validação.ValidarEmailDuplicado;
import br.com.leonardo.casadocodigo.modelo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


//Classe que representa o autor que será enviado através de requisições.
public class AutorForm {

    @NotBlank(message = "email")
    @Email
    @ValidarEmailDuplicado
    private String email;

    @NotBlank(message = "Nome")
    private String nome;

    @NotBlank(message = "Descrição")
    @Size(min = 1, max = 400)
    private String descricao;

        //Converte um Autor form para autor
        public Autor converterParaEntidade( ) {
            return new Autor(nome,email, descricao);
        }

        //conhverte um autor form para DTO
        public AutorDTO converterParaDTO( ) {return new AutorDTO(nome,email, descricao);
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
