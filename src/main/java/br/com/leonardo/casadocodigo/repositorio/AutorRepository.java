package br.com.leonardo.casadocodigo.repositorio;

import br.com.leonardo.casadocodigo.modelo.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

    Autor findByEmail(String email);

}
