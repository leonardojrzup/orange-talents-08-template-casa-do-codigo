package br.com.leonardo.casadocodigo.controle;


import br.com.leonardo.casadocodigo.dto.pais.PaisForm;
import br.com.leonardo.casadocodigo.modelo.Pais;
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
        public void Salvar(@RequestBody @Valid PaisForm pais) {
            Pais novoPais = new Pais(pais.getNome());
            manager.persist(novoPais);
        }
}


