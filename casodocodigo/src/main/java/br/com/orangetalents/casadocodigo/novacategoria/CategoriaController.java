package br.com.orangetalents.casadocodigo.novacategoria;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

//Carga cognitiva de 3
@RestController
public class CategoriaController {

    @PersistenceContext
    EntityManager em;

    @PostMapping("/categorias")
    @Transactional
    public String criar(@RequestBody @Valid NovaCategoriaRequest novaCategoria) {
        Categoria categoria = novaCategoria.toModel();
        em.persist(categoria);
        return categoria.toString();
    }
}
