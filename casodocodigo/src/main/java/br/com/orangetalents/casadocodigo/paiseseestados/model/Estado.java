package br.com.orangetalents.casadocodigo.paiseseestados.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;

    public Estado(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
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
