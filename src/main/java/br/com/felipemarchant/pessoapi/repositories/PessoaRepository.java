package br.com.felipemarchant.pessoapi.repositories;

import br.com.felipemarchant.pessoapi.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
