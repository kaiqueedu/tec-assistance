package br.edu.dw2.tecassistance.service;

import br.edu.dw2.tecassistance.model.Customer;
import br.edu.dw2.tecassistance.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
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

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public void updateActiveProperty(Long id, Boolean active) {
        Customer savedCustomer = findById(id);
        savedCustomer.setActive(active);
        customerRepository.save(savedCustomer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        Customer savedCostumer = customerRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(customer, savedCostumer, "id");
        return customerRepository.save(savedCostumer);
    }
}
