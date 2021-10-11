package br.edu.dw2.tecassistance.service;

import br.edu.dw2.tecassistance.model.PaymentMethod;
import br.edu.dw2.tecassistance.repository.PaymentMethodRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {

    @Autowired
    PaymentMethodRepository repository;

    public List<PaymentMethod> findAllPaymentMethod(){
        return repository.findAll();
    }

    public void savePayment(PaymentMethod payment) {
        if(payment != null){
            repository.save(payment);
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
