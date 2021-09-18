package br.edu.dw2.tecassistance.controller;

import br.edu.dw2.tecassistance.model.Customer;
import br.edu.dw2.tecassistance.service.CustomerService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> findAllCustomer(){
        return customerService.findAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable(value = "id" ) long id ){
        return customerService.findById(id);
    }

    @PostMapping
    public void saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }

}
