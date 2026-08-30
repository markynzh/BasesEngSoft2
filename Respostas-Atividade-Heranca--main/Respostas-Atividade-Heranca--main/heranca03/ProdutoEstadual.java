package heranca03;

public class ProdutoEstadual extends Produto{
    //construtor
    public ProdutoEstadual(String descricao, float valor){
        super (descricao, valor);
        this.imposto = 0.1f;
    }

    //metodos
    @Override
    public float valorFinal(){
        return valor + (valor * imposto);
    }
}

