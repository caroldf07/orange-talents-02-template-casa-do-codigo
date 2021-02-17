package br.com.orangetalents.casadocodigo.novacategoria;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
    Optional<Categoria> findByNome(String nome);
}
