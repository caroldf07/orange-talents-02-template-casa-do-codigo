package br.com.orangetalents.casadocodigo.novacategoria;

import br.com.orangetalents.casadocodigo.compartilhado.validação.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class,fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public NovaCategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public NovaCategoriaRequest() {

    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
