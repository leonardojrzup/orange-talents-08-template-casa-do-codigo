package br.com.leonardo.casadocodigo.controle;

import br.com.leonardo.casadocodigo.dto.autor.AutorDTO;
import br.com.leonardo.casadocodigo.dto.autor.AutorForm;
import br.com.leonardo.casadocodigo.dto.categoria.CategoriaDTO;
import br.com.leonardo.casadocodigo.dto.categoria.CategoriaForm;
import br.com.leonardo.casadocodigo.modelo.Autor;
import br.com.leonardo.casadocodigo.modelo.Categoria;
import br.com.leonardo.casadocodigo.repositorio.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
