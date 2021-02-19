package br.com.orangetalents.casadocodigo.cadastropaiseseestados;

import br.com.orangetalents.casadocodigo.compartilhado.validacao.ExistById;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @ExistById(domainClass = Pais.class,fieldName = "id")
    private Long idPais;

    public EstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado toModel(EntityManager em){
        return new Estado(this.nome,em.find(Pais.class,idPais));
    }


}
