import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ServicoFichaPaciente {
    static Scanner sc = new Scanner(System.in);
    public ServicoFichaPaciente() {
    }

    public void ccriarFichaPaciente() {
        char generoPaciente;
        System.out.println("# #");
        System.out.print("CRIAÇÃO DE FICHA DE PACIENTE\n");
        System.out.println("# #\n");
        System.out.print("Nome completo do paciente: ");
        String nomePaciente = sc.nextLine();
        System.out.print("Idade do paciente (anos): ");
        int idadePaciente = sc.nextInt();
        sc.nextLine();
        while (true) {
            System.out.print("Genero do paciente (M/F): ");
            generoPaciente = Character.toUpperCase(sc.nextLine().charAt(0));
            if (generoPaciente == 'M' || generoPaciente == 'F') {
                break;
            }
            System.out.println("Aviso: M ou F");
        }
        System.out.print("Altura do paciente (use vírgula): ");
        double alturaPaciente = sc.nextDouble();
        System.out.print("Peso do paciente (em Kg, use vírgula): ");
        double pesoPaciente = sc.nextDouble();

        FichaPaciente fichaPaciente = new FichaPaciente(nomePaciente,
                idadePaciente, FichaPaciente.toGenero(generoPaciente),
                alturaPaciente, pesoPaciente);

        saveInMemory(fichaPaciente);
    }

    public void saveInMemory(FichaPaciente fichaPaciente) {
        try {
            Files.createDirectories(Paths.get("./fichas"));
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream( "./fichas/" + decompose(fichaPaciente.getNomeCompleto().replace(" ","-").toLowerCase()) + ".txt"), "UTF-8");
            BufferedWriter bufWriter = new BufferedWriter(writer);
            bufWriter.write("Ficha Médica\n\n");
            bufWriter.write("Nome: " + fichaPaciente.getNomeCompleto());
            bufWriter.newLine();
            bufWriter.write("Idade: " + fichaPaciente.getIdade() + (fichaPaciente.getIdade() != 1 ? " anos" : " ano"));
            bufWriter.newLine();
            bufWriter.write("Gênero: " + fichaPaciente.getGenero());
            bufWriter.newLine();
            bufWriter.write("Altura: " + fichaPaciente.getAltura()+ " m");
            bufWriter.newLine();
            bufWriter.write("Peso: " + fichaPaciente.getPeso() + " Kg");
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
