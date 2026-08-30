package heranca03;

public class Main {
    static void main(String[] args) {
        ProdutoEstadual p1 = new ProdutoEstadual("Caderno", 100);

        ProdutoNacional p2 = new ProdutoNacional("Notebook", 2000);

        ProdutoInternacional p3 = new ProdutoInternacional("iPhone", 5000);

        System.out.println("PRODUTO ESTADUAL");
        p1.exibirDados();

        System.out.println("\nPRODUTO NACIONAL");
        p2.exibirDados();

        System.out.println("\nPRODUTO IMPORTADO");
        p3.exibirDados();
    }
}
