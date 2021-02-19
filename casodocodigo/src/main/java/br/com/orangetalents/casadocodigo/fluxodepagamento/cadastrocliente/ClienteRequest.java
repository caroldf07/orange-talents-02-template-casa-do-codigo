package br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente;

import br.com.orangetalents.casadocodigo.compartilhado.validacao.ExistById;
import br.com.orangetalents.casadocodigo.compartilhado.validacao.UniqueValue;
import br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.model.Cliente;
import br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.model.EnumTipoCliente;
import br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.validacao.ClienteRequestGroupSequenceProvider;
import br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.validacao.CnpjGroup;
import br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.validacao.CpfGroup;
import br.com.orangetalents.casadocodigo.paiseseestados.model.Estado;
import br.com.orangetalents.casadocodigo.paiseseestados.model.Pais;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@GroupSequenceProvider(ClienteRequestGroupSequenceProvider.class)
public class ClienteRequest {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private String cpfCnpj;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private EnumTipoCliente tipoCliente;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cep;

    @NotBlank
    private String cidade;

    @ExistById(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;

    @NotNull
    @ExistById(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    @NotBlank
    private String telefone;

    public ClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                          @NotBlank @CPF(groups = CpfGroup.class) @CNPJ(groups = CnpjGroup.class) String cpfCnpj,
                          @NotNull EnumTipoCliente tipoCliente, @NotBlank String endereco,
                          @NotBlank String complemento, @NotBlank String cep, @NotBlank String cidade,
                          Long idEstado, @NotNull Long idPais, @NotBlank String telefone) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfCnpj = cpfCnpj;
        this.tipoCliente = tipoCliente;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.idEstado = idEstado;
        this.idPais = idPais;
        this.telefone = telefone;
    }

    /*
     * Construtor vazio e getters criados por conta do jackson
     * */
    @Deprecated
    public ClienteRequest() {
    }

    public Cliente toModel(EntityManager em) {
        Pais pais = em.find(Pais.class, idPais);
        Estado estado = em.find(Estado.class, idEstado);

        return new Cliente(this.email, this.nome, this.sobrenome, this.cpfCnpj, this.tipoCliente, this.endereco, this.complemento,
                this.cep, this.cidade, estado, pais, this.telefone);
    }

    /*
     * O Enum do TipoCliente foi criado para validar o CPF e o CNPJ no mesmo campo, validar não somente formato,
     * mas também se é um número válido
     * */
    public EnumTipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public Long getIdPais() {
        return idPais;
    }

    public String getTelefone() {
        return telefone;
    }
}

