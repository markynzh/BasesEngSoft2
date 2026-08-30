import javax.swing.*;

public class Main {
    public static void main (String[] args){
        JOptionPane.showMessageDialog(null,"Bem vindo ao restaurante!\n" +
                "Caso deseje ver o nosso menu, clique em OK.");
        String menuStr = JOptionPane.showInputDialog("Aqui está o nosso menu, para ver mais detalhes, digite: \n" +
                "1 para PIZZAS\n" +
                "2 para HAMBÚRGUERES\n" +
                "3 para SALADAS\n" +
                "4 para BEBIDAS\n" +
                "0 para SAIR DO MENU.");

        int menu = Integer.parseInt(menuStr);

        if (menu == 1) {
            JOptionPane.showMessageDialog(null, "PIZZAS (servem 1 pessoa):\n"
                    + "Mussarela - Queijo mussarela e molho de tomate - (R$ 30)\n"
                    + "Calabresa - Calabresa, cebola, queijo mussarela e molho de tomate - (R$ 35)\n"
                    + "Frango com Catupiry - Frango, bacon, catupiry, queijo mussarela, molho de tomate - (R$ 38)\n"
                    + "Portuguesa - Presunto, calabresa, ovo, pimentão verde, cebola, queijo mussarela, molho de tomate - (R$ 40)");

        } else if (menu == 2){
            JOptionPane.showMessageDialog(null, "HAMBÚRGUERES (servem 1 pessoa):\n"
                            + "Clássico - Pão brioche, carne, queijo e salada - (R$ 25)\n"
                            + "Bacon - Pão brioche, carne, queijo, bacon e maionese verde - (R$ 28)\n"
                            + "Duplo - Pão australiano, duas carnes, queijo e salada - (R$ 32)");
        } else if (menu == 3){
            JOptionPane.showMessageDialog(null ,"SALADAS (servem 1 pessoa):\n"
                    + "Simples - Folhas e legumes - (R$ 15)\n"
                    + "Caesar - Frango, alface e molho Caesar - (R$ 20)");
        }else if (menu == 4){
            JOptionPane.showMessageDialog(null,"BEBIDAS:\n"
                    + "Refrigerante - Coca-Cola, guaraná, sprite, fantas - (R$ 8)\n"
                    + "Suco Natural - Laranja, maracujá, limão, acerola, abacaxi com hortelã, (R$ 10)\n"
                    + "Água - Mineral ou com gás - (R$ 5)");
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida!");

        }
    }
}