package br.com.leonardo.casadocodigo.repositorio;

import br.com.leonardo.casadocodigo.modelo.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository <Categoria, Long>
{

    public Categoria findByNome(String nome);

}
