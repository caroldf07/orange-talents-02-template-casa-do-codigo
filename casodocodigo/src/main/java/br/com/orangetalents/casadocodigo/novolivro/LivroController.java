package br.com.orangetalents.casadocodigo.novolivro;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class LivroController {

    @PersistenceContext
    EntityManager em;

    @PostMapping("/livros")
    @Transactional
    public String criar(@RequestBody @Valid NovoLivroRequest novoLivro) {
        Livro livro = novoLivro.toModel(em);
        em.persist(livro);
        return livro.toString();
    }
}
