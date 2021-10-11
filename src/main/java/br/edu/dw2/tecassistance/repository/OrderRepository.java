package br.edu.dw2.tecassistance.repository;

import br.edu.dw2.tecassistance.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
