package br.com.leonardo.casadocodigo.dto.livro;

import br.com.leonardo.casadocodigo.dto.autor.AutorDTO;
import br.com.leonardo.casadocodigo.dto.categoria.CategoriaDTO;
import br.com.leonardo.casadocodigo.modelo.Autor;
import br.com.leonardo.casadocodigo.modelo.Categoria;
import br.com.leonardo.casadocodigo.modelo.Livro;
import br.com.leonardo.casadocodigo.validacao.isUnique;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LivroDTO {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDateTime dataPublicacao;
    private CategoriaDTO categoria;
    private AutorDTO autor;

    public LivroDTO(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn, LocalDateTime dataPublicacao, CategoriaDTO categoria, AutorDTO autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public static LivroDTO toDTO(Livro produto) {

    return new LivroDTO(produto.getTitulo(), produto.getResumo(), produto.getSumario(), produto.getPreco(), produto.getNumeroPaginas(), produto.getIsbn(),produto.getDataPublicacao(),
            produto.getCategoria().converterParaDTO(),produto.getAutor().converterParaDTO());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public AutorDTO getAutor() {
        return autor;
    }
}
