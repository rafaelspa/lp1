package org.grupo2.modelos;


import org.grupo2.interfaces.GerenciamentoDeLivros;
import org.grupo2.interfaces.GerenciamentoDeUsuarios;

public class Funcionario  extends Usuario { // implements GerenciamentoDeUsuarios, GerenciamentoDeLivros {
    private int id;

    public Funcionario(String nome, String cpf, String endereco, String email, String senha, int id) {
        super(nome, cpf, endereco, email, senha);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void realizarEmprestimo(){

    }

    public void realizarDevolucao(){

    }

//    @Override
//    public void emprestarLivro() {
//
//    }
//
//    @Override
//    public void devolverLivro() {
//
//    }
//
//    @Override
//    public void reservarLivro() {
//
//    }
//
//    @Override
//    public void cancelarReserva() {
//
//    }
//
//    @Override
//    public void cadastrarLivro() {
//
//    }
//
//    @Override
//    public void atualizarLivro() {
//
//    }
//
//    @Override
//    public void removerLivro() {
//
//    }
//
//    @Override
//    public void buscarLivro() {
//
//    }
//
//    @Override
//    public void cadastrarUsuario() {
//
//    }
//
//    @Override
//    public void atualizarUsuario() {
//
//    }
//
//    @Override
//    public void removerUsuario() {
//
//    }
//
//    @Override
//    public void buscarUsuario() {
//
//    }
}
