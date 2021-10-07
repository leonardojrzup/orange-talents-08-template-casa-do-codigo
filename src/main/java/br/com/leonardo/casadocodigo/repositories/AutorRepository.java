package br.com.leonardo.casadocodigo.repositories;

import br.com.leonardo.casadocodigo.models.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
    Autor findByEmail(String email);

}
