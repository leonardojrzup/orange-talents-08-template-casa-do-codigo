package br.com.leonardo.casadocodigo.dto.estado;

import br.com.leonardo.casadocodigo.modelo.Autor;
import br.com.leonardo.casadocodigo.modelo.Categoria;
import br.com.leonardo.casadocodigo.modelo.Estado;
import br.com.leonardo.casadocodigo.modelo.Pais;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class EstadoForm {

    @NotBlank(message = "Nome")
    private String nome;

     @NotNull(message = "Pais")
     private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Estado toModel(EntityManager entityManager) {
        @NotNull Pais pais = entityManager.find(Pais.class, idPais);
        Assert.state(Objects.nonNull(pais),"Pais não existente no banco de dados, por gentileza, salvar o pais antes de salvar Estado. ID do pais:"+idPais);
        return new Estado(nome, entityManager.find(Pais.class, idPais));
    }
}
