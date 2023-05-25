import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FichaPaciente {
    private String nomeCompleto;
    private int idade;
    private String genero;
    private double altura;
    private double peso;

    public FichaPaciente(String nomeCompleto, int idade, String genero, double altura, double peso) {
        this.nomeCompleto = nomeCompleto;
        this.idade = idade;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public static String toGenero(char genero) {
        return genero == 'F' ? "Feminino": "Masculino";
    }

    public void saveInMemory() {
        try {
            Files.createDirectories(Paths.get("./fichas"));
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream( "./fichas/" + decompose(nomeCompleto.replace(" ","-").toLowerCase()) + ".txt"), "UTF-8");
            BufferedWriter bufWriter = new BufferedWriter(writer);
            bufWriter.write("Ficha Médica\n\n");
            bufWriter.write("Nome: " + nomeCompleto);
            bufWriter.newLine();
            bufWriter.write("Idade: " + idade + (idade != 1 ? " anos" : " ano"));
            bufWriter.newLine();
            bufWriter.write("Gênero: " + genero);
            bufWriter.newLine();
            bufWriter.write("Altura: " + altura + " m");
            bufWriter.newLine();
            bufWriter.write("Peso: " + peso + " Kg");
            bufWriter.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String decompose(String s) {
        return java.text.Normalizer.normalize(s, java.text.Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+","");
    }
}
