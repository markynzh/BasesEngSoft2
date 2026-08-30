package heranca01;
import java.util.Scanner;

public class ContaBancaria {
    Scanner sc = new Scanner(System.in);

   //atributos
    private String cliente;
    private int numConta;
    protected double saldo;

    //construtor
    public ContaBancaria (String cliente, int numConta, double saldo){
        this.cliente = cliente;
        this.numConta = numConta;
        this.saldo = 0;
    }

    //métodos
    public void sacarValor (double valor){
        if (valor > saldo){
            System.out.print("Saldo insuficiente!\nInsira um novo valor: ");
            valor = sc.nextDouble();
        } else {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        }
    }

    public void depositarValor (double valor){
        if (valor>0){
            saldo += valor;
            System.out.println("Depósito realizado com sucesso! ");
        } else {
            System.out.println("Valor inválido para depósito!\nInsira um novo valor: ");
            valor = sc.nextDouble();
        }
    }

    public void exibirDados(){
        System.out.println("Cliente: "+ cliente);
        System.out.println("Conta: "+ numConta);
        System.out.println("Saldo: R$"+ saldo);
    }
}
