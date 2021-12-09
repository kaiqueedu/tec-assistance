package br.edu.dw2.tecassistance.service;

import br.edu.dw2.tecassistance.model.Cliente;
import br.edu.dw2.tecassistance.model.Endereco;
import br.edu.dw2.tecassistance.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAllCliente(){
        return clienteRepository.findAll();
    }

    public void saveCliente(Cliente cliente){
        if(cliente != null){
            clienteRepository.save(cliente);
        }
    }

    public Cliente findById(long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public void updateAtivoProperty(Long id, Boolean ativo) {
        Cliente cliente = getClienteById(id);
        cliente.setAtivo(ativo);
        clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente savedCliente = getClienteById(id);
        BeanUtils.copyProperties(cliente, savedCliente, "id");
        return clienteRepository.save(savedCliente);
    }

    public Cliente updateClienteEndereco(Long id, Endereco endereco) {
        Cliente savedCliente = getClienteById(id);
        if(savedCliente != null){
            savedCliente.setEndereco(endereco);
        }
        return clienteRepository.save(savedCliente);
    }

    private Cliente getClienteById(Long id){
        Cliente savedCliente = clienteRepository.findById(id).orElseThrow(
                () -> new EmptyResultDataAccessException(1));
        return savedCliente;
    }

}
