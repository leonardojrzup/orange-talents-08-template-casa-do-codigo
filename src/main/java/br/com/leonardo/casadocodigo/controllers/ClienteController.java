package br.com.leonardo.casadocodigo.controllers;

import br.com.leonardo.casadocodigo.dtos.cliente.ClienteDTO;
import br.com.leonardo.casadocodigo.dtos.cliente.ClienteForm;
import br.com.leonardo.casadocodigo.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> Salvar(@RequestBody @Valid ClienteForm form) {
        Cliente clienteSalvo = form.toModel(entityManager);
        entityManager.persist(clienteSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(new ClienteDTO(clienteSalvo));
    }
}
