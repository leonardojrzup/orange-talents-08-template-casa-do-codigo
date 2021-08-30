package br.com.leonardo.casadocodigo.dto.cliente;

import br.com.leonardo.casadocodigo.modelo.*;
import br.com.leonardo.casadocodigo.validacao.Documento;
import br.com.leonardo.casadocodigo.validacao.isUnique;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.beans.XMLEncoder;
import java.util.List;
import java.util.Objects;

public class ClienteForm {

    @Email
    @NotBlank(message = "email")
    @isUnique(fieldName = "email", domainClass = Autor.class, message = "Email")
    private String email;

    @NotBlank(message = "nome")
    private String nome;

    @NotBlank(message = "Sobrenome")
    private String sobrenome;

    @NotBlank(message = "Documento")
    @isUnique(fieldName = "documento", domainClass = Cliente.class, message = "Documento")
    @Documento
    private String documento;

    @NotBlank(message = "Endereço")
    private String endereco;

    @NotBlank(message = "Complemento")
    private String complemento;

    @NotBlank(message = "Telefone")
    private String telefone;

    @NotBlank(message = "Cep")
    private String cep;

    @NotNull(message = "Pais")
    private Long idPais;

    private Long idEstado;


    public ClienteForm(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String telefone, String cep, Long idPais, Long idEstado) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.telefone = telefone;
        this.cep = cep;
        this.idPais = idPais;
        this.idEstado = idEstado;
    }


    public Cliente toModel(EntityManager entityManager) {

        if (temEstado(entityManager)){
                @NotNull Pais pais = entityManager.find(Pais.class, idPais);
                @NotNull Estado estado = entityManager.find(Estado.class, idEstado);

                Assert.state(Objects.nonNull(pais),"Pais não existente no banco de dados, por gentileza, salvar a categoria antes de salvar o livro. ID da categoria:"+idPais);
                Assert.state(Objects.nonNull(estado),"Estado não existente no banco de dados, por gentileza, salvar o autor antes de salvar o livro. ID do autor:"+idEstado);

                return new Cliente(email,nome, sobrenome, documento,endereco, complemento,
                        telefone, cep, pais,estado);
            }else{

                         @NotNull Pais pais = entityManager.find(Pais.class, idPais);
                         Assert.state(Objects.nonNull(pais),"Pais não existente no banco de dados, por gentileza, salvar a categoria antes de salvar o livro. ID da categoria:"+idPais);

            return new Cliente(email,nome, sobrenome, documento,endereco, complemento,
                    telefone, cep, pais);
        }

    }

    public boolean temEstado(EntityManager manager) {
        Query query = manager.createQuery("SELECT e FROM " + Estado.class.getName() + " e WHERE pais_id " + "= :value ");
        query.setParameter("value", idPais);
        List<?> list = query.getResultList();
        if (list.isEmpty()) {
            return false;
        } else {
            return true;

        }
    }
}