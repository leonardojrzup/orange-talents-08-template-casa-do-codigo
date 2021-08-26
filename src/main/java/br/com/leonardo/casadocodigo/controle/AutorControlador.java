package br.com.leonardo.casadocodigo.controle;


import br.com.leonardo.casadocodigo.dto.autor.AutorDTO;
import br.com.leonardo.casadocodigo.dto.autor.AutorForm;
import br.com.leonardo.casadocodigo.modelo.Autor;
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
@RequestMapping("/Autor")
public class AutorControlador {

    @Autowired
    EntityManager entityManager;

//Metodo de teste para buscar todos os autores no banco de dados utilizando um metodo estatico da classe DTO para converter a lista de Autores em Autores DTO
    @GetMapping
    public List<AutorDTO> listarTodos() {
    List<Autor> resultado = entityManager.createQuery("select a from Autor a ").getResultList();
    return resultado.stream().map(autor -> AutorDTO.converterParaDTO(autor))
                .collect(Collectors.toList());
    }

    //Salva o Autor no banco de dados e retorna um autorDTO do autor que foi cadastrado, juntamente com o status 200 (OK)
    @PostMapping
    @Transactional
    public ResponseEntity<AutorDTO> Salvar (@RequestBody @Valid AutorForm form){
        Autor autorSalvo = form.converterParaEntidade();
        entityManager.persist(autorSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(autorSalvo.converterParaDTO());
    }
}
