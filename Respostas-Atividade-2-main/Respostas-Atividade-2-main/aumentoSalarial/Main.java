package aumentoSalarial;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //entrada de dados
        Scanner scanner = new Scanner (System.in);

        //instanciando um objeto da classe Funcionario
        Funcionarios funcionario = new Funcionarios();

        //entada nome funcionario
        System.out.println("Escreva o nome do funcionário: ");
        funcionario.nome = scanner.nextLine();

        //entrada salario funcionario
        System.out.println("Digite o salario do salário: ");
        funcionario.salario = scanner.nextDouble();

        //metodo para calcular aumento salarial
        funcionario.calcularNovoSalario();

        //metodo para exibir os dados
        funcionario.exibirDados();


    }
}
