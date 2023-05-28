package org.grupo2.modelos;


import java.time.Instant;

public class Funcionario extends Usuario { // implements GerenciamentoDeUsuarios, GerenciamentoDeLivros {
    private int id;

    public Funcionario() {
    }

    public Funcionario(int id, String nome, String cpf, String endereco, String email, String senha) {
        super(nome, cpf, endereco, email, senha);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Emprestimo emprestarLivro(int id, Livro livro, Cliente cliente, Instant dataEmprestimo, Instant dataDevolucao) throws Exception {
        return super.emprestarLivro(id, livro, cliente, dataEmprestimo, dataDevolucao);
    }

    public void realizarDevolucao() {

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

    public String toJson() {
        return "{\"id\": " + this.getId() + ", \"nome\": \"" + this.getNome() +
                "\", \"cpf\": \"" + this.getCpf() + "\", \"endereco\": \"" + this.getEndereco() +
                "\", \"email\": \"" + this.getEmail() + "\"}";
    }

    public static Funcionario fromJson(String requestBody) {
        String requestBodyClean = requestBody.replace("{", "").replace("}", "");
        String[] splitProperties = requestBodyClean.split(",");
        int jsonId = Integer.parseInt(splitProperties[0].split(":")[1].trim());
        String jsonNome = splitProperties[1].split(":")[1].trim().replace("\"", "");
        String jsonCpf = splitProperties[2].split(":")[1].trim().replace("\"", "");
        String jsonEndereco = splitProperties[3].split(":")[1].trim().replace("\"", "");
        String jsonEmail = splitProperties[4].split(":")[1].trim().replace("\"", "");
        String jsonSenha = splitProperties[5].split(":")[1].trim().replace("\"", "");
        return new Funcionario(jsonId, jsonNome, jsonCpf, jsonEndereco, jsonEmail, jsonSenha);
    }
}
