package br.com.leonardo.casadocodigo.controllers;


import br.com.leonardo.casadocodigo.dtos.autor.AutorDTO;
import br.com.leonardo.casadocodigo.dtos.autor.AutorForm;
import br.com.leonardo.casadocodigo.models.Autor;
import br.com.leonardo.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    EntityManager entityManager;

    @Autowired
    AutorRepository repository;

    //Salva o Autor no banco de dados e retorna um autorDTO do autor que foi cadastrado, juntamente com o status 200 (OK)
    @PostMapping
    public ResponseEntity<AutorDTO> Salvar(@RequestBody @Valid AutorForm form) {
        Autor autorSalvo = form.converterParaEntidade();
        repository.save(autorSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(autorSalvo.converterParaDTO());
    }
}
