package br.com.postech.techchallenge.adapters.in.controller;

import br.com.postech.techchallenge.adapters.in.controller.request.ItemEditionRequest;
import br.com.postech.techchallenge.adapters.in.controller.request.ItemRegistrationRequest;
import br.com.postech.techchallenge.adapters.in.controller.response.ItemResponse;
import br.com.postech.techchallenge.application.core.domain.Item;
import br.com.postech.techchallenge.application.ports.in.EditItemInputPort;
import br.com.postech.techchallenge.application.ports.in.RegisterItemInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/techchallenge/items")
public class ItemController {

  private final RegisterItemInputPort registerItemInputPort;
  private final EditItemInputPort editItemInputPort;
  private final ModelMapper modelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void itemRegistration(@Valid @RequestBody final ItemRegistrationRequest itemRegistrationRequest) {
    log.info("Item registration request: {} received", itemRegistrationRequest);
    var item = modelMapper.map(itemRegistrationRequest, Item.class);
    registerItemInputPort.execute(item);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ItemResponse> itemEdition (@Valid @RequestBody final ItemEditionRequest itemEditionRequest,
                                     @PathVariable final Integer id) {
    log.info("Item edition request: {} received", itemEditionRequest);
    var item = modelMapper.map(itemEditionRequest, Item.class);
    var savedItem = editItemInputPort.execute(id, item);
    return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(savedItem, ItemResponse.class));
  }



  // get item by type
}