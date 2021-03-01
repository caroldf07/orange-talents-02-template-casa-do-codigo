package br.com.orangetalents.casadocodigo.paginadetalhes.view;

import java.math.BigDecimal;

public class DetalheLivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPagina;
    private String isbn;
    private DetalheAutorResponse autor;

    public DetalheLivroResponse(String titulo, String resumo, String sumario,
                                BigDecimal preco, Integer numeroPagina, String isbn,
                                DetalheAutorResponse autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPagina = numeroPagina;
        this.isbn = isbn;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPagina=" + numeroPagina +
                ", isbn='" + isbn + '\'' +
                ", autorResponse=" + autor +
                '}';
    }


    /*
     * Getters criados para o jackson
     * */
    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPagina() {
        return numeroPagina;
    }

    public String getIsbn() {
        return isbn;
    }

    public DetalheAutorResponse getAutor() {
        return autor;
    }
}
