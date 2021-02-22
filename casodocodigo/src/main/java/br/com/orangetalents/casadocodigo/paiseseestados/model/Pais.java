package br.com.orangetalents.casadocodigo.paiseseestados.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Pais {

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private static List<Estado> estados;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    /*
     * O Jackson só deserializa essa entidade quando tem um construtor vazio
     * */
    @Deprecated
    public Pais() {
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
