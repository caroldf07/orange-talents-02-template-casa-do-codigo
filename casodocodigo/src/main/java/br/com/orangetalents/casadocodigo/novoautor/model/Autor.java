package br.com.orangetalents.casadocodigo.novoautor.model;

import br.com.orangetalents.casadocodigo.paginadetalhes.view.DetalheAutorResponse;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    @NotNull
    private LocalDateTime instante = LocalDateTime.now();

    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    /*
     * O Jackson só está serializando com o constructor vazio
     * */
    @Deprecated
    public Autor() {

    }

    /*
     * Getters criados para o DetalheAutorResponse
     * */

    public Long getId() {
        return id;
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
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", instante=" + instante +
                '}';
    }


    public DetalheAutorResponse fromModelToDetail(EntityManager em) {
        Autor autor = em.find(Autor.class, id);

        return new DetalheAutorResponse(autor.getNome(), autor.getDescricao());
    }
}
