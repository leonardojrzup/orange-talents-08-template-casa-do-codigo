package br.com.leonardo.casadocodigo.repositorio;

import br.com.leonardo.casadocodigo.modelo.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository <Categoria, Long>
{

    public Categoria findByNome(String nome);

}
