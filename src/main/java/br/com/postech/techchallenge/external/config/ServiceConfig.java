package br.com.postech.techchallenge.external.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postech.techchallenge.adapters.gateways.ClienteGateway;
import br.com.postech.techchallenge.adapters.gateways.PagamentoGateway;
import br.com.postech.techchallenge.adapters.gateways.PedidoGateway;
import br.com.postech.techchallenge.adapters.gateways.ProdutoGateway;
import br.com.postech.techchallenge.adapters.mappers.PagamentoMapper;
import br.com.postech.techchallenge.adapters.mappers.PedidoMapper;
import br.com.postech.techchallenge.adapters.mappers.ProdutoMapper;
import br.com.postech.techchallenge.application.usecases.ClienteUseCaseImpl;

import br.com.postech.techchallenge.application.usecases.ProdutoUseCaseImpl;


@Configuration
public class ServiceConfig {

    @Bean
    public ClienteUseCaseImpl clienteUseCase(ClienteGateway clienteRepository) {
        return new ClienteUseCaseImpl(clienteRepository);
    }

    @Bean
    public ProdutoUseCaseImpl produtoUseCase(ProdutoGateway produtoRepository, ProdutoMapper produtoMapper) {
        return new ProdutoUseCaseImpl(produtoRepository, produtoMapper);
    }


}
