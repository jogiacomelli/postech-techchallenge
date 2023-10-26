package br.com.postech.techchallenge.adapters.in.controller;

import br.com.postech.techchallenge.adapters.in.controller.request.ItemRegistrationRequest;
import br.com.postech.techchallenge.application.core.domain.Item;
import br.com.postech.techchallenge.application.ports.in.RegisterItemInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/techchallenge/items")
public class ItemRegistrationController {

  private final RegisterItemInputPort registerItemInputPort;
  private final ModelMapper modelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void clientRegistration(@Valid @RequestBody final ItemRegistrationRequest itemRegistrationRequest) {
    log.info("Item registration request: {} received", itemRegistrationRequest);
    var item = modelMapper.map(itemRegistrationRequest, Item.class);
    registerItemInputPort.execute(item);
  }


}
