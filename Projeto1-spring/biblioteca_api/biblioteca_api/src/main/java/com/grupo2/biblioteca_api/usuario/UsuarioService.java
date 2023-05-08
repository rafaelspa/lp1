package com.grupo2.biblioteca_api.usuario;

import com.grupo2.biblioteca_api.common.exceptions.ResourceNotFoundException;
import com.grupo2.biblioteca_api.usuario.administrador.AdministradorService;
import com.grupo2.biblioteca_api.usuario.cliente.ClienteService;
import com.grupo2.biblioteca_api.usuario.funcionario.FuncionarioService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioService {
    private ClienteService clienteService;
    private FuncionarioService funcionarioService;
    private AdministradorService administradorService;

    public Usuario findUsuarioByName(String nome) {
        Usuario usuarioCliente = clienteService.findByName(nome);
        Usuario usuarioFuncionario = funcionarioService.findByName(nome);
        Usuario usuarioAdministrador = administradorService.findByName(nome);
        return Objects.nonNull(usuarioCliente) ? usuarioCliente
                : Objects.nonNull(usuarioFuncionario)
                ? usuarioFuncionario
                : Objects.nonNull(usuarioAdministrador)
                ? usuarioAdministrador
                : null;
    }

    public Usuario findUsuarioByCpf(String cpf) {
        Usuario usuarioCliente = clienteService.findByCpf(cpf);
        Usuario usuarioFuncionario = funcionarioService.findByCpf(cpf);
        Usuario usuarioAdministrador = administradorService.findByCpf(cpf);
        return Objects.nonNull(usuarioCliente) ? usuarioCliente
                : Objects.nonNull(usuarioFuncionario)
                ? usuarioFuncionario
                : Objects.nonNull(usuarioAdministrador)
                ? usuarioAdministrador
                : null;
    }
}
