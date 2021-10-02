package br.edu.dw2.tecassistance.controller;

import br.edu.dw2.tecassistance.model.Customer;
import br.edu.dw2.tecassistance.service.CustomerService;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public ResponseEntity<Customer> findCustomerById(@PathVariable(value = "id" ) long id ){
        Customer customer = customerService.findById(id);
        if(customer == null){
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCustomer(@Valid @RequestBody Customer customer, HttpServletResponse response){
        customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer){
        Customer savedCustomer = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @PutMapping("/{id}/active")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean active){
        customerService.updateActiveProperty(id, active);
    }

}
