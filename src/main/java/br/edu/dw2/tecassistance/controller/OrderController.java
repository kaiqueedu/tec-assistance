package br.edu.dw2.tecassistance.controller;

import br.edu.dw2.tecassistance.model.Customer;
import br.edu.dw2.tecassistance.model.Order;
import br.edu.dw2.tecassistance.service.OrderService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> findAllCustomer(){
        return orderService.findAllOrder();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrder(@Valid @RequestBody Order order, HttpServletResponse response){
        orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        orderService.deleteById(id);
    }
}
