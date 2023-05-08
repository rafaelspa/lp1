package com.grupo2.biblioteca_api.interfaces;

import com.grupo2.biblioteca_api.usuario.Usuario;

public interface GerenciamentoDeUsuarios {
    void cadastrarUsuario(Usuario usuario);
    void atualizarUsuario(Usuario usuario);
    void removerUsuario(Usuario usuario);
    void buscaUsuario(Usuario usuario);
}
