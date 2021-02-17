package br.com.orangetalents.casadocodigo.novacategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CategoriaController {

    @PersistenceContext
    EntityManager em;

    @PostMapping("/categorias")
    @Transactional
    public String criar(@RequestBody @Valid NovaCategoriaRequest novaCategoria){
        Categoria categoria = novaCategoria.toModel();
        em.persist(categoria);
        return categoria.toString();
    }
}
