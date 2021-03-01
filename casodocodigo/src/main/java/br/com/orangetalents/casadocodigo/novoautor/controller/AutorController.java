package br.com.orangetalents.casadocodigo.novoautor.controller;

import br.com.orangetalents.casadocodigo.novoautor.NovoAutorRequest;
import br.com.orangetalents.casadocodigo.novoautor.model.Autor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

//Carga cognitiva de 2
@RestController
@RequestMapping("/autores")
public class AutorController {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public ResponseEntity<String> criar(@RequestBody @Valid NovoAutorRequest novoAutor) {
        Autor autor = novoAutor.toModel();
        em.persist(autor);
        return ResponseEntity.ok(autor.toString());
    }
}
