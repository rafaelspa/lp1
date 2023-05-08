package com.grupo2.biblioteca_api.usuario.administrador;

import com.grupo2.biblioteca_api.usuario.Usuario;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.UUID;

public class Administrador { // implements GerenciamentoDeUsuarios, GerenciamentoDeLivros {
    @Id
    private UUID id;

    @OneToOne
    private Usuario usuario;

    public Administrador(UUID id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }
}
