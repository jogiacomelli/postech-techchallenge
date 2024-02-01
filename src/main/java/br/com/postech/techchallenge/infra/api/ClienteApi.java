package br.com.postech.techchallenge.infra.api;


import br.com.postech.techchallenge.core.repository.ClienteRepository;
import br.com.postech.techchallenge.infra.api.dto.ClienteDTO;
import br.com.postech.techchallenge.infra.controller.ClienteController;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/techchallenge/cliente")
public class ClienteApi {

    private final ClienteController clienteController;

    public ClienteApi(ClienteRepository repository, ModelMapper modelMapper) {
        this.clienteController = new ClienteController(repository, modelMapper);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteDTO> criaCliente(@Valid @RequestBody final ClienteDTO clientRegistrationRequest) {
        log.info("Client registration request: {} received", clientRegistrationRequest);
        return clienteController.createCliente(clientRegistrationRequest);
    }

    @GetMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClienteDTO> getClientByCPF(@PathVariable final String cpf) {
        log.info("Client search request received for cpf {} ", cpf);
        return clienteController.getClienteByCpf(cpf);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deleteCliente(@PathVariable String cpf) {
        return clienteController.deleteCliente(cpf);
    }

}