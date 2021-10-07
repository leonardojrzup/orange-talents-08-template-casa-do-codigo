package br.com.leonardo.casadocodigo.dtos.livro;

import br.com.leonardo.casadocodigo.models.Livro;

public class LivroDTO {

    private long id;
    private String titulo;

    public LivroDTO(long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static LivroDTO toDTO(Livro livro){
        return new LivroDTO(livro.getId(),livro.getTitulo());
    }
}
