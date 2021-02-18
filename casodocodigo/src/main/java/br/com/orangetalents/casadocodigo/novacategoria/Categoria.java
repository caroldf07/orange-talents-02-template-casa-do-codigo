package br.com.orangetalents.casadocodigo.novacategoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    /*
     * O Jackson só está serializando com o constructor vazio
     * */
    @Deprecated
    public Categoria() {

    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
