package estoque;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
       Scanner scan = new Scanner(System.in);

       //instanciando produto da classe Produto()
        Produto produto1 = new Produto();

        //leitura de dados
        System.out.println("Digite o nome do produto: ");
        produto1.nome = scan.nextLine();

        System.out.println("Digite o preço do produto: ");
        produto1.preco = scan.nextDouble();

        System.out.println("Digite a quantidade no estoque do produto: ");
        produto1.qntdEstoque = scan.nextInt();

        //exibição dos dados
        System.out.println("\nDados do produto!");
        produto1.exibirDados();

        //entrada e exibição dos dados
        System.out.println("Digite quanto você deseja adicionar ao estoque: ");
        int qntdAdicionada = scan.nextInt();
        produto1.adicionarEstoque(qntdAdicionada);
        System.out.println("\nDados após a adição no estoque!");
        produto1.exibirDados();

        //saída e exibição dos dados
        System.out.println("Digite quanto você deseja retirar do estoque: ");
        int qntdRemovida = scan.nextInt();
        produto1.removerEstoque(qntdRemovida);
        System.out.println("\nDados após a remoção no estoque!");
        produto1.exibirDados();

        scan.close();
    }
}
