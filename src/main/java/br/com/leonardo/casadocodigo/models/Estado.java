package br.com.leonardo.casadocodigo.models;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nome;
    @ManyToOne
    private
    Pais pais;

    @Deprecated
    public Estado() {

    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    //Validar se o Estado já está inserido para o pais.
    public void validarNomeDuplicadoPais(EntityManager entityManager) {
        Query query = entityManager.createQuery("SELECT e FROM "+ this.getClass().getName() +" e WHERE pais_id "+"= :value "+ "and e.nome " + "= :value2");
        query.setParameter("value",pais.getId());
        query.setParameter("value2",nome);
        List<?> list = query.getResultList();
        Assert.isTrue(list.isEmpty(), "Você ja possui um Estado com esse nome para esse Pais");
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public boolean pertenceAPais(Pais pais) {
        return this.pais.equals(pais);
    }

}