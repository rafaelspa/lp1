import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        Double alturaPaciente = sc.nextDouble();
        System.out.print("Peso do paciente (em Kg, use vírgula): ");
        Double pesoPaciente = sc.nextDouble();

        FichaPaciente fichaPaciente1 = new FichaPaciente(1, nomePaciente,
                idadePaciente, FichaPaciente.toGenero(generoPaciente),
                alturaPaciente, pesoPaciente);

        fichaPaciente1.saveInMemory();

        sc.close();
    }
}
