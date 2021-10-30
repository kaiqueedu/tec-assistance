package br.edu.dw2.tecassistance.repository;

import br.edu.dw2.tecassistance.model.CustomerUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerUserRepository extends JpaRepository<CustomerUser, Long>{
	
	public Optional<CustomerUser> findByEmail(String email);
	
}
