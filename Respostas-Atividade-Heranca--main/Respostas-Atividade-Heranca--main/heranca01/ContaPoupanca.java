package heranca01;

public class ContaPoupanca extends ContaBancaria{
    //atributos
    private int diaRendimento;

    //construtor
    public ContaPoupanca(String cliente, int numConta, double saldo, int diaRendimento){
        super(cliente, numConta, saldo);
        this.diaRendimento = diaRendimento;
    }

    //métodos
    public void calcularNovoSaldo(double taxaRendimento){
        saldo += saldo * (taxaRendimento/100);
    }

    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Dia de rendimento: " + diaRendimento);
    }
}
