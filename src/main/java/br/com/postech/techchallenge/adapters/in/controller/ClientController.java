package br.com.postech.techchallenge.adapters.in.controller;

import br.com.postech.techchallenge.adapters.in.controller.request.ClientRegistrationRequest;
import br.com.postech.techchallenge.adapters.in.controller.response.ClientResponse;
import br.com.postech.techchallenge.application.core.domain.Client;
import br.com.postech.techchallenge.application.ports.in.RegisterClientInputPort;
import br.com.postech.techchallenge.application.ports.in.SearchClientByCpfInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/techchallenge/clients")
public class ClientController {

  private final RegisterClientInputPort registerClientInputPort;
  private final SearchClientByCpfInputPort searchClientByCpfInputPort;
  private final ModelMapper modelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void clientRegistration(@Valid @RequestBody final ClientRegistrationRequest clientRegistrationRequest) {
    log.info("Client registration request: {} received", clientRegistrationRequest);
    var client = modelMapper.map(clientRegistrationRequest, Client.class);
    registerClientInputPort.execute(client);
  }

  @GetMapping("/{cpf}")
  @ResponseStatus(HttpStatus.OK)
  public ClientResponse getClientByCPF(@PathVariable final String cpf) {
    log.info("Client search request received for cpf {} ", cpf);
    var client = searchClientByCpfInputPort.execute(cpf);
    return modelMapper.map(client, ClientResponse.class);
  }

}
