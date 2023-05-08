package com.grupo2.biblioteca_api.usuario.cliente;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente clienteNovo) {
        clienteNovo = clienteService.create(clienteNovo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clienteNovo.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteNovo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @Valid @RequestBody Cliente clienteAtualizado) {
        clienteAtualizado = clienteService.update(id, clienteAtualizado);
        return ResponseEntity.ok(clienteAtualizado);
    }
}
