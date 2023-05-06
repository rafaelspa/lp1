package org.grupo2.modelos;

import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {
    private final static Integer idLivros = 0;
    private final static Integer idUsuarios = 0;
    private final static Integer idEmprestimos = 0;
    private final static Integer idReservas = 0;
    private Map<Integer, Livro> livros;
    private Map<Integer, Usuario> usuarios;
    private static Map<Integer, Emprestimo> emprestimos;
    private static Map<Integer, Reserva> reservas;

    public Livro retornaLivro(String nome) {
        // TODO: 24/04/2023
        return null;
    }

    public void listarLivros() {
        // TODO: 24/04/2023
    }

    public Usuario buscarUsuarioNome(String nome) {
        // TODO: 24/04/2023
        return null;
    }

    public Usuario buscarUsuarioCpf(String cpf) {
        // TODO: 24/04/2023
        return null;
    }

    public void listarUsuarios() {
        // TODO: 24/04/2023
    }

    public void listarClientes() {
        // TODO: 24/04/2023
    }

    public void listarFuncionarios() {
        // TODO: 24/04/2023
    }

    public void listarEmprestimos() {
        // TODO: 24/04/2023
    }

    public void listarEmprestimosCliente(Cliente cliente) {
        // TODO: 24/04/2023
    }

    public void listarEmprestimosData(Date data) {
        // TODO: 24/04/2023
    }

    public void login(String cpf, String senha) {
        // TODO: 24/04/2023
    }

    public static boolean existeEmprestimoPorId(int id) {
        return Objects.nonNull(emprestimos.get(id));
    }

    public static void salvaEmprestimo(Emprestimo emprestimo) {
        emprestimos.put(Biblioteca.idEmprestimos + 1, emprestimo);
    }

    public static void salvarReserva(Reserva reserva) {
        reservas.put(Biblioteca.idReservas + 1, reserva);
    }

    public static Optional<Reserva> procurarReservaPorLivroECliente(Livro livro, Cliente cliente) {
        Optional<Reserva> reservaOptional = Optional.empty();
        for (int i = 1; i < reservas.size() + 1; i++) {
            if (reservas.get(i).getLivro().equals(livro) && reservas.get(i).getCliente().equals(cliente)) {
                reservaOptional = Optional.of(reservas.get(i));
                break;
            }
        }
        return reservaOptional;
    }

    public static Optional<Reserva> procuraReservaPorId(int id) {
        return Optional.of(reservas.get(id));
    }

    public static void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva.getId());
    }
}
