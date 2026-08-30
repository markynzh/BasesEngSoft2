package heranca03;

public class Produto {
    //atributos
    protected String descricao;
    protected float valor;
    protected float imposto;

    //construtores
    public Produto (String descricao, float valor){
        this.descricao = descricao;
        this.valor = valor;
    }

    //metodo
    public float valorFinal(){
        return valor + (valor * imposto);
    }

    public void exibirDados (){
        System.out.println("Descrição: "+ descricao);
        System.out.println("Valor inicial: "+ valor);
        System.out.println("Valor final: "+ valorFinal());
    }
}
