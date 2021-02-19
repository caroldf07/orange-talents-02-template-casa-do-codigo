package br.com.orangetalents.casadocodigo.cadastropaiseseestados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    /*
     * O Jackson só está serializando com o constructor vazio
     * */
    @Deprecated
    public Pais() {
    }


    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

}
