import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServicoFichaPaciente servicoFichaPaciente = new ServicoFichaPaciente();
        int opcao = -1;

        System.out.println("\n############################################");
        System.out.println("Bem vindo ao sistema de Fichas de Pacientes!");
        System.out.println("############################################\n");

        while (opcao != 0) {
            System.out.print("Por favor, escolha uma opcao:" +
                    "\n\n1: Cadastrar Ficha" +
                    "\n2: Atualizar Ficha" +
                    "\n3: Ver Ficha" +
                    "\n0: Para encerrar o sistema" +
                    "\n\nOpcao: ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    System.out.println();
                    servicoFichaPaciente.criarFichaPaciente();
                    break;
                case 2:
                    System.out.println();
                    servicoFichaPaciente.atualizarFichaPaciente();
                    break;
                case 3:
                    System.out.println();
                    servicoFichaPaciente.verFichaPaciente();
                    break;
            }
        }
        System.out.println("\n--- Programa encerrado ---");
    }
}
