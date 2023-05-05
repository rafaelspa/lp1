package org.grupo2.modelos;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private static List<Emprestimo> emprestimos;
    private static List<Reserva> reservas;

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

    public static boolean existeEmprestimo(int id) {
        return Objects.nonNull(emprestimos.get(id));
    }

    public static void salvarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public static Optional<Reserva> procurarReserva(Livro livro, Cliente cliente) {
        return reservas.stream().filter(reserva -> reserva.getLivro().equals(livro) && reserva.getCliente().equals(cliente)).findFirst();
    }

    public static void executarReserva(Livro livro, Cliente cliente) {

    }
}
