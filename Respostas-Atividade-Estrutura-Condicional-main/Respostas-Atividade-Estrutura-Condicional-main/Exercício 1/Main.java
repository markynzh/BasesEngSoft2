import javax.swing.*;
import static java.lang.Integer.parseInt;

public class Main{
  public static void main(String[] args) {
    float bonus, novoSalario;

    String salarioStr = JOptionPane.showInputDialog("Digite seu salário: ");
    String tempoServicoStr = JOptionPane.showInputDialog("Diga o seu tempo de serviço em ano(s): ");

    float salario = Float.parseFloat(salarioStr);
    int tempoServico = parseInt(tempoServicoStr);

   if (tempoServico > 5){
     bonus = salario * 0.05f;
     novoSalario = salario + bonus;
   } else {
     bonus = salario * 0.013f;
     novoSalario = salario + bonus;
   }

    JOptionPane.showMessageDialog(null, "Seu salário antigo: " + salario +
            "\nValor líquido do bônus: " + bonus +
            "\nValor total do novo salário: " + novoSalario +
            "\nTempo de serviço: " + tempoServico);
  }
}