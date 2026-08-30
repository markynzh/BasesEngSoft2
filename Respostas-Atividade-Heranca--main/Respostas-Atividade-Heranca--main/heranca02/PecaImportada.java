package heranca02;

public class PecaImportada extends Peca{
    //atributos
    private float taxaImportacao;
    private float taxaFrete;

    //construtor
    public PecaImportada(){}

    public PecaImportada(String nome, float custo, float lucro, float taxaImportacao, float taxaFrete){
        super (nome, custo, lucro);
        this.taxaImportacao = taxaImportacao;
        this.taxaFrete = taxaFrete;
    }

    //getters e setters
    public float getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(float taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    public float getTaxaImportacao() {
        return taxaImportacao;
    }

    public void setTaxaImportacao(float taxaImportacao) {
        this.taxaImportacao = taxaImportacao;
    }

    //métodos
    @Override
    public float calcularPreco (){
        return super.calcularPreco() + taxaFrete + taxaImportacao;
    }

    public void exibirDados (){
        System.out.println("Nome: "+getNome());
        System.out.println("Custo: "+getCusto());
        System.out.println("Lucro: "+getLucro());
        System.out.println("Preço: "+calcularPreco());
    }
}
