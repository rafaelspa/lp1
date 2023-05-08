package com.grupo2.biblioteca_api.usuario.administrador;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/administrador")
public class AdministradorController {

    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Administrador> findById(@PathVariable Integer id) {
        Administrador administrador = administradorService.findById(id);
        return ResponseEntity.ok(administrador);
    }

    @GetMapping
    public ResponseEntity<List<Administrador>> findAll() {
        List<Administrador> administradores = administradorService.findAll();
        return ResponseEntity.ok(administradores);
    }

    @PostMapping
    public ResponseEntity<Administrador> create(@Valid @RequestBody Administrador administradorNovo) {
        administradorNovo = administradorService.create(administradorNovo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(administradorNovo.getId()).toUri();
        return ResponseEntity.created(uri).body(administradorNovo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Administrador> update(@PathVariable Integer id, @Valid @RequestBody Administrador administradorAtualizado) {
        administradorAtualizado = administradorService.update(id, administradorAtualizado);
        return ResponseEntity.ok(administradorAtualizado);
    }
}
