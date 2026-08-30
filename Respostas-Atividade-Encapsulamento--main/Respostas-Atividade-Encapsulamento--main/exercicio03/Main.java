package exercicio03;

public class Main {
    public static void main (String[] args){
        Funcionario funcionario1 = new Funcionario(1234, "Marcos Bandeira", 3550.6F);

        System.out.println("O ID do funcionário é: " + funcionario1.getIdFuncionario());
        System.out.println("O nome do funcionário é: " + funcionario1.getNomeFuncionario());
        System.out.println("O salário do funcionário é: " + funcionario1.getSalarioFuncionario());


    }
}
