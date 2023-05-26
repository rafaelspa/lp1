import java.util.Scanner;
/*
*   O programa usa a pasta "fichas" na raiz do projeto
*   Escolha uma opção:
*   1 - Criar ficha. Preencha os dados. Uma ficha será criada com o nome completo separado por hífen.
*   2 - Atualizar ficha: Preencha o nome completo do paciente. Escolha qual dado você quer mudar.
*   3 - Visualizar ficha: Preencha o nome completo do paciente. Mostra os dados da ficha dele.
*   0 - Sair do programa
 */
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
                    "\n\nOpção: ");
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
                default:
                    System.out.println();
            }
        }
        System.out.println("\n--- Programa encerrado ---");
    }
}
