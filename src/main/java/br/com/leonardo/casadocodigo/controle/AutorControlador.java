package br.com.leonardo.casadocodigo.controle;


import br.com.leonardo.casadocodigo.dto.AutorForm;
import br.com.leonardo.casadocodigo.modelo.Autor;
import br.com.leonardo.casadocodigo.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/Autor")
public class AutorControlador {

    @Autowired
   private AutorRepositorio autorRepositorio;

    @PostMapping
    public ResponseEntity<Autor> Salvar (@RequestBody @Valid AutorForm form){
        Autor autorSalvo = form.converterParaEntidade();
        autorRepositorio.save(autorSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(autorSalvo);
    }
}
