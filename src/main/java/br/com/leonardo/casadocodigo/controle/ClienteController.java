package br.com.leonardo.casadocodigo.controle;

import br.com.leonardo.casadocodigo.dto.cliente.ClienteForm;
import br.com.leonardo.casadocodigo.modelo.Cliente;
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
    public ResponseEntity<Cliente> Salvar(@RequestBody @Valid ClienteForm form) {
        Cliente clienteSalvo = form.toModel(entityManager);
        entityManager.persist(clienteSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(clienteSalvo);
    }
}
