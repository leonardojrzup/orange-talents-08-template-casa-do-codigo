package br.com.leonardo.casadocodigo.repositorio;

import br.com.leonardo.casadocodigo.modelo.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Long> {

    Autor findByEmail(String email);

}
