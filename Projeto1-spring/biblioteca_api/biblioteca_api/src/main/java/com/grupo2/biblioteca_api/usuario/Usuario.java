package com.grupo2.biblioteca_api.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    private UUID id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String senha;

    public Usuario(UUID id, String nome, String cpf, String endereco, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }
}


