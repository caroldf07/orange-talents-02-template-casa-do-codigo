package br.com.orangetalents.casadocodigo.cadastropaiseseestados;

import br.com.orangetalents.casadocodigo.compartilhado.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {
    @NotBlank
    @UniqueValue(domainClass = Pais.class,fieldName = "nome")
    private String nome;

    public PaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    /*
     * Por algum motivo, o jackson só funciona quando crio o constructor vazio + o getter da variável
     * */
    @Deprecated
    public PaisRequest() {
    }

    public String getNome() {
        return nome;
    }

    public Pais toModel(){
        return new Pais(this.nome);
    }
}
