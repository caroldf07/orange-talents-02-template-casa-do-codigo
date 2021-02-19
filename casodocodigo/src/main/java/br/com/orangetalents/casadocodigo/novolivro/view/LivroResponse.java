package br.com.orangetalents.casadocodigo.novolivro.view;

public class LivroResponse {

    private Long id;
    private String titulo;

    public LivroResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    /*
     * O Jackson só deserializa essa entidade quando tem um construtor vazio e
     * os getters de todos os atributos
     * */
    @Deprecated
    public LivroResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
