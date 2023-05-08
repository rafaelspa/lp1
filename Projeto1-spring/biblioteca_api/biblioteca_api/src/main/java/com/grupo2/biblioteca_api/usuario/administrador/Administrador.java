package com.grupo2.biblioteca_api.usuario.administrador;

import com.grupo2.biblioteca_api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "administrador")
@NoArgsConstructor
@Getter
@Setter
public class Administrador extends Usuario { // implements GerenciamentoDeUsuarios, GerenciamentoDeLivros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Administrador(String nome, String cpf, String endereco, String email, String senha) {
        super(nome, cpf, endereco, email, senha);
    }
}
