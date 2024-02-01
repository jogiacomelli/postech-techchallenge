package br.com.postech.techchallenge.core.domain.usecase.cliente;

import br.com.postech.techchallenge.core.gateway.ClienteGateway;

public class DeleteClientUseCase {
    private final ClienteGateway clienteGateway;

    public DeleteClientUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public void execute(String cpf) {
        clienteGateway.deleteCliente(cpf);
    }

}
