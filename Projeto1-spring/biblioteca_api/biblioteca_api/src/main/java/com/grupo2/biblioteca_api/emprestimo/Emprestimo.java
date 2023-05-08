package com.grupo2.biblioteca_api.emprestimo;

import com.grupo2.biblioteca_api.livro.Livro;
import com.grupo2.biblioteca_api.usuario.cliente.Cliente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "emprestimos")
@NoArgsConstructor
@Getter
@Setter
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Livro livro;
    @ManyToOne
    private Cliente cliente;
    private Instant dataEmprestimo;
    private Instant dataDevolucao;

    public Emprestimo(Livro livro, Cliente cliente) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = Instant.now();
        this.dataDevolucao = dataEmprestimo.plus(Duration.ofDays(7));
    }
}
