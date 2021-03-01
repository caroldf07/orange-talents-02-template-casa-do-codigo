package br.com.orangetalents.casadocodigo.novolivro.controller;

import br.com.orangetalents.casadocodigo.novolivro.NovoLivroRequest;
import br.com.orangetalents.casadocodigo.novolivro.model.Livro;
import br.com.orangetalents.casadocodigo.novolivro.repository.LivroRepository;
import br.com.orangetalents.casadocodigo.novolivro.view.LivroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//Carga Cognitiva de 5
@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    EntityManager em;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> criar(@RequestBody @Valid NovoLivroRequest novoLivro) {
        Livro livro = novoLivro.toModel(em);
        em.persist(livro);
        return ResponseEntity.ok(livro.toString());
    }

    /*
     * Listar todos os livros cadastrados
     * */
    @GetMapping
    public List<LivroResponse> listar() {

        List<Livro> livros = livroRepository.findAll();
        List<LivroResponse> livroResponses = new ArrayList<>();

        livros.forEach(livro -> {
            LivroResponse livroConvertido = livro.fromModelToResponse(em);
            livroResponses.add(livroConvertido);
        });

        return livroResponses;
    }
}
