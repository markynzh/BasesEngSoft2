package classeAbstrata;
import java.util.Random;

public class JogoTabuleiro extends Jogo{
    //atributos
    private final int tamTabuleiro = 30;

    //construtores
    public JogoTabuleiro (String nome, int numJogadores){
        super (nome, numJogadores);
    }

    //métodos
    @Override
    public void iniciar(){
        if (numJogadores > 4 || numJogadores < 2) {
            System.out.println("Opção inválida de jogadores.");
            System.out.println("O jogo precisa ter de 2 a 4 jogadores.");
            return;
        }

        Random random = new Random();
        int [] posicoes = new int[numJogadores];
        int rodadas = 0;
        boolean jogoFinalizado = false;

        System.out.println("\nINICIANDO O JOGO: " + nome);

        while (!jogoFinalizado){
            rodadas ++;
            System.out.println("\nRodada "+ rodadas);

            for (int i = 0; i < numJogadores; i++){
                int dado = random.nextInt(6) + 1;
                posicoes[i] += dado;

                System.out.println("O jogador " + (i+1) + " tirou " + dado + " e avançou para a casa " + posicoes[i]);

                if (posicoes[i] >= tamTabuleiro){
                    System.out.println("\nO jogador " + (i + 1) + " venceu a partida!");
                    jogoFinalizado = true;
                    break;
                }
            }
        }

        System.out.println("\nPARTIDA FINALIZADA");
        System.out.println("Foram jogadas " + rodadas + " rodadas.");
    }

    @Override
    public void exibirRegras(){
        System.out.println("\n\nREGRAS JOGO DE TABULEIRO");
        System.out.println("Mínimo de jogadores: 2 | Máximo de jogadores: 4");
        System.out.println("Cada jogador lança um dado por rodada.");
        System.out.println("Quem chegar ao final do tabuleiro primeiro vence.");


    }

    @Override
    public String toString(){
        return super.toString();
    }
}
