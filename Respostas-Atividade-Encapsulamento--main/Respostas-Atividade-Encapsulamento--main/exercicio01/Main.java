package exercicio01;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //instanciando um objeto
        Pessoa pessoa1 = new Pessoa();

        //rodagem do objeto
        System.out.println("Digite o seu nome: ");
        pessoa1.setNome(sc.nextLine());

        System.out.println("Digite sua idade: ");
        pessoa1.setIdade(sc.nextInt());
        sc.nextLine();

        System.out.println("Digite o seu país de origem: ");
        pessoa1.setPais(sc.nextLine());

        pessoa1.exibirDados();
    }
}
