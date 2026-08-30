package aumentoSalarial;

public class Funcionarios {
    String nome;
    double salario;

    public double calcularNovoSalario(){
        if (salario>=1 && salario<=1000){
            return salario * 1.15;
        } else if (salario>=1001 && salario<=1500) {
            return salario * 1.1;
        } else if (salario>=1501 && salario<=2000) {
            return salario * 1.05;
        } else {
            return salario;
        }
    }

    public void exibirDados(){
        System.out.printf("O salário antigo era de: %.2f", salario);
        System.out.printf("\nO salário atual, após o aumento é de: %.2f", calcularNovoSalario());
    }
}
