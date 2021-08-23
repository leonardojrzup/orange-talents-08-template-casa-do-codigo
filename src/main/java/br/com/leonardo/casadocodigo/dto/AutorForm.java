package br.com.leonardo.casadocodigo.dto;

import br.com.leonardo.casadocodigo.modelo.Autor;
import br.com.leonardo.casadocodigo.repositorio.AutorRepositorio;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AutorForm {

    @NotBlank(message = "email")
    @Email
    private String email;

    @NotBlank(message = "Nome")
    private String nome;

    @NotBlank(message = "Descrição")
    @Size(min = 1, max = 400)
    private String descricao;

        public Autor converterParaEntidade( ) {
            return new Autor(nome,email, descricao);
        }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
