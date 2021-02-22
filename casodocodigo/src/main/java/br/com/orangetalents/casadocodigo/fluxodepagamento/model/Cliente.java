package br.com.orangetalents.casadocodigo.fluxodepagamento.model;

import br.com.orangetalents.casadocodigo.fluxodepagamento.validacao.CpfCnpj;
import br.com.orangetalents.casadocodigo.paiseseestados.model.Estado;
import br.com.orangetalents.casadocodigo.paiseseestados.model.Pais;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfCnpj
    @Column(unique = true)
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public Cliente(@Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
                   @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Pais pais,
                   @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(@Valid Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {

        return "Cliente{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais=" + pais.getNome() +
                ", estado=" + estado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
