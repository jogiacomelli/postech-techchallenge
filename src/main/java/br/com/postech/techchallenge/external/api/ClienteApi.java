package br.com.postech.techchallenge.external.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.postech.techchallenge.adapters.controllers.ClienteController;
import br.com.postech.techchallenge.application.dto.ClienteDTO;

import java.util.List;

@RestController
@RequestMapping("/techchallenge/cliente")
public class ClienteApi {

    private final ClienteController clienteController;

    public ClienteApi(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteController.createCliente(clienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        return clienteController.updateCliente(id, clienteDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        return clienteController.getClienteById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        return clienteController.deleteCliente(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        return clienteController.getAllClientes();
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ClienteDTO> getClienteByCpf(@PathVariable String cpf) {
        return clienteController.getClienteByCpf(cpf);
    }



}