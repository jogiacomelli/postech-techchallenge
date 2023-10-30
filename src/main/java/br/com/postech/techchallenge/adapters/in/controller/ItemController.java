package br.com.postech.techchallenge.adapters.in.controller;

import br.com.postech.techchallenge.adapters.in.controller.request.ItemEditionRequest;
import br.com.postech.techchallenge.adapters.in.controller.request.ItemRegistrationRequest;
import br.com.postech.techchallenge.adapters.in.controller.response.ItemResponse;
import br.com.postech.techchallenge.application.core.domain.Item;
import br.com.postech.techchallenge.application.core.domain.enums.ItemType;
import br.com.postech.techchallenge.application.ports.in.DeleteItemInputPort;
import br.com.postech.techchallenge.application.ports.in.EditItemInputPort;
import br.com.postech.techchallenge.application.ports.in.RegisterItemInputPort;
import br.com.postech.techchallenge.application.ports.in.SearchItemInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/techchallenge/items")
public class ItemController {

  private final RegisterItemInputPort registerItemInputPort;
  private final EditItemInputPort editItemInputPort;
  private final SearchItemInputPort searchItemInputPort;
  private final DeleteItemInputPort deleteItemInputPort;
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

  @GetMapping
  public ResponseEntity<List<ItemResponse>> itemSearch(@NotNull @RequestParam final String type) {
    log.info("Item search request: {} received", type);
    var items = searchItemInputPort.execute(type);
    return ResponseEntity.status(HttpStatus.OK)
            .body(items.stream()
                    .map(item -> modelMapper.map(item, ItemResponse.class)).
                    toList()
            );
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void itemDelete(@NotNull @PathVariable final Integer id) {
    log.info("Item delete request: {} received", id);
    deleteItemInputPort.execute(id);
  }
}
