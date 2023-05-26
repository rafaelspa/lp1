import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ServicoFichaPaciente {
    static Scanner sc = new Scanner(System.in);
    char generoPaciente;
    final String[] ATRIBUTOS = {"a idade", "o genero", "a altura", "o peso"};

    public ServicoFichaPaciente() {
    }

    public void criarFichaPaciente() {
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
            System.out.println("\n--- Aviso: M ou F ---\n");
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

    public void atualizarFichaPaciente() {
        char opcaoMudar = 'i';
        System.out.println("# #");
        System.out.print("ATUALIZAÇÃO DE FICHA DE PACIENTE\n");
        System.out.println("# #\n");
        System.out.print("Nome completo do paciente: ");
        String nomePaciente = sc.nextLine();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    "./fichas/" + transformaNome(nomePaciente) + ".txt"));
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                while (true) {
                    System.out.print("Mudar " + ATRIBUTOS[i] + " (S ou N)? ");
                    opcaoMudar = Character.toUpperCase(sc.nextLine().charAt(0));
                    if (opcaoMudar == 'S' || opcaoMudar == 'N') {
                        break;
                    }
                    System.out.println("\n--- Aviso: S ou N ---\n");
                }
                if (opcaoMudar == 'S') {
                    System.out.print("Nov" + ATRIBUTOS[i] + ": ");
                    switch (i) {
                        case 0:
                            int idadePaciente = sc.nextInt();
                            sc.nextLine();
                            break;
                        case 1:
                            while (true) {
                                generoPaciente = Character.toUpperCase(sc.nextLine().charAt(0));
                                if (generoPaciente == 'M' || generoPaciente == 'F') {
                                    break;
                                }
                                System.out.println("\n--- Aviso: M ou F ---\n");
                            }
                            break;
                        case 2:
                            double alturaPaciente = sc.nextDouble();
                            break;
                        case 3:
                            double pesoPaciente = sc.nextDouble();
                            break;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("\nArquivo não encontrado: " + e.getMessage() + "\n");
        }
    }

    public void verFichaPaciente() {
    }

    public void saveInMemory(FichaPaciente fichaPaciente) {
        try {
            Files.createDirectories(Paths.get("./fichas"));
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(
                    "./fichas/" + transformaNome(fichaPaciente.getNomeCompleto()) + ".txt"), StandardCharsets.UTF_8);
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
            System.out.println("\n--- Ficha salva com sucesso ---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String transformaNome(String nome) {
        return decompose(nome.replace(" ","-").toLowerCase());
    }

    private String decompose(String s) {
        return java.text.Normalizer.normalize(s, java.text.Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+","");
    }
}
