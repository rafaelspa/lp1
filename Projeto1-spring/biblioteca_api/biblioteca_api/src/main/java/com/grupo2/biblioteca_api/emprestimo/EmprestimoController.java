package com.grupo2.biblioteca_api.emprestimo;

import com.grupo2.biblioteca_api.usuario.Usuario;
import com.grupo2.biblioteca_api.usuario.cliente.Cliente;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/emprestimos")
public class EmprestimoController {

    private EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable Integer id) {
        Emprestimo emprestimo = emprestimoService.findById(id);
        return ResponseEntity.ok(emprestimo);
    }

    @GetMapping
    public ResponseEntity<List<Emprestimo>> findAll() {
        List<Emprestimo> emprestimos = emprestimoService.findAll();
        return ResponseEntity.ok(emprestimos);
    }

    @PostMapping
    public ResponseEntity<Emprestimo> create(@Valid @RequestBody Emprestimo emprestimoNovo) {
        emprestimoNovo = emprestimoService.create(emprestimoNovo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(emprestimoNovo.getId()).toUri();
        return ResponseEntity.created(uri).body(emprestimoNovo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Emprestimo> update(@PathVariable Integer id, @Valid @RequestBody Emprestimo emprestimoAtualizado) {
        emprestimoAtualizado = emprestimoService.update(id, emprestimoAtualizado);
        return ResponseEntity.ok(emprestimoAtualizado);
    }

    @GetMapping(value = "/cliente")
    public ResponseEntity<List<Emprestimo>> findByClient(@Valid @RequestBody Cliente cliente) {
        List<Emprestimo> listaEmprestimo = emprestimoService.findAllByCliente(cliente);
        return ResponseEntity.ok(listaEmprestimo);
    }

    @GetMapping(value = "/data")
    public ResponseEntity<List<Emprestimo>> findByDate(@Valid @RequestBody Instant to) {
        List<Emprestimo> listaEmprestimo = emprestimoService.findAllByDate(to);
        return ResponseEntity.ok(listaEmprestimo);
    }
}
