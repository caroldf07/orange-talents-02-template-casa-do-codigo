package br.com.orangetalents.casadocodigo.novolivro;

import br.com.orangetalents.casadocodigo.novacategoria.Categoria;
import br.com.orangetalents.casadocodigo.novoautor.Autor;
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

    @JsonFormat(pattern = "dd/MM/yyyy")
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

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario, @NotNull @Min(value = 20) BigDecimal preco, @NotNull @Min(value = 100) Integer numeroPagina, @NotBlank String isbn, @Future LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
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

}
