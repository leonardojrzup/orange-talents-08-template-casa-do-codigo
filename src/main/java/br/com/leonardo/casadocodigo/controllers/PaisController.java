package br.com.leonardo.casadocodigo.controllers;


import br.com.leonardo.casadocodigo.dtos.pais.PaisDTO;
import br.com.leonardo.casadocodigo.dtos.pais.PaisForm;
import br.com.leonardo.casadocodigo.models.Pais;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class PaisController {

        @PersistenceContext
        private EntityManager manager;

        @PostMapping(value = "/paises")
        @Transactional
        public ResponseEntity<?> Salvar(@RequestBody @Valid PaisForm pais) {
            Pais novoPais = new Pais(pais.getNome());
            manager.persist(novoPais);
            return ResponseEntity.status(HttpStatus.OK).body(new PaisDTO(novoPais));
        }
}


