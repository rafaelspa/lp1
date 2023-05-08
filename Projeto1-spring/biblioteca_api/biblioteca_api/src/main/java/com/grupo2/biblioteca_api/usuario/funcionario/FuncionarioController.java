package com.grupo2.biblioteca_api.usuario.funcionario;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Integer id) {
        Funcionario funcionario = funcionarioService.findById(id);
        return ResponseEntity.ok(funcionario);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> funcionario = funcionarioService.findAll();
        return ResponseEntity.ok(funcionario);
    }

    @PostMapping
    public ResponseEntity<Funcionario> create(@Valid @RequestBody Funcionario funcionarioNovo) {
        funcionarioNovo = funcionarioService.create(funcionarioNovo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(funcionarioNovo.getId()).toUri();
        return ResponseEntity.created(uri).body(funcionarioNovo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Integer id, @Valid @RequestBody Funcionario funcionarioAtualizado) {
        funcionarioAtualizado = funcionarioService.update(id, funcionarioAtualizado);
        return ResponseEntity.ok(funcionarioAtualizado);
    }
}
