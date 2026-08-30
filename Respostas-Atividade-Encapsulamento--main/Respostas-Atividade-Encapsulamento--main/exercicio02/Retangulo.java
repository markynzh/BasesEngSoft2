package exercicio02;
import java.util.Scanner;

public class Retangulo {
    Scanner sc = new Scanner (System.in);

    //atributos
    private float comprimento;
    private float largura;

    //construtores
    public Retangulo() {}

    public Retangulo (float comprimento, float largura){
        this.comprimento = comprimento;
        this.largura = largura;
    }

    //setters e getters
    public float getComprimento(){
        return comprimento;
    }

    public float getLargura(){
        return largura;
    }

    public void setComprimento(float comprimento){
        this.comprimento = comprimento;
    }

    public void setLargura(float largura){
        this.largura = largura;
    }

}
