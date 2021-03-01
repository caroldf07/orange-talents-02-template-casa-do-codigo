package br.com.orangetalents.casadocodigo.novolivro.model;

import br.com.orangetalents.casadocodigo.novacategoria.model.Categoria;
import br.com.orangetalents.casadocodigo.novoautor.model.Autor;
import br.com.orangetalents.casadocodigo.novolivro.view.LivroResponse;
import br.com.orangetalents.casadocodigo.paginadetalhes.view.DetalheAutorResponse;
import br.com.orangetalents.casadocodigo.paginadetalhes.view.DetalheLivroResponse;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @Lob
    private String sumario;

    @NotNull
    @Min(value = 20)
    private BigDecimal preco;

    @NotNull
    @Min(value = 100)
    private Integer numeroPagina;

    @NotBlank
    @Column(unique = true)
    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @ManyToOne
    @Valid
    private Categoria categoria;

    @NotNull
    @ManyToOne
    @Valid
    private Autor autor;

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
                 String sumario, @NotNull @Min(value = 20) BigDecimal preco,
                 @NotNull @Min(value = 100) Integer numeroPagina, @NotBlank String isbn,
                 @Future LocalDate dataPublicacao, @NotNull Categoria categoria,
                 @NotNull Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPagina = numeroPagina;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    /*
     * O Jackson não consegue deserializar sem o constructor vazio, por isso criei ele
     * */
    @Deprecated
    public Livro() {
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPagina=" + numeroPagina +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }

    /*
     * Getters criados para a configuração dos métodos fromModelTo...
     * */

    public Long getId() {
        return id;
    }

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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }


    /*
     * Método criado para a listagem de todos os livros
     * */
    public LivroResponse fromModelToResponse(EntityManager em) {
        Livro livro = em.find(Livro.class, id);
        return new LivroResponse(livro.getId(), livro.getTitulo());
    }

    /*
     * Método criado para o detalhamento de um livro pelo ID
     * */
    public DetalheLivroResponse fromModelToDetail(EntityManager em) {
        Livro livro = em.find(Livro.class, id);
        Autor autor = em.find(Autor.class, livro.autor.getId());


        return new DetalheLivroResponse(livro.getTitulo(), livro.getResumo(), livro.getSumario(),
                livro.getPreco(), livro.getNumeroPagina(), livro.getIsbn(),
                new DetalheAutorResponse(autor.getNome(), autor.getDescricao()));
    }
}
