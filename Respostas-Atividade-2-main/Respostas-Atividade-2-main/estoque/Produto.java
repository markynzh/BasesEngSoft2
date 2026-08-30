package estoque;

public class Produto {
    //atributos da classe produto
    String nome;
    double preco;
    int qntdEstoque;

    //metodo exibir resultados
    public void exibirDados(){
        System.out.println("Nome do produto: " + nome);
        System.out.println("Preço do produto: " + preco);
        System.out.println("Quantidade no estoque: " + qntdEstoque);
        System.out.println("Valor total do estoque: " + calcularValorTotal());
    }

    //metodo calcular valor (tipo return)
    public double calcularValorTotal(){
        return preco * qntdEstoque;
    }

    //metodos adicionar e remover estoque
    public void adicionarEstoque(int qntdAdicionada){
        qntdEstoque += qntdAdicionada;
    }

    public void removerEstoque(int qntdRemovida){
        if (qntdRemovida > qntdEstoque){
            System.out.println("Ação invalidada, estoque indisponível!");
        } else {
            qntdEstoque -= qntdRemovida;
        }
    }

}
