package com.grupo2.biblioteca_api.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Usuario {
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String senha;
}


