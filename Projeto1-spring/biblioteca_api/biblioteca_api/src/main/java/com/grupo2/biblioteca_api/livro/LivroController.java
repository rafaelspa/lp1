package com.grupo2.biblioteca_api.livro;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok(livro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        List<Livro> livros = livroService.findAll();
        return ResponseEntity.ok(livros);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@Valid @RequestBody Livro livroNovo) {
        livroNovo = livroService.create(livroNovo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(livroNovo.getId()).toUri();
        return ResponseEntity.created(uri).body(livroNovo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @Valid @RequestBody Livro livroAtualizado) {
        livroAtualizado = livroService.update(id, livroAtualizado);
        return ResponseEntity.ok(livroAtualizado);
    }
}
