package heranca01;
import java.util.Scanner;

public class ContaEspecial extends ContaBancaria {
    Scanner sc = new Scanner(System.in);

    //atributos
    public double limite;

    //construtor
    public ContaEspecial(String cliente, int numConta, double saldo, double limite) {
        super(cliente, numConta, saldo);
        this.limite = limite;
    }

    //métodos
    @Override
    public void sacarValor(double valor){
        if (saldo + limite >= valor){
            System.out.println("Saldo realizado com sucesso");
            saldo -= valor;
        } else {
            System.out.println("O valor ultrapassou o limite!");
        }
    }

    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Limite: R$"+ limite);
    }

}
