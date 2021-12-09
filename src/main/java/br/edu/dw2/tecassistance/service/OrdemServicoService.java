package br.edu.dw2.tecassistance.service;

import br.edu.dw2.tecassistance.model.OrdemServico;
import br.edu.dw2.tecassistance.repository.OrdemServicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoService {

    @Autowired
    OrdemServicoRepository ordemServicoRepository;

    public List<OrdemServico> findAllOrdem(){
        return ordemServicoRepository.findAll();
    }

    public void saveOrder(OrdemServico ordem) {
        if(ordem != null){
            ordemServicoRepository.save(ordem);
        }
    }

    public void deleteById(Long id) {
        ordemServicoRepository.deleteById(id);
    }
}
