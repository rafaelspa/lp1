package com.grupo2.biblioteca_api.usuario.cliente;

import com.grupo2.biblioteca_api.common.exceptions.DatabaseException;
import com.grupo2.biblioteca_api.common.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado."));
    }

    public Cliente update(Integer id, Cliente clienteAtualizado) {
        try {
            Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso nao encontrado"));
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setCpf(clienteAtualizado.getCpf());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            cliente.setSenha(clienteAtualizado.getSenha());
            return clienteRepository.save(cliente);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Cliente não encontrado.");
        }
    }

    public void delete(Integer id) {
        try {
            clienteRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Esse recurso eh referenciado por outro");
        }
    }

    public Cliente findByName(String nome) {
        return clienteRepository.findClienteByNome(nome);
    }
}
