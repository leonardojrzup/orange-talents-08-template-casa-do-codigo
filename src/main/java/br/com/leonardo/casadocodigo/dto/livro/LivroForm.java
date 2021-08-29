package br.com.leonardo.casadocodigo.dto.livro;

import br.com.leonardo.casadocodigo.modelo.Autor;
import br.com.leonardo.casadocodigo.modelo.Categoria;
import br.com.leonardo.casadocodigo.modelo.Livro;
import br.com.leonardo.casadocodigo.repositorio.LivroRepository;
import br.com.leonardo.casadocodigo.validacao.isUnique;
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
    @NotNull
    @Length(max = 500)
    private String resumo;
    @NotNull
    private String sumario;
    @Min(value = 20, message = "Preço deve ser no minimo 20")
    private BigDecimal preco;
    @Min(value = 100, message = "O numero de páginas deve ser no minimo 20")
    private Integer numeroPaginas;
    @isUnique(fieldName = "isbn", domainClass = Livro.class, message = "ISBN")
    @NotNull
    private String isbn;
    @Future
    private LocalDateTime dataPublicacao;
    @NotNull
    private Long idCategoria;
    @NotNull
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

 public Livro toModel(EntityManager entityManager) {

   @NotNull Categoria categoria = entityManager.find(Categoria.class, idCategoria);
   @NotNull Autor autor = entityManager.find(Autor.class, idAutor);

   Assert.state(Objects.nonNull(categoria),"Categoria não existente no banco de dados, por gentileza, salvar a categoria antes de salvar o livro. ID da categoria:"+idCategoria);
   Assert.state(Objects.nonNull(autor),"Autor não existente no banco de dados, por gentileza, salvar o autor antes de salvar o livro. ID do autor:"+idAutor);

   return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn,
              dataPublicacao, categoria, autor);
  }
}




