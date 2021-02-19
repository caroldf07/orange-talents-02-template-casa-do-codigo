package br.com.orangetalents.casadocodigo.novacategoria;

import br.com.orangetalents.casadocodigo.compartilhado.validacao.UniqueValue;
import br.com.orangetalents.casadocodigo.novacategoria.model.Categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public NovaCategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    /*
     * Por algum motivo, o jackson só funciona quando crio o constructor vazio + o getter da variável
     * */
    @Deprecated
    public NovaCategoriaRequest() {

    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
