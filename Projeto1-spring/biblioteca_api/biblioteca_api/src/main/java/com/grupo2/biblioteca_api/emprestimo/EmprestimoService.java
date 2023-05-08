package com.grupo2.biblioteca_api.emprestimo;

import com.grupo2.biblioteca_api.common.exceptions.DatabaseException;
import com.grupo2.biblioteca_api.common.exceptions.ResourceNotFoundException;
import com.grupo2.biblioteca_api.usuario.cliente.Cliente;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public Emprestimo create(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> findAll() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo findById(Integer id) {
        return emprestimoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Emprestimo não encontrado."));
    }

    public Emprestimo update(Integer id, Emprestimo emprestimoAtualizado) {
        try {
            Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso nao encontrado"));
            emprestimo.setLivro(emprestimoAtualizado.getLivro());
            emprestimo.setCliente(emprestimoAtualizado.getCliente());
            emprestimo.setDataEmprestimo(emprestimoAtualizado.getDataEmprestimo());
            emprestimo.setDataDevolucao(emprestimoAtualizado.getDataDevolucao());
            return emprestimoRepository.save(emprestimo);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Emprestimo não encontrado.");
        }
    }

    public void delete(Integer id) {
        try {
            emprestimoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Emprestimo não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Esse recurso eh referenciado por outro");
        }
    }

    public ArrayList<Emprestimo> findAllByCliente(Cliente cliente) {
        ArrayList<Emprestimo> listaEmprestimo = (ArrayList<Emprestimo>) emprestimoRepository.findAllByCliente(cliente);
        return listaEmprestimo;
    }
}
