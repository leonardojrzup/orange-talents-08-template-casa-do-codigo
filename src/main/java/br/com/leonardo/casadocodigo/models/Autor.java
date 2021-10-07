package br.com.leonardo.casadocodigo.models;

import br.com.leonardo.casadocodigo.dtos.autor.AutorDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

//Classe que representa o autor com os metodos que são de resposabilidade dela

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataCriacao = LocalDateTime.now();
    }

    public Autor() {
    }

    //Converte um autor 'Entidade' para um autorDTO no qual iremos apresentar nas listagens
    public AutorDTO converterParaDTO(){
            return new AutorDTO(id, nome,email, descricao);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
