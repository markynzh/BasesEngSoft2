import javax.swing.*;

public class Main {
    public static void main (String[] args){
        String num1_Str = JOptionPane.showInputDialog("Digite um primeiro número: ");
        String num2_Str = JOptionPane.showInputDialog("Digite um segundo número: ");
        String escolha_Str = JOptionPane.showInputDialog("Qual operação você deseja fazer? \n" +
                "Digite 1 para adição\n" +
                "Digite 2 para subtração\n" +
                "Digite 3 para multiplicação\n" +
                "Digite 4 para divisão");

        float num1 = Float.parseFloat(num1_Str);
        float num2 = Float.parseFloat(num2_Str);
        int escolha = Integer.parseInt(escolha_Str);
        float resultado = 0;
        String operacao = null;

        if (escolha == 1){
             resultado = num1 + num2;
             operacao = "adição";
            JOptionPane.showMessageDialog(null, "O resultado da sua operação de " + operacao + " foi de " +  resultado + ".");
        } else if (escolha == 2) {
             resultado = num1 - num2;
             operacao = "subtração";
            JOptionPane.showMessageDialog(null, "O resultado da sua operação de " + operacao + " foi de " +  resultado + ".");
        } else if (escolha == 3) {
             resultado = num1 * num2;
            operacao = "multiplicação";
            JOptionPane.showMessageDialog(null, "O resultado da sua operação de " + operacao + " foi de " +  resultado + ".");
        } else if (escolha == 4) {
            resultado = num1 / num2;
            operacao = "divisão";
            JOptionPane.showMessageDialog(null, "O resultado da sua operação de " + operacao + " foi de " +  resultado + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma operação foi encontrada, tente novamente.");
        }


    }
}