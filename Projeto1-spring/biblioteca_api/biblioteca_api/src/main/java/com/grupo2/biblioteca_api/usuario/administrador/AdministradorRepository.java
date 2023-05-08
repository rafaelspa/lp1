package com.grupo2.biblioteca_api.usuario.administrador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {
    @Query("SELECT a FROM Administrador a WHERE  a.nome LIKE %:nome%")
    Administrador findAdministradorByNome(String nome);
}
