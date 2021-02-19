package br.com.orangetalents.casadocodigo.cadastropaiseseestados;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @ManyToOne
    @NotNull
    private Pais pais;

    public Estado(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    /*
     * O Jackson só está serializando com o constructor vazio
     * */
    @Deprecated
    public Estado() {
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                "," + pais +
                '}';
    }
}
