import javax.swing.*;
import static java.lang.Integer.parseInt;

public class Main {
    static void main(String[] args) {

        String lado1Str = JOptionPane.showInputDialog("Digite o primeiro lado do seu triângulo: ");
        String lado2Str = JOptionPane.showInputDialog("Digite o segundo lado do seu triângulo: ");
        String lado3Str = JOptionPane.showInputDialog("Digite o terceiro lado do seu triângulo: ");

        int lado1 = parseInt(lado1Str);
        int lado2 = parseInt(lado2Str);
        int lado3 = parseInt(lado3Str);

        if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1){
            JOptionPane.showMessageDialog(null, "Os valores formam um triângulo!");
            if (lado1 == lado2 && lado2 == lado3){
                JOptionPane.showMessageDialog(null, "O triângulo é equilátero.");
            } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3){
                JOptionPane.showMessageDialog(null, "O triângulo é isósceles.");
            } else {
                JOptionPane.showMessageDialog(null, "O triangulo é escaleno.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Os valores não formam um triângulo!");
        }

    }
}