package br.com.orangetalents.casadocodigo.paginadetalhes.controller;

import br.com.orangetalents.casadocodigo.novolivro.model.Livro;
import br.com.orangetalents.casadocodigo.paginadetalhes.view.DetalheLivroResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//Carga cognitiva de 4
@RestController
@RequestMapping("/produtos")
public class PaginaDetalhesController {

    @PersistenceContext
    EntityManager em;

    @GetMapping("/{id}")
    public ResponseEntity<?> exibir(@PathVariable(value = "id") Long id) {

        Livro livro = em.find(Livro.class, id);

        if (livro == null) {
            return ResponseEntity.notFound().build();
        }
        DetalheLivroResponse detalheLivroResponse = livro.fromModelToDetail(em);

        return ResponseEntity.ok(detalheLivroResponse);
    }
}
