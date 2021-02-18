package br.com.orangetalents.casadocodigo.novolivro;

import br.com.orangetalents.casadocodigo.compartilhado.validacao.ExistById;
import br.com.orangetalents.casadocodigo.compartilhado.validacao.UniqueValue;
import br.com.orangetalents.casadocodigo.novacategoria.Categoria;
import br.com.orangetalents.casadocodigo.novoautor.Autor;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @Lob
    private String sumario;

    @NotNull
    @Min(value = 20)
    private Double preco;

    @NotNull
    @Min(value = 100)
    private Integer numeroPagina;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @ExistById(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;

    @NotNull
    @ExistById(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    private NovoLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario, @NotNull @Min(value = 20) Double preco, @NotNull @Min(value = 100) Integer numeroPagina, @NotBlank String isbn, @Future LocalDate dataPublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPagina = numeroPagina;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    /*
     * O Jackson só deserializa essa entidade quando tem um construtor vazio e
     * os getters de todos os atributos
     * */
    @Deprecated
    public NovoLivroRequest() {

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

    public Double getPreco() {
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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }


    /*
     * No Request o preço entra como Integer, mas no toModel ele é convertido para BigDecimal
     * */
    public Livro toModel(EntityManager em) {
        Categoria categoria = em.find(Categoria.class, idCategoria);
        Autor autor = em.find(Autor.class, idAutor);

        return new Livro(this.titulo, this.resumo, this.sumario, new BigDecimal(this.preco), this.numeroPagina, this.isbn, this.dataPublicacao, categoria, autor);
    }

    public static class LivroBuilder {
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
        private Double preco;

        @NotNull
        @Min(value = 100)
        private Integer numeroPagina;

        @NotBlank
        @Column(unique = true)
        private String isbn;

        @JsonFormat(pattern = "dd/MM/yyyy")
        @Future
        private LocalDate dataPublicacao;

        @NotNull
        @ExistById(domainClass = Categoria.class, fieldName = "id")
        private Long idCategoria;

        @NotNull
        @ExistById(domainClass = Autor.class, fieldName = "id")
        private Long idAutor;

        public LivroBuilder() {

        }

        public LivroBuilder titulo(@NotBlank String titulo) {
            return this;
        }

        public LivroBuilder resumo(@NotBlank @Size(max = 500) String resumo) {
            return this;
        }

        public LivroBuilder sumario(String sumario) {
            return this;
        }

        public LivroBuilder preco(@NotNull @Min(value = 20) Double preco) {
            return this;
        }

        public LivroBuilder numeroPagina(@NotNull @Min(value = 100) Integer numeroPagina) {
            return this;
        }

        public LivroBuilder isbn(@NotBlank String isbn) {
            return this;
        }

        public LivroBuilder dataPublicacao(@Future LocalDate dataPublicacao) {
            return this;
        }

        public LivroBuilder idCategoria(@NotNull Long idCategoria) {
            return this;
        }

        public LivroBuilder idAutor(@NotNull Long idAutor) {
            return this;
        }

        public NovoLivroRequest criarNovoLivroRequest() {
            return new NovoLivroRequest(this.titulo, this.resumo, this.sumario,
                    this.preco, this.numeroPagina, this.isbn,
                    this.dataPublicacao, this.idCategoria, this.idAutor);
        }

    }


}
