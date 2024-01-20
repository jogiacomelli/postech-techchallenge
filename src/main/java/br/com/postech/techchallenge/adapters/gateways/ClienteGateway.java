package br.com.postech.techchallenge.adapters.gateways;

import java.util.List;

import br.com.postech.techchallenge.domain.model.Cliente;
import br.com.postech.techchallenge.domain.valuesObjects.ValidadorCPF;

public interface ClienteGateway {
    Cliente saveCliente(Cliente clienteDTO);
    Cliente updateCliente(Long id, Cliente clienteDTO);
    Cliente findById(Long id);
    boolean deleteCliente(Long id);
    List<Cliente> listAllClientes();
    Cliente findByCpf(ValidadorCPF cpf);
}