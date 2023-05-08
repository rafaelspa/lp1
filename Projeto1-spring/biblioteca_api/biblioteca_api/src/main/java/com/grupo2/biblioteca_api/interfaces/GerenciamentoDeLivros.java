package com.grupo2.biblioteca_api.interfaces;

import com.grupo2.biblioteca_api.livro.Livro;

public interface GerenciamentoDeLivros {
    void cadastrarLivro(Livro livro);
    void atualizarLivro(Livro livro);
    void removerLivro(Livro livro);
    void buscaLivro(Livro livro);
}
