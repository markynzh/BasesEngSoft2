package maiorTriangulo;

public class Triangulos {
    double lado1, lado2, lado3;

    public double calcularAreaTotal(){
        double p = (lado1+lado2+lado3)/2.0;
        return Math.sqrt(p*(p-lado1)*(p-lado2)*(p-lado3));
    }
}
