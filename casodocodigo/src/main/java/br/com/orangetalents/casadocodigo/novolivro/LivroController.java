package br.com.orangetalents.casadocodigo.novolivro;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LivroController {

    @PostMapping("/livros")
    public String criar(@RequestBody @Valid NovoLivroRequest novoLivro){
        return "tentando novo livro";
    }
}
