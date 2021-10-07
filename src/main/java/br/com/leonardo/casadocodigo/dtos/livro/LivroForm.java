package br.com.leonardo.casadocodigo.dtos.livro;

import br.com.leonardo.casadocodigo.models.Autor;
import br.com.leonardo.casadocodigo.models.Categoria;
import br.com.leonardo.casadocodigo.models.Livro;
import br.com.leonardo.casadocodigo.annotations.isUnique;
import br.com.leonardo.casadocodigo.repositories.AutorRepository;
import br.com.leonardo.casadocodigo.repositories.CategoriaRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class LivroForm {


    @NotBlank(message = "Titulo")
    @isUnique(fieldName = "titulo", domainClass = Livro.class, message = "Titulo")
    private String titulo;
    @NotNull(message = "Resumo")
    @Length(max = 500,message = "Resumo deve conter no máximo 500 Caracteres")
    private String resumo;
    @NotNull(message = "Sumario")
    private String sumario;
    @Min(value = 20, message = "Preço deve ser no minimo 20")
    private BigDecimal preco;
    @Min(value = 100, message = "O numero de páginas deve ser no minimo 20")
    private Integer numeroPaginas;
    @isUnique(fieldName = "isbn", domainClass = Livro.class, message = "ISBN")
    @NotNull(message = "ISBM")
    private String isbn;
    @Future
    private LocalDateTime dataPublicacao;
    @NotNull(message = "Categoria")
    private Long idCategoria;
    @NotNull(message = "Autor")
    private Long idAutor;


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

 public Long getIdCategoria() {
  return idCategoria;
 }

 public Long getIdAutor() {
  return idAutor;
 }

 public Livro toModel(CategoriaRepository categoriaRepository,AutorRepository autorRepository) {

   @NotNull Categoria categoria = categoriaRepository.findById(idCategoria).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada no banco de dados."));
   @NotNull Autor autor =  autorRepository.findById(idAutor).orElseThrow(() -> new IllegalArgumentException("Autor não encontrado no banco de dados."));

   return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn,
              dataPublicacao, categoria, autor);
  }
}




