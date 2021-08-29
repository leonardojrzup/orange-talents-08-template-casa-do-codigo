package br.com.leonardo.casadocodigo.dto.livro;

import br.com.leonardo.casadocodigo.dto.autor.AutorDTO;
import br.com.leonardo.casadocodigo.dto.categoria.CategoriaDTO;
import br.com.leonardo.casadocodigo.modelo.Livro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class detalheLivro {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDateTime dataPublicacao;
    private CategoriaDTO categoria;
    private AutorDTO autor;

    public detalheLivro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn, LocalDateTime dataPublicacao, CategoriaDTO categoria, AutorDTO autor) {
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

    public static detalheLivro toDTO(Livro livro) {

    return new detalheLivro(livro.getTitulo(), livro.getResumo(), livro.getSumario(), livro.getPreco(), livro.getNumeroPaginas(), livro.getIsbn(),livro.getDataPublicacao(),
            livro.getCategoria().converterParaDTO(),livro.getAutor().converterParaDTO());
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
