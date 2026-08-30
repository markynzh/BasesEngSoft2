package exercicio04;

public class Circulo {
    //atributos
    private float raio;
    public float base;

    public Circulo(){}

    public Circulo(float raio, float base) {
        this.raio = raio;
        this.base = base;
    }

    //getters e setters
    public float getRaio(){
        return raio;
    }

    public void setRaio(float raio){
        this.raio = raio;
    }

    //metodos de comportamento
    public float calcularArea(){
        return 3 * (raio * raio);
    }

    public float calcularPerimetro(){
        return 2 * 3 * raio;
    }
}
