package br.com.orangetalents.casadocodigo.cadastropaiseseestados;

import org.springframework.http.ResponseEntity;
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
@RequestMapping("/estados")
public class EstadoController {

    @PersistenceContext
    EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@RequestBody @Valid EstadoRequest estadoRequest) {
        Estado estado = estadoRequest.toModel(em);
        em.persist(estado);
        return ResponseEntity.ok(estado.toString());
    }
}
