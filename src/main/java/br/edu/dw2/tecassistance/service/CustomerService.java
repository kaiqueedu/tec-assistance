package br.edu.dw2.tecassistance.service;

import br.edu.dw2.tecassistance.model.Customer;
import br.edu.dw2.tecassistance.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    public void saveCustomer(Customer customer){
        if(customer != null){
            customerRepository.save(customer);
        }
    }

    public Customer findById(long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
