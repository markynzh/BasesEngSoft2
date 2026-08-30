package maiorTriangulo;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        Triangulos trianguloA = new Triangulos();
        Triangulos trianguloB = new Triangulos();

        System.out.println("Digite o lado 1 do primeiro triângulo: ");
        trianguloA.lado1 = scan.nextDouble();
        System.out.println("Digite o lado 2 do primeiro triângulo: ");
        trianguloA.lado2 = scan.nextDouble();
        System.out.println("Digite o lado 3 do primeiro triângulo: ");
        trianguloA.lado3 = scan.nextDouble();

        System.out.println("Digite o lado 1 do segundo triângulo: ");
        trianguloB.lado1 = scan.nextDouble();
        System.out.println("Digite o lado 2 do segundo triângulo: ");
        trianguloB.lado2 = scan.nextDouble();
        System.out.println("Digite o lado 3 do segundo triângulo: ");
        trianguloB.lado3 = scan.nextDouble();

        trianguloA.calcularAreaTotal();
        trianguloB.calcularAreaTotal();

        if (trianguloA.calcularAreaTotal() > trianguloB.calcularAreaTotal()){
            System.out.printf("\nA área do primeiro triângulo é maior, com uma área de %.2f", trianguloA.calcularAreaTotal());
        } else if (trianguloA.calcularAreaTotal() < trianguloB.calcularAreaTotal()) {
            System.out.printf("\nA área do segundo triângulo é maior, com uma área de %.2f", trianguloB.calcularAreaTotal());
        } else {
            System.out.printf("\nA área dos triângulos são iguais, com uma área de %.2f", trianguloA.calcularAreaTotal());
        }

    }
}
