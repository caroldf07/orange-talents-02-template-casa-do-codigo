package br.com.orangetalents.casadocodigo.novolivro.repository;

import br.com.orangetalents.casadocodigo.novolivro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
