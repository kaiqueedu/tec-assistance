package br.edu.dw2.tecassistance.controller;

import br.edu.dw2.tecassistance.model.OrdemServico;
import br.edu.dw2.tecassistance.service.OrdemServicoService;
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
@RequestMapping("/ordemServico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemService;

    @GetMapping
    public List<OrdemServico> findAllOrdem(){
        return ordemService.findAllOrdem();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrdem(@Valid @RequestBody OrdemServico ordem, HttpServletResponse response){
        ordemService.saveOrder(ordem);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        ordemService.deleteById(id);
    }
}
