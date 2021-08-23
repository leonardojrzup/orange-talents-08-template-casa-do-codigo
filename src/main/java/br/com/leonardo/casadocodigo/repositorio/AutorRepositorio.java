package br.com.leonardo.casadocodigo.repositorio;

import br.com.leonardo.casadocodigo.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {

     Autor findByNome(String nome);
}
