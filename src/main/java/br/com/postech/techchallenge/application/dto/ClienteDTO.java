package br.com.postech.techchallenge.application.dto;


import br.com.postech.techchallenge.domain.model.Cliente;
import br.com.postech.techchallenge.domain.valuesObjects.ValidadorCPF;

public record ClienteDTO(Long id, ValidadorCPF cpf, String nome, String email) {
    public Cliente toCliente() {
        return new Cliente(this.id, this.cpf, this.nome, this.email);
    }
}