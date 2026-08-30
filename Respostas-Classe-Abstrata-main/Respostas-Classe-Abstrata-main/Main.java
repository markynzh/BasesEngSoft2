package classeAbstrata;

public class Main {
    static void main(String[] args) {
        Jogo uno = new JogoCartas("UNO", 3);
        uno.toString();
        uno.exibirRegras();
        uno.iniciar();

        Jogo bancoImobiliario = new JogoTabuleiro("Banco imobiliário", 4);
        bancoImobiliario.toString();
        bancoImobiliario.exibirRegras();
        bancoImobiliario.iniciar();

    }
}
