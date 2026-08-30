public class PagamentoBoleto implements Pagamento {
    @Override
    public double valorFinal(double valor){
        return valor + 5;
    }
}