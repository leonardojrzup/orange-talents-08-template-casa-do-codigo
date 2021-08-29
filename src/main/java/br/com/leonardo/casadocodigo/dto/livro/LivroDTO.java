package br.com.leonardo.casadocodigo.dto.livro;

import br.com.leonardo.casadocodigo.modelo.Livro;

public class LivroDTO {

    private long id;
    private String titulo;

    public LivroDTO(long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    @Deprecated
    public LivroDTO() {
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
