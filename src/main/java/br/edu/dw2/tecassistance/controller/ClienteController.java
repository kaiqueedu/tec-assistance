package br.edu.dw2.tecassistance.controller;

import br.edu.dw2.tecassistance.model.Cliente;
import br.edu.dw2.tecassistance.model.Endereco;
import br.edu.dw2.tecassistance.service.ClienteService;
import java.util.List;
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
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAllCliente(){
        return clienteService.findAllCliente();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findClienteById(@PathVariable(value = "id" ) long id ){
        Cliente cliente = clienteService.findById(id);
        if(cliente == null){
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCliente(@Valid @RequestBody Cliente cliente, HttpServletResponse response){
        clienteService.saveCliente(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clienteService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente){
        Cliente savedCliente = clienteService.updateCliente(id, cliente);
        return ResponseEntity.ok(savedCliente);
    }

    @PutMapping("/{id}/endereco")
    public ResponseEntity<Cliente> updateClienteAdress(@PathVariable Long id, @Valid @RequestBody Endereco endereco){
        Cliente savedCliente = clienteService.updateClienteEndereco(id, endereco);
        return ResponseEntity.ok(savedCliente);
    }

    @PutMapping("/{id}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean ativo){
        clienteService.updateAtivoProperty(id, ativo);
    }

}
