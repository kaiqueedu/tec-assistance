package br.edu.dw2.tecassistance.repository;

import br.edu.dw2.tecassistance.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
