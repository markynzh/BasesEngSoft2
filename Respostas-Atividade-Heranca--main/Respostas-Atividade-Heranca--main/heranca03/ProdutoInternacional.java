package heranca03;

public class ProdutoInternacional extends Produto{
    //atributos
    protected float taxa;
    protected float taxaImportacao;

    //construtor
    public ProdutoInternacional(String descricao, float valor){
        super (descricao, valor);
        this.imposto = 0.1f;
        this.taxa = 0.05f;
        this.taxaImportacao = 0.05f;
    }

    //metodos
    @Override
    public float valorFinal (){
        return valor + (valor * imposto) + (valor * taxa) + (valor * taxaImportacao);
    }
}
