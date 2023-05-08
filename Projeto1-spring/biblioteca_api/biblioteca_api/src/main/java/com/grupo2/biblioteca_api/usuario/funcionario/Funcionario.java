package com.grupo2.biblioteca_api.usuario.funcionario;

import com.grupo2.biblioteca_api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "funcionarios")
@NoArgsConstructor
@Getter
@Setter
public class Funcionario { // implements GerenciamentoDeUsuarios, GerenciamentoDeLivros {
    @Id
    private UUID id;

    @OneToOne
    private Usuario usuario;

    public Funcionario(String nome, String cpf, String endereco, String email, String senha, UUID id, Usuario usuario) {
        this.id = UUID.randomUUID();
        this.usuario = usuario;
    }
}
