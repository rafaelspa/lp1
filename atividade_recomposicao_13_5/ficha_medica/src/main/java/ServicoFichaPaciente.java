import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

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
            File arquivoComNomeAntigo = new File("./fichas/" + transformaNome(nomePaciente) + ".txt");
            File arquivoComNomeNovo = new File("./fichas/" + transformaNome(nomePaciente) + "-antigo.txt");
            arquivoComNomeAntigo.renameTo(arquivoComNomeNovo);
            BufferedReader reader = new BufferedReader(new FileReader(
                    "./fichas/" + transformaNome(nomePaciente) + "-antigo.txt"));
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(
                    "./fichas/" + transformaNome(nomePaciente) + ".txt"), StandardCharsets.UTF_8);
            BufferedWriter bufWriter = new BufferedWriter(writer);
            String linhaAtual;
            Pattern padraoIdade = Pattern.compile(".*Idade.*");
            Pattern padraoGenero = Pattern.compile(".*Gênero.*");
            Pattern padraoAltura = Pattern.compile(".*Altura.*");
            Pattern padraoPeso = Pattern.compile(".*Peso.*");
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
                    switch (i) {
                        case 0 -> {
                            System.out.print("Nov" + ATRIBUTOS[i] + ": ");
                            int idadePaciente = sc.nextInt();
                            sc.nextLine();
                            while ((linhaAtual = reader.readLine()) != null) {
                                if (padraoIdade.matcher(linhaAtual).matches()) {
                                    bufWriter.write("Idade: " + idadePaciente + (idadePaciente != 1 ? " anos" : " ano"));
                                    bufWriter.newLine();
                                } else {
                                    bufWriter.write(linhaAtual);
                                    bufWriter.newLine();
                                }
                            }
                            arquivoComNomeNovo.deleteOnExit();
                        }
                        case 1 -> {
                            while (true) {
                                System.out.print("Nov" + ATRIBUTOS[i] + " (M/F): ");
                                generoPaciente = Character.toUpperCase(sc.nextLine().charAt(0));
                                if (generoPaciente == 'M' || generoPaciente == 'F') {
                                    break;
                                }
                                System.out.println("\n--- Aviso: M ou F ---\n");
                            }
                            while ((linhaAtual = reader.readLine()) != null) {
                                if (padraoGenero.matcher(linhaAtual).matches()) {
                                    bufWriter.write("Gênero: " + FichaPaciente.toGenero(generoPaciente));
                                    bufWriter.newLine();
                                } else {
                                    bufWriter.write(linhaAtual);
                                    bufWriter.newLine();
                                }
                            }
                            arquivoComNomeNovo.deleteOnExit();
                        }
                        case 2 -> {
                            System.out.print("Nov" + ATRIBUTOS[i] + " (use vírgula): ");
                            double alturaPaciente = sc.nextDouble();
                            sc.nextLine();
                            while ((linhaAtual = reader.readLine()) != null) {
                                if (padraoAltura.matcher(linhaAtual).matches()) {
                                    bufWriter.write("Altura: " + alturaPaciente + " m");
                                    bufWriter.newLine();
                                } else {
                                    bufWriter.write(linhaAtual);
                                    bufWriter.newLine();
                                }
                            }
                            arquivoComNomeNovo.deleteOnExit();
                        }
                        case 3 -> {
                            System.out.print("Nov" + ATRIBUTOS[i] + ": ");
                            double pesoPaciente = sc.nextDouble();
                            while ((linhaAtual = reader.readLine()) != null) {
                                if (padraoPeso.matcher(linhaAtual).matches()) {
                                    bufWriter.write("Peso: " + pesoPaciente + " Kg");
                                    bufWriter.newLine();
                                } else {
                                    bufWriter.write(linhaAtual);
                                    bufWriter.newLine();
                                }
                            }
                            arquivoComNomeNovo.deleteOnExit();
                            System.out.println();
                        }
                    }
                }
            }
            System.out.println("\n--- Ficha Atualizada ---\n");
            bufWriter.close();
            writer.close();
            reader.close();
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
            bufWriter.write("Altura: " + fichaPaciente.getAltura() + " m");
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
