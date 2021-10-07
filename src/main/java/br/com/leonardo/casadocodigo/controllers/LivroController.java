package br.com.leonardo.casadocodigo.controllers;


import br.com.leonardo.casadocodigo.dtos.livro.LivroDTO;
import br.com.leonardo.casadocodigo.dtos.livro.LivroDetalhe;
import br.com.leonardo.casadocodigo.dtos.livro.LivroForm;
import br.com.leonardo.casadocodigo.models.Livro;
import br.com.leonardo.casadocodigo.repositories.AutorRepository;
import br.com.leonardo.casadocodigo.repositories.CategoriaRepository;
import br.com.leonardo.casadocodigo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @GetMapping
    public List<LivroDTO> Listar() {
        List<Livro> resultado = (List<Livro>) livroRepository.findAll();

        List<LivroDTO> resultadoDTO = resultado.stream()
                .map(produto -> LivroDTO.toDTO(produto))
                .collect(Collectors.toList());
        return resultadoDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalhe> detalhe(@PathVariable Long id) {
        Optional<Livro> resultado = livroRepository.findById(id);
        return resultado.isPresent() ? ResponseEntity.ok(LivroDetalhe.toDTO(resultado.get()))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvar(@RequestBody @Valid LivroForm livro) {
        Livro novoLivro = livro.toModel(categoriaRepository, autorRepository);
        livroRepository.save(novoLivro);
        return ResponseEntity.status(HttpStatus.OK).body(new LivroDTO(novoLivro));

    }
}