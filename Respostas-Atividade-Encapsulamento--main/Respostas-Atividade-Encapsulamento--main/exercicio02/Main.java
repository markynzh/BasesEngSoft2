package exercicio02;

import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        Retangulo retangulo1 = new Retangulo();

        System.out.println("Digite o comprimento do retângulo: ");
        retangulo1.setComprimento(sc.nextFloat());

        System.out.println("Digite a largura do retângulo: ");
        retangulo1.setLargura(sc.nextFloat());

        System.out.println("O comprimento do retângulo é: " + retangulo1.getComprimento());
        System.out.println("A largura do retângulo é: " + retangulo1.getLargura());

    }
}
