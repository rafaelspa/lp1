package com.grupo2.biblioteca_api.usuario.cliente;

import com.grupo2.biblioteca_api.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@Getter
@Setter
public class Cliente  {
    @Id
    private UUID id;

    @OneToOne
    private Usuario usuario;

    public Cliente(UUID id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }
}
