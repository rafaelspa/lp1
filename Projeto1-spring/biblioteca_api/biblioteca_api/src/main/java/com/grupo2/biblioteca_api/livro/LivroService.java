package com.grupo2.biblioteca_api.livro;

import com.grupo2.biblioteca_api.common.exceptions.DatabaseException;
import com.grupo2.biblioteca_api.common.exceptions.ResourceNotFoundException;
import com.grupo2.biblioteca_api.usuario.cliente.Cliente;
import com.grupo2.biblioteca_api.usuario.cliente.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro create(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Integer id) {
        return livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado."));
    }

    public Livro update(Integer id, Livro livroAtualizado) {
        try {
            Livro livro = livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso nao encontrado"));
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setEditora(livroAtualizado.getEditora());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            livro.setNumExemplares(livroAtualizado.getNumExemplares());
            livro.setNumExemplaresDisponiveis(livroAtualizado.getNumExemplaresDisponiveis());
            return livroRepository.save(livro);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Livro não encontrado.");
        }
    }

    public void delete(Integer id) {
        try {
            livroRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Livro não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Esse recurso eh referenciado por outro");
        }
    }
}
