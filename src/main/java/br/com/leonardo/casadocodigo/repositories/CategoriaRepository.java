package br.com.leonardo.casadocodigo.repositories;

import br.com.leonardo.casadocodigo.models.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository <Categoria, Long>
{

    public Categoria findByNome(String nome);

}
