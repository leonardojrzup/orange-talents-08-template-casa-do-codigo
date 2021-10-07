package br.com.leonardo.casadocodigo.dtos.cliente;

import br.com.leonardo.casadocodigo.models.*;
import br.com.leonardo.casadocodigo.annotations.Documento;
import br.com.leonardo.casadocodigo.annotations.isUnique;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
            if(Objects.isNull(idEstado)){
                Assert.state(Objects.nonNull(idEstado),"Estado é obrigatorio para este pais");
            }

            Pais pais = entityManager.find(Pais.class, idPais);
            Estado estado = entityManager.find(Estado.class, idEstado);
            Assert.state(Objects.isNull(idEstado),"Estádo inválido"); // Em caso de nullpointer

            if (!estado.pertenceAPais(pais)) {
                Assert.state(Objects.nonNull(idEstado),"Estado não pertence a Essa pais");
            }else{
                return new Cliente(email,nome,sobrenome,documento,endereco,complemento,telefone,cep, pais,estado);
            }
        }
        Pais pais = entityManager.find(Pais.class, idPais);
        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, telefone, cep, pais);
    }

    //Valida se o pais tem estados cadastrados no banco de dados
    public boolean temEstado(EntityManager manager) {
        @NotNull Pais pais = manager.find(Pais.class, idPais);
        Assert.state(Objects.nonNull(pais),"Pais não existente no banco de dados, por gentileza, salvar o pais antes de salvar Estado. ID do pais:"+idPais);
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