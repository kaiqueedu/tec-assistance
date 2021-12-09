package br.edu.dw2.tecassistance.repository;

import br.edu.dw2.tecassistance.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
