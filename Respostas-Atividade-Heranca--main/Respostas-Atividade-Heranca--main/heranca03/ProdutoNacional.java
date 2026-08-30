package heranca03;

public class ProdutoNacional extends Produto {
    //atributos
    protected float taxa;

    //construtor
    public ProdutoNacional(String descricao, float valor){
        super (descricao, valor);
        this.imposto = 0.1f;
        this.taxa = 0.05f;
    }

    //metodos
    @Override
    public float valorFinal(){
        return valor + (valor * imposto) + (valor * taxa);
    }
}
