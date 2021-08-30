package br.com.leonardo.casadocodigo.modelo;

import br.com.leonardo.casadocodigo.validacao.Documento;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank(message = "email")
    private String email;

    @NotBlank (message = "nome")
    private String nome;

    @NotBlank(message = "Sobrenome")
    private String sobrenome;

    @Documento
    @NotBlank(message = "Documento")
    private String documento;

    @NotBlank(message = "Endereço")
    private String endereco;

    @NotBlank(message = "Complemento")
    private String complemento;

    @ManyToOne
    @NotNull(message = "Pais")
    private Pais pais;

    @NotBlank(message = "Telefone")
    private String telefone;

    @NotBlank(message = "Cep")
    private String cep;

    @ManyToOne
    private Estado estado;

    public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String telefone, String cep, Pais pais, Estado estado) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
        this.estado = estado;
    }

    public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String telefone, String cep, Pais pais) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public Pais getPais() {
        return pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Estado getEstado() {
        return estado;
    }

    public boolean temEstado(EntityManager manager) {
        Query query = manager.createQuery("SELECT e FROM " + this.estado.getClass().getName() + " e WHERE pais_id " + "= :value ");
        query.setParameter("value", pais.getId());
        List<?> list = query.getResultList();
        if (list.isEmpty()) {
            return false;
        } else {
            return true;

        }


    }

}
