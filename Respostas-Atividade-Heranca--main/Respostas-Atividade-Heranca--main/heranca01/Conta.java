package heranca01;
import java.util.Scanner;

public class Conta {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("CADASTRO CONTA POUPANÇA");
        System.out.print("Nome do cliente: ");
        String nomeP = sc.nextLine();
        System.out.print("Número da conta: ");
        int contaP = sc.nextInt();
        System.out.print("Saldo inicial: ");
        double saldoP = sc.nextDouble();
        System.out.print("Dia de rendimento: ");
        int diaP = sc.nextInt();
        ContaPoupanca contaPoupanca = new ContaPoupanca(nomeP, contaP, saldoP, diaP);
        sc.nextLine();


        System.out.println("\nCADASTRO CONTA ESPECIAL");
        System.out.print("Nome do cliente: ");
        String nomeE = sc.nextLine();
        System.out.print("Número da conta: ");
        int numeroE = sc.nextInt();
        System.out.print("Saldo inicial: ");
        double saldoE = sc.nextDouble();
        System.out.print("Limite: ");
        double limite = sc.nextDouble();
        ContaEspecial contaEspecial = new ContaEspecial(nomeE, numeroE, saldoE, limite);

        System.out.print("\nDepósito conta poupança: ");
        contaPoupanca.depositarValor(sc.nextDouble());
        System.out.print("Saque conta poupança: ");
        contaPoupanca.sacarValor(sc.nextDouble());
        System.out.print("Taxa de rendimento (%): ");
        contaPoupanca.calcularNovoSaldo(sc.nextDouble());

        System.out.print("\nDepósito conta especial: ");
        contaEspecial.depositarValor(sc.nextDouble());
        System.out.print("Saque conta especial: ");
        contaEspecial.sacarValor(sc.nextDouble());

        System.out.println("\nDADOS DAS CONTAS");
        contaPoupanca.exibirDados();
        System.out.println();
        contaEspecial.exibirDados();
    }
}
