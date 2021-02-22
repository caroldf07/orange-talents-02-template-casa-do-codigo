package br.com.orangetalents.casadocodigo.fluxodepagamento;

import br.com.orangetalents.casadocodigo.compartilhado.validacao.ExistById;
import br.com.orangetalents.casadocodigo.compartilhado.validacao.UniqueValue;
import br.com.orangetalents.casadocodigo.fluxodepagamento.model.Cliente;
import br.com.orangetalents.casadocodigo.fluxodepagamento.validacao.CpfCnpj;
import br.com.orangetalents.casadocodigo.paiseseestados.model.Estado;
import br.com.orangetalents.casadocodigo.paiseseestados.model.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfCnpj
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistById(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    @ExistById(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public ClienteRequest(@Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                          @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                          @NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
                          @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    //Carga cognitiva 2
    public Cliente toModel(EntityManager em) {
        Pais pais = em.find(Pais.class, idPais);
        Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento,
                this.endereco, this.complemento, this.cidade, pais, this.telefone,
                this.cep);
        if (idEstado != null) {
            cliente.setEstado(em.find(Estado.class, idEstado));
        }
        return cliente;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    @Override
    public String toString() {
        return "ClienteRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
