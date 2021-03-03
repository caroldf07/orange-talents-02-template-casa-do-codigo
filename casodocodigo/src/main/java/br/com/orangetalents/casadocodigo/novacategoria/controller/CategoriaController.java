package br.com.orangetalents.casadocodigo.novacategoria.controller;

import br.com.orangetalents.casadocodigo.novacategoria.NovaCategoriaRequest;
import br.com.orangetalents.casadocodigo.novacategoria.model.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

//Carga cognitiva de 2
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public ResponseEntity<String> criar(@RequestBody @Valid NovaCategoriaRequest novaCategoria) {
        Categoria categoria = novaCategoria.toModel();
        em.persist(categoria);
        return ResponseEntity.ok().build();
    }
}
