import java.io.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char generoPaciente;

        System.out.println("FICHA PACIENTE\n");
        System.out.print("Nome do paciente: ");
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
            System.out.println("Erro: M ou F");
        }
        System.out.print("Altura do paciente: ");
        Double alturaPaciente = sc.nextDouble();
        System.out.print("Peso do paciente (Kg): ");
        Double pesoPaciente = sc.nextDouble();


        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("ficha_medica_" + nomePaciente.split(" ")[0] + ".txt"), "UTF-8");
            BufferedWriter bufWriter = new BufferedWriter(writer);
            bufWriter.write("Ficha Médica\n\n");
            bufWriter.write("Nome: " + nomePaciente);
            bufWriter.newLine();
            bufWriter.write("Idade: " + idadePaciente + " ano(s)");
            bufWriter.newLine();
            bufWriter.write("Gênero: " + (generoPaciente == 'M' ? "Masculino" : "Feminino"));
            bufWriter.newLine();
            bufWriter.write("Altura: " + alturaPaciente + " m");
            bufWriter.newLine();
            bufWriter.write("Peso: " + pesoPaciente + " Kg");
            bufWriter.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



        sc.close();
    }
}
