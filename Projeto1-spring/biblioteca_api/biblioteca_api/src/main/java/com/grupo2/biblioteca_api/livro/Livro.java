package com.grupo2.biblioteca_api.livro;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "livros")
@NoArgsConstructor
@Getter
@Setter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String autor;
    private String editora;
    private Integer anoPublicacao;
    private Integer numExemplares;
    private Integer numExemplaresDisponiveis;

    public Livro(String titulo, String autor, String editora, Integer anoPublicacao, Integer numExemplares, Integer numExemplaresDisponiveis) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.numExemplares = numExemplares;
        this.numExemplaresDisponiveis = numExemplaresDisponiveis;
    }
}
