package exercicio04;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Circulo circulo1 = new Circulo();

        System.out.println("Digite o raio do círculo: ");
        circulo1.setRaio(sc.nextFloat());

        System.out.println("Digite a base do círculo: ");
        circulo1.base = sc.nextFloat();

        System.out.println("Aproximadamente, a área é de " + circulo1.calcularArea() + ".");
        System.out.println("Aproximadamente, o perímetro é de " + circulo1.calcularPerimetro() + ".");
    }
}
