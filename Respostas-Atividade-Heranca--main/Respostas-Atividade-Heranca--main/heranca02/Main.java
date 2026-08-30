package heranca02;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Peca p1 = new Peca("Memória RAM", 200, 50);
        System.out.println("PEÇA");
        p1.exibirDados();

        PecaImportada p2 = new PecaImportada("Placa de Vídeo", 1500, 300, 200, 100);

        System.out.println("\nPEÇA IMPORTADA");
        p2.exibirDados();
    }
}
