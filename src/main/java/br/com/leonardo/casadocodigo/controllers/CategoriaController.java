package br.com.leonardo.casadocodigo.controllers;

import br.com.leonardo.casadocodigo.dtos.categoria.CategoriaDTO;
import br.com.leonardo.casadocodigo.dtos.categoria.CategoriaForm;
import br.com.leonardo.casadocodigo.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    EntityManager entityManager;


    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDTO> Salvar (@RequestBody @Valid CategoriaForm form){
        Categoria categoriaSalva = form.converterParaEntidade();
        entityManager.persist(categoriaSalva);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaSalva.converterParaDTO());
    }
}
