package classes;

public class Matricula {
    //atributos
    private int estudanteMatricula;
    private int cursoCodigo;
    private String dataMatricula;

    //construtor
    public Matricula(int estudanteMatricula, int cursoCodigo, String dataMatricula) {
        this.estudanteMatricula = estudanteMatricula;
        this.cursoCodigo = cursoCodigo;
        this.dataMatricula = dataMatricula;
    }

    public Matricula() {
    }

    //getters e setters
    public int getEstudanteMatricula() {
        return estudanteMatricula;
    }

    public void setEstudanteMatricula(int estudanteMatricula) {
        this.estudanteMatricula = estudanteMatricula;
    }

    public int getCursoCodigo() {
        return cursoCodigo;
    }

    public void setCursoCodigo(int cursoCodigo) {
        this.cursoCodigo = cursoCodigo;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public void exibirDados() {
        System.out.println("Matrícula do estudante: " + estudanteMatricula);
        System.out.println("Código do curso: " + cursoCodigo);
        System.out.println("Data da matrícula: " + dataMatricula);
    }
}