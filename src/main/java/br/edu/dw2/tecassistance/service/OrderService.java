package br.edu.dw2.tecassistance.service;

import br.edu.dw2.tecassistance.model.Order;
import br.edu.dw2.tecassistance.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> findAllOrder(){
        return orderRepository.findAll();
    }

    public void saveOrder(Order order) {
        if(order != null){
            orderRepository.save(order);
        }
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
