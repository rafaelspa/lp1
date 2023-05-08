package com.grupo2.biblioteca_api.usuario.administrador;

import com.grupo2.biblioteca_api.common.exceptions.DatabaseException;
import com.grupo2.biblioteca_api.common.exceptions.ResourceNotFoundException;
import com.grupo2.biblioteca_api.usuario.Usuario;
import com.grupo2.biblioteca_api.usuario.cliente.Cliente;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {
    private final AdministradorRepository administradorRepository;

    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    public Administrador create(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public List<Administrador> findAll() {
        return administradorRepository.findAll();
    }

    public Administrador findById(Integer id) {
        return administradorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Administrador não encontrado."));
    }

    public Administrador update(Integer id, Administrador administradorAtualizado) {
        try {
            Administrador administrador = administradorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso nao encontrado"));
            administrador.setNome(administradorAtualizado.getNome());
            administrador.setCpf(administradorAtualizado.getCpf());
            administrador.setEndereco(administradorAtualizado.getEndereco());
            administrador.setSenha(administradorAtualizado.getSenha());
            return administradorRepository.save(administrador);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Administrador não encontrado.");
        }
    }

    public void delete(Integer id) {
        try {
            administradorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Administrador não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Esse recurso eh referenciado por outro");
        }
    }

    public Administrador findByName(String nome) {
         return administradorRepository.findAdministradorByNome(nome);
    }

    public Administrador findByCpf(String cpf) {
        return administradorRepository.findAdministradorByCpf(cpf);
    }
}
