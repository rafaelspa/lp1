package com.grupo2.biblioteca_api.usuario.funcionario;

import com.grupo2.biblioteca_api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionarios")
@NoArgsConstructor
@Getter
@Setter
public class Funcionario extends Usuario { // implements GerenciamentoDeUsuarios, GerenciamentoDeLivros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Funcionario(String nome, String cpf, String endereco, String email, String senha) {
        super(nome, cpf, endereco, email, senha);
    }
}
