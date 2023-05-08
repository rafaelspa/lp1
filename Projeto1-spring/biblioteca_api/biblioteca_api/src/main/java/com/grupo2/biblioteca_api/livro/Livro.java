package com.grupo2.biblioteca_api.livro;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "livros")
@NoArgsConstructor
@Getter
@Setter
public class Livro {
    @Id
    private UUID id;
    private String titulo;
    private String autor;
    private String editora;
    private Integer anoPublicacao;
    private Integer numExemplares;
    private Integer numExemplaresDisponiveis;

    public Livro(UUID id, String titulo, String autor, String editora, Integer anoPublicacao, Integer numExemplares, Integer numExemplaresDisponiveis) {
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.numExemplares = numExemplares;
        this.numExemplaresDisponiveis = numExemplaresDisponiveis;
    }
}
