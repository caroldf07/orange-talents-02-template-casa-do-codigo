package br.com.orangetalents.casadocodigo.paginadetalhes.view;

public class DetalheAutorResponse {

    private String nome;
    private String descricao;

    /*
     * O Jackson só deserializa essa entidade quando tem um construtor vazio e
     * os getters de todos os atributos
     * */
    @Deprecated
    public DetalheAutorResponse() {
    }

    public DetalheAutorResponse(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }


}
