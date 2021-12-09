package br.edu.dw2.tecassistance.service;

import br.edu.dw2.tecassistance.model.FormaPagamento;
import br.edu.dw2.tecassistance.repository.FormaPagamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormaPagamentoService {

    @Autowired
    FormaPagamentoRepository repository;

    public List<FormaPagamento> findAllPagamentos(){
        return repository.findAll();
    }

    public void savePayment(FormaPagamento pagamento) {
        if(pagamento != null){
            repository.save(pagamento);
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
