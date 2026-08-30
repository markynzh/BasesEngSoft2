import java.util.Scanner;

public class Marketplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Servico servico = new Servico();

        while (true){
            System.out.println("--- MENU ----" + "\n1- Listar serviços" + "\n2- Cadastrar serviços" + "\n3- Buscar serviço" + "\n4- Realizar pedido" + "\n5- Sair" + "\nDigite: ");
            int escolha = sc.nextInt();

            if (escolha==1) {
                servico.exibirServico();
            }

            else if (escolha ==2) {
                servico.cadastrarServico();
            }

            else if (escolha == 3){
                servico.buscarServico();
            }

            else if (escolha == 4){
                servico.realizarServico();
            }

            else if (escolha ==5){
                System.out.println("Programa encerrado!");
                break;
            }
        }

        sc.close();
    }
}