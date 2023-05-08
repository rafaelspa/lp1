create table if not exists administrador
(
    id       int auto_increment
        primary key,
    cpf      varchar(255) null,
    email    varchar(255) null,
    endereco varchar(255) null,
    nome     varchar(255) null,
    senha    varchar(255) null
);

create table if not exists clientes
(
    id       int auto_increment
        primary key,
    cpf      varchar(255) null,
    email    varchar(255) null,
    endereco varchar(255) null,
    nome     varchar(255) null,
    senha    varchar(255) null
);

create table if not exists funcionarios
(
    id       int auto_increment
        primary key,
    cpf      varchar(255) null,
    email    varchar(255) null,
    endereco varchar(255) null,
    nome     varchar(255) null,
    senha    varchar(255) null
);

create table if not exists livros
(
    id                         int auto_increment
        primary key,
    ano_publicacao             int          null,
    autor                      varchar(255) null,
    editora                    varchar(255) null,
    num_exemplares             int          null,
    num_exemplares_disponiveis int          null,
    titulo                     varchar(255) null
);

create table if not exists emprestimos
(
    id              int auto_increment
        primary key,
    data_devolucao  datetime(6) null,
    data_emprestimo datetime(6) null,
    cliente_id      int         null,
    livro_id        int         null,
    constraint FK3m8mbjea6db14m6k4qtgxvtef
        foreign key (cliente_id) references clientes (id),
    constraint FKljc60fwmihjgdsn2ee23yka0k
        foreign key (livro_id) references livros (id)
);

INSERT INTO bibliotecaapi.administrador (id, cpf, email, endereco, nome, senha) VALUES (1, '"300.000.000-01"', 'ad1@email.com', 'end ad 1', 'ad 1', 'sen ad 1');

INSERT INTO bibliotecaapi.funcionarios (id, cpf, email, endereco, nome, senha) VALUES (1, '200.000.000-01', 'fc1@email.com', 'end fc1', 'fc1', 'sen fc1');
INSERT INTO bibliotecaapi.funcionarios (id, cpf, email, endereco, nome, senha) VALUES (2, '200.000.000-02', 'fc2@email.com', 'end fc2', 'fc2', 'sen fc2');
INSERT INTO bibliotecaapi.funcionarios (id, cpf, email, endereco, nome, senha) VALUES (3, '200.000.000-03', 'fc3@email.com', 'end fc3', 'fc3', 'sen fc3');

INSERT INTO bibliotecaapi.clientes (id, cpf, email, endereco, nome, senha) VALUES (1, '100.000.000-01', 'cl1@email.com', 'end cl1', 'cl1', 'sen cl1');
INSERT INTO bibliotecaapi.clientes (id, cpf, email, endereco, nome, senha) VALUES (2, '100.000.000-02', 'cl2@email.com', 'end cl2', 'cl2', 'sen cl2');
INSERT INTO bibliotecaapi.clientes (id, cpf, email, endereco, nome, senha) VALUES (3, '100.000.000-03', 'cl3@email.com', 'end cl3', 'cl3', 'sen cl3');

INSERT INTO bibliotecaapi.livros (id, ano_publicacao, autor, editora, num_exemplares, num_exemplares_disponiveis, titulo) VALUES (1, 1997, 'J.K Rowling', 'Rocco', 12, 12, 'Harry Potter e a Pedra Filosofal');
INSERT INTO bibliotecaapi.livros (id, ano_publicacao, autor, editora, num_exemplares, num_exemplares_disponiveis, titulo) VALUES (2, 1998, 'J.K Rowling', 'Rocco', 10, 10, 'Harry Potter e a Camara Secreta');
INSERT INTO bibliotecaapi.livros (id, ano_publicacao, autor, editora, num_exemplares, num_exemplares_disponiveis, titulo) VALUES (3, 1999, 'J.K Rowling', 'Rocco', 13, 9, 'Harry Potter e o Prisioneiro de Azkaban');

INSERT INTO bibliotecaapi.emprestimos (id, data_devolucao, data_emprestimo, cliente_id, livro_id) VALUES (2, '2023-05-15 06:21:16', '2023-05-08 06:21:01', 1, 1);
INSERT INTO bibliotecaapi.emprestimos (id, data_devolucao, data_emprestimo, cliente_id, livro_id) VALUES (3, '2024-05-10 06:21:30', '1970-01-01 00:00:00.003000', 2, 2);

