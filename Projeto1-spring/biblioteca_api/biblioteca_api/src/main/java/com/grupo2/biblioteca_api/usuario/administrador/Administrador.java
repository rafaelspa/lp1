package com.grupo2.biblioteca_api.usuario.administrador;

import com.grupo2.biblioteca_api.usuario.Usuario;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class Administrador extends Usuario { // implements GerenciamentoDeUsuarios, GerenciamentoDeLivros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Administrador(String nome, String cpf, String endereco, String email, String senha) {
        super(nome, cpf, endereco, email, senha);
    }
}
