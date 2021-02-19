package br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.controller;

import br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.ClienteRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @PersistenceContext
    EntityManager em;

    @PostMapping
    public String criar(@RequestBody @Valid ClienteRequest clienteRequest){

        return "criando...";
    }
}
