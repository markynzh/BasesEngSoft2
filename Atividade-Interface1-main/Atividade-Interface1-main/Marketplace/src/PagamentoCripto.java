public class PagamentoCripto implements Pagamento {
    @Override
    public double valorFinal(double valor){
        return valor += valor * 0.025;
    }
}
