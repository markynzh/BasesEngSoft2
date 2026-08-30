import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String alturaStr = JOptionPane.showInputDialog("Vamos calcular seu IMC (Índice de Massa Corporal)!\n" +
                "Digite sua altura, em metros");
        String pesoStr = JOptionPane.showInputDialog("Digite o seu peso, em kilogramas");


        float peso = Float.parseFloat(pesoStr);
        float altura = Float.parseFloat(alturaStr);

        float imc = peso / (altura * altura);

        if (imc < 16) {
            JOptionPane.showMessageDialog(null, "Segundo o cálculo do IMC, você foi classificado com magreza grave.");
        } else if (imc >= 16 && imc < 17) {
            JOptionPane.showMessageDialog(null, "Segundo o cálculo do IMC, você foi classificado com magreza moderada.");
        } else if (imc >= 17 && imc < 18.5) {
            JOptionPane.showMessageDialog(null, "Segundo o cálculo do IMC, você foi classificado com magreza leve.");
        } else if (imc >= 18.5 && imc < 25) {
            JOptionPane.showMessageDialog(null, "Segundo o cálculo do IMC, você foi classificado como saudável.");
        } else if (imc >= 25 && imc < 30) {
            JOptionPane.showMessageDialog(null, "Segundo o cálculo do IMC, você foi classificado com sobrepeso.");
        } else if (imc >= 30 && imc < 35) {
            JOptionPane.showMessageDialog(null, "Segundo o cálculo do IMC, você foi classificado com obesidade grau I.");
        } else if (imc >= 35 && imc < 40) {
            JOptionPane.showMessageDialog(null, "Segundo o cálculo do IMC, você foi classificado com obesidade grau II (severa).");
        } else if (imc >= 40) {
            JOptionPane.showMessageDialog(null, "Segundo o cálculo do IMC, você foi classificado com obesidade grau III (mórbida).");
        }
    }
}