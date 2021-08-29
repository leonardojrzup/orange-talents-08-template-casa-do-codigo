package br.com.leonardo.casadocodigo.controle;


import br.com.leonardo.casadocodigo.dto.autor.AutorDTO;
import br.com.leonardo.casadocodigo.dto.livro.LivroForm;
import br.com.leonardo.casadocodigo.modelo.Categoria;
import br.com.leonardo.casadocodigo.modelo.Livro;
import br.com.leonardo.casadocodigo.repositorio.AutorRepository;
import br.com.leonardo.casadocodigo.repositorio.CategoriaRepository;
import br.com.leonardo.casadocodigo.repositorio.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroControlador {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

@PostMapping
@Transactional
    public ResponseEntity<Livro> salvar(@RequestBody @Valid LivroForm livro){
        Livro novoLivro = livro.toModel(entityManager);
        entityManager.persist(novoLivro);
     return ResponseEntity.status(HttpStatus.OK).body(novoLivro);


    }
}