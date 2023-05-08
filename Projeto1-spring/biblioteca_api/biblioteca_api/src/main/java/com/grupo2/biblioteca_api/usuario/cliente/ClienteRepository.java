package com.grupo2.biblioteca_api.usuario.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("SELECT c FROM Cliente c WHERE  c.nome LIKE %?1%")
    Cliente findClienteByNome(String nome);
    Cliente findClienteByCpf(String cpf);
}
