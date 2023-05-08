package com.grupo2.biblioteca_api.usuario.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    @Query("SELECT f FROM Funcionario f WHERE  f.nome LIKE %?1%")
    Funcionario findFuncionarioByNome(String nome);
    @Query("SELECT f FROM Funcionario f WHERE  f.cpf LIKE %?1%")
    Funcionario findFuncionarioByCpf(String cpf);
}
