package br.com.orangetalents.casadocodigo.fluxodepagamento.validacao;

import br.com.orangetalents.casadocodigo.fluxodepagamento.ClienteRequest;
import br.com.orangetalents.casadocodigo.paiseseestados.model.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//Carga cognitiva de 3
@Component
public class PaisTemEstadoValidator implements Validator {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ClienteRequest clienteRequest = (ClienteRequest) o;

        Pais pais = em.find(Pais.class, clienteRequest.getIdPais());

        boolean naoTemEstado = pais.getEstados().isEmpty();

        if (!naoTemEstado && clienteRequest.getIdEstado() == null) {
            errors.rejectValue("idEstado", null, "Esse País possui Estado, por favor escolha um Estado para finalizar");
        }
    }
}
