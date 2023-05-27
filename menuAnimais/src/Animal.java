public class Animal {
    private int id;
    private String nome;
    private String tipo;

    public Animal(int id, String nome, String especie) {
        this.id = id;
        this.nome = nome;
        this.tipo = especie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Dados do animal\n\n" +
                "id: " + id + "\n" +
                "nome: " + nome + '\n' +
                "tipo: " + tipo;
    }
}
