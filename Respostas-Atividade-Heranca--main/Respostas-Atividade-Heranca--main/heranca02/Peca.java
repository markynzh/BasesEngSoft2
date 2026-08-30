package heranca02;

public class Peca {
    //atributos
    private String nome;
    private float custo;
    private float lucro;

    //construtor
    public Peca(){}

    public Peca (String nome, float custo, float lucro){
        this.nome = nome;
        this.custo = custo;
        this.lucro = lucro;
    }

    //getters e setters
    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public float getLucro() {
        return lucro;
    }

    public void setLucro(float lucro) {
        this.lucro = lucro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //métodos
    public float calcularPreco(){
        return custo + lucro;
    }

    public void exibirDados(){
        System.out.println("Nome: "+nome);
        System.out.println("Custo: "+custo);
        System.out.println("Nome: "+lucro);
        System.out.println("Preço: "+calcularPreco());
    }
}
