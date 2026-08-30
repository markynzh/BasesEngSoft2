package classeAbstrata;
import java.util.Random;

public class JogoCartas extends Jogo {
    //atributos
    private final int totalCartas = 52;

    //construtor
    public JogoCartas (String nome, int numJogadores){
        super(nome, numJogadores);
    }

    //métodos abstratos
    @Override
    public void iniciar() {
        if (numJogadores > 4 || numJogadores < 2) {
            System.out.println("Opção inválida de jogadores.");
            System.out.println("O jogo precisa ter de 2 a 4 jogadores.");
            return;
        }
        System.out.println("\nINICIANDO O JOGO: " + nome);

        int qntdCartasJogador = totalCartas / numJogadores;
        int restoCartas = totalCartas % numJogadores;

        for (int i=1; i <= numJogadores ; i++){
            System.out.println("O jogador " + i + " recebeu " + qntdCartasJogador + " cartas.");
        }

        System.out.println("\nCarta(s) restante(s) no baralho: " + restoCartas + ".");

        Random random = new Random();
        int vencedor = random.nextInt(numJogadores);
        System.out.println("\nO vencedor da rodada foi o jogador " + vencedor + ".");
    }

    @Override
    public void exibirRegras(){
        System.out.println("REGRAS JOGO DE CARTAS");
        System.out.println("Mínimo de jogadores: 2 | Máximo de jogadores: 4");
        System.out.println("As cartas são distribuídas de forma igualitária.");
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
