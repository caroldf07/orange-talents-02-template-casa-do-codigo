package br.com.orangetalents.casadocodigo.paiseseestados;

import br.com.orangetalents.casadocodigo.compartilhado.validacao.UniqueValue;
import br.com.orangetalents.casadocodigo.paiseseestados.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public PaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    /*
     * O Jackson só deserializa essa entidade quando tem um construtor vazio e
     * os getters de todos os atributos
     * */
    @Deprecated
    public PaisRequest() {
    }

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }


}
