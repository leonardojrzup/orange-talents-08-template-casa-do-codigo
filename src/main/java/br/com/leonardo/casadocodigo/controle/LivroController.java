package br.com.leonardo.casadocodigo.controle;


import br.com.leonardo.casadocodigo.dto.livro.LivroDTO;
import br.com.leonardo.casadocodigo.dto.livro.LivroDetalhe;
import br.com.leonardo.casadocodigo.dto.livro.LivroForm;
import br.com.leonardo.casadocodigo.modelo.Livro;
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
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public List<LivroDTO> Listar(){
        List<Livro> resultado = (List<Livro>) livroRepository.findAll();

        List<LivroDTO> resultadoDTO =  resultado.stream()
                .map(produto -> LivroDTO.toDTO(produto))
                .collect(Collectors.toList());
        return resultadoDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalhe> detalhe(@PathVariable Long id){
        Optional<Livro> resultado = livroRepository.findById(id);
        return resultado.isPresent() ? ResponseEntity.ok(LivroDetalhe.toDTO(resultado.get()))
                : ResponseEntity.notFound().build();
    }

@PostMapping
@Transactional
@ResponseStatus(HttpStatus.OK)
    public void salvar(@RequestBody @Valid LivroForm livro){
        Livro novoLivro = livro.toModel(entityManager);
        entityManager.persist(novoLivro);
    }
}