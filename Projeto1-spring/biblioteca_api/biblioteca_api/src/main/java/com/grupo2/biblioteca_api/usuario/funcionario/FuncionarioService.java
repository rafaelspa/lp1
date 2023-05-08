package com.grupo2.biblioteca_api.usuario.funcionario;

import com.grupo2.biblioteca_api.common.exceptions.DatabaseException;
import com.grupo2.biblioteca_api.common.exceptions.ResourceNotFoundException;
import com.grupo2.biblioteca_api.usuario.administrador.Administrador;
import com.grupo2.biblioteca_api.usuario.administrador.AdministradorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario create(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(Integer id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado."));
    }

    public Funcionario update(Integer id, Funcionario funcionarioAtualizado) {
        try {
            Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso nao encontrado"));
            funcionario.setNome(funcionarioAtualizado.getNome());
            funcionario.setCpf(funcionarioAtualizado.getCpf());
            funcionario.setEndereco(funcionarioAtualizado.getEndereco());
            funcionario.setSenha(funcionarioAtualizado.getSenha());
            return funcionarioRepository.save(funcionario);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Funcionario não encontrado.");
        }
    }

    public void delete(Integer id) {
        try {
            funcionarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Funcionario não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Esse recurso eh referenciado por outro");
        }
    }
}
