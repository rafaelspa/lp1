package com.grupo2.biblioteca_api.emprestimo;

import com.grupo2.biblioteca_api.usuario.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
    List<Emprestimo> findAllByCliente(Cliente cliente);
}
