package org.grupo2.modelos;

public abstract class Usuario {
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String cpf, String endereco, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void emprestarLivro(int idEmprestimo, Livro livro, Cliente cliente) throws Exception {
        if (Biblioteca.existeEmprestimo(idEmprestimo)) {
            throw new Exception("Emprestimo já existente.");
        }
        if (livro.getNumExemplaresDisponiveis() > 0) {
            throw new Exception("Não há exemplares disponíveis.");
        }
        Emprestimo emprestimo = new Emprestimo(idEmprestimo, livro, cliente);
        Biblioteca.salvarEmprestimo(emprestimo);
        System.out.println("Emprestimo realizado com sucesso");
    }

    public void devolverLivro(Livro livro) throws Exception {
        if(livro.getNumExemplaresDisponiveis() == livro.getNumExemplares()) {
            throw new Exception("Já existe uma quantidade máxima desse livro na biblioteca");
        }
        livro.devolver();
        System.out.println("Livro devolvido com sucesso!");
    }

    public void reservarLivro() {

    }

    public void cancelarReserva() {
    }
}
