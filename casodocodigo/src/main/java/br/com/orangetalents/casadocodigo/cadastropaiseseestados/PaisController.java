package br.com.orangetalents.casadocodigo.cadastropaiseseestados;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

//Carga cognitiva de 2
@RestController
@RequestMapping("/paises")
public class PaisController {

    @PersistenceContext
    EntityManager em;

    @PostMapping
    @Transactional
    public String criar(@RequestBody @Valid PaisRequest paisRequest) {
        Pais pais = paisRequest.toModel();
        em.persist(pais);
        return pais.toString();

    }
}
