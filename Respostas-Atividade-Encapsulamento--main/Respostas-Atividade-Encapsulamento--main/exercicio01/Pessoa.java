package exercicio01;
import java.util.Scanner;

public class Pessoa{
    // scanner
    Scanner sc = new Scanner(System.in);

    //atributos
    private String nome;
    private int idade;
    private String pais;

    //construtor
    public Pessoa(String nome, int idade, String pais){
        this.nome = nome;
        this.idade = idade;
        this.pais = pais;
    }

    public Pessoa(){};

    //getters (puxar nome) e setters (settar alguma variavel em tal valor)
    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getPais(){
        return pais;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade (int idade){
        if (idade <= 0){
            System.out.println("Idade inválida, digite a idade novamente: ");
            setIdade(sc.nextInt());
        } else {
            this.idade = idade;
        }
    }

    public void setPais (String pais){
        this.pais = pais;
    }

    //métodos de comportamento
    public void exibirDados (){
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("País: " + getPais());
    }

}