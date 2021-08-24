package br.com.leonardo.casadocodigo.controle;


import br.com.leonardo.casadocodigo.dto.AutorForm;
import br.com.leonardo.casadocodigo.modelo.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/Autor")
public class AutorControlador {

    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<Autor> Salvar (@RequestBody @Valid AutorForm form){
        Autor autorSalvo = form.converterParaEntidade();
        entityManager.persist(autorSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(autorSalvo);
    }
}
