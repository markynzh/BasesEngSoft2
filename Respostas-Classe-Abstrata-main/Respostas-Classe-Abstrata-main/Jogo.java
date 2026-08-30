package classeAbstrata;

public abstract class Jogo {
    //atributos
    String nome;
    int numJogadores;

    //construtores
    public Jogo (String nome, int numJogadores){
        this.nome = nome;
        this.numJogadores = numJogadores;
    }

    //métodos abstratos
    public abstract void iniciar ();
    public abstract void exibirRegras();

    //métodos concretos
    public String toString (){
        return "Nome: " + nome + ". Número de jogadores: " + numJogadores + ". ";
    }
}
