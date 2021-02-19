package br.com.orangetalents.casadocodigo.paiseseestados;

import br.com.orangetalents.casadocodigo.compartilhado.validacao.ExistById;
import br.com.orangetalents.casadocodigo.paiseseestados.model.Estado;
import br.com.orangetalents.casadocodigo.paiseseestados.model.Pais;
import br.com.orangetalents.casadocodigo.paiseseestados.validacao.UniqueEstadoPais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueEstadoPais(domainClass = Estado.class,fieldName1 = "nome",fieldName2 = "idPais")
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
        Pais pais = em.find(Pais.class,this.idPais);
        return new Estado(this.nome,pais);
    }

    /*
    * A Annotation UniqueEstadoPais precisa desses getters para validação
    * */
    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
