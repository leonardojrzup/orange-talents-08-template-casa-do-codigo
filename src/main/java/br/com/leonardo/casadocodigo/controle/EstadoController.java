package br.com.leonardo.casadocodigo.controle;

import br.com.leonardo.casadocodigo.dto.estado.EstadoForm;
import br.com.leonardo.casadocodigo.modelo.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class EstadoController {

        @Autowired
        private EntityManager manager;

        @PostMapping(value = "/estados")
        @Transactional
        public void salvar(@RequestBody @Valid EstadoForm form) {
            Estado novoEstado = form.toModel(manager);
            novoEstado.validarNomeDuplicadoPais(manager);
            manager.persist(novoEstado);
        }
}
