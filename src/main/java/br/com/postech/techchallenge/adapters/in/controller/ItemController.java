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
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
  public ItemResponse itemRegistration(@Valid @RequestBody final ItemRegistrationRequest itemRegistrationRequest) {
    log.info("Item registration request: {} received", itemRegistrationRequest);
    var item = modelMapper.map(itemRegistrationRequest, Item.class);
    return modelMapper.map(registerItemInputPort.execute(item), ItemResponse.class);
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ItemResponse itemEdition(@Valid @RequestBody final ItemEditionRequest itemEditionRequest, @PathVariable final Integer id) {
    log.info("Item edition request: {} received", itemEditionRequest);
    var item = modelMapper.map(itemEditionRequest, Item.class);
    var savedItem = editItemInputPort.execute(id, item);
    return modelMapper.map(savedItem, ItemResponse.class);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ItemResponse> itemSearch(@NotNull @RequestParam final ItemType type) {
    log.info("Item search request: {} received", type);
    var items = searchItemInputPort.execute(type);
    return items.stream()
        .map(item -> modelMapper.map(item, ItemResponse.class))
        .toList();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void itemDelete(@NotNull @PathVariable final Integer id) {
    log.info("Item delete request: {} received", id);
    deleteItemInputPort.execute(id);
  }
}
