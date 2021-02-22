package br.com.orangetalents.casadocodigo.fluxodepagamento.controller;

import br.com.orangetalents.casadocodigo.fluxodepagamento.ClienteRequest;
import br.com.orangetalents.casadocodigo.fluxodepagamento.model.Cliente;
import br.com.orangetalents.casadocodigo.fluxodepagamento.validacao.PaisTemEstadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

//Carga cognitiva de 4
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PersistenceContext
    EntityManager em;

    @Autowired
    private PaisTemEstadoValidator paisTemEstadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(paisTemEstadoValidator);
    }

    @PostMapping
    @Transactional
    public String criar(@RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.toModel(em);
        em.persist(cliente);
        return cliente.toString();
    }
}
