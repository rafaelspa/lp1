package com.grupo2.biblioteca_api.usuario;

import com.grupo2.biblioteca_api.usuario.cliente.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "/{nome}")
    public ResponseEntity<Usuario> findByName(@PathVariable String nome) {
        Usuario usuario = usuarioService.findUsuarioByName(nome);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Usuario> findByCpf(@PathVariable String cpf) {
        Usuario usuario = usuarioService.findUsuarioByCpf(cpf);
        return ResponseEntity.ok(usuario);
    }
}
