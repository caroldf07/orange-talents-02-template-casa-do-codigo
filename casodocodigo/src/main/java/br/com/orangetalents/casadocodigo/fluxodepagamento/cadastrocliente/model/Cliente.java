package br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.model;

import br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.validacao.ClienteGroupSequenceProvider;
import br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.validacao.CnpjGroup;
import br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.validacao.CpfGroup;
import br.com.orangetalents.casadocodigo.paiseseestados.model.Estado;
import br.com.orangetalents.casadocodigo.paiseseestados.model.Pais;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@GroupSequenceProvider(ClienteGroupSequenceProvider.class)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotNull
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private String cpfCnpj;

    @Enumerated(value = EnumType.STRING)
    @NotBlank
    private EnumTipoCliente tipoCliente;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cep;

    @NotBlank
    private String cidade;

    @ManyToOne
    private Estado estado;

    @NotBlank
    @ManyToOne
    private Pais pais;

    @NotBlank
    private String telefone;

    public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                   @NotBlank @CPF(groups = CpfGroup.class) @CNPJ(groups = CnpjGroup.class) String cpfCnpj,
                   @NotBlank EnumTipoCliente tipoCliente, @NotBlank String endereco,
                   @NotBlank String complemento, @NotBlank String cep, @NotBlank String cidade,
                   Estado estado, @NotBlank Pais pais, @NotBlank String telefone) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfCnpj = cpfCnpj;
        this.tipoCliente = tipoCliente;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.telefone = telefone;
    }

    /*
     * O Enum do TipoCliente foi criado para validar o CPF e o CNPJ no mesmo campo, validar não somente formato,
     * mas também se é um número válido
     * */
    public EnumTipoCliente getTipoCliente() {
        return tipoCliente;
    }
}
