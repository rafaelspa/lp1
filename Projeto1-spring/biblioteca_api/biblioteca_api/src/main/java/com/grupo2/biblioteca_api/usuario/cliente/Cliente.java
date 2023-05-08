package com.grupo2.biblioteca_api.usuario.cliente;

import com.grupo2.biblioteca_api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@Getter
@Setter
public class Cliente extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Cliente(String nome, String cpf, String endereco, String email, String senha) {
        super(nome, cpf, endereco, email, senha);
    }


}
