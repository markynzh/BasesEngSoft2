package exercicio03;

public class Funcionario {
    //atributos
    private int idFuncionario;
    private String nomeFuncionario;
    private float salarioFuncionario;

    //construtores
    public Funcionario (){}

    public Funcionario (int idFuncionario, String nomeFuncionario, float salarioFuncionario){
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.salarioFuncionario = salarioFuncionario;
    }

    //getters setters
    public int getIdFuncionario(){
        return idFuncionario;
    }

    public String getNomeFuncionario(){
        return nomeFuncionario;
    }

    public String getSalarioFuncionario(){
        return "R$ " + salarioFuncionario;
    }

    public void setIdFuncionario (int idFuncionario){
        this.idFuncionario = idFuncionario;
    }

    public void setNomeFuncionario (String nomeFuncionario){
        this.nomeFuncionario = nomeFuncionario;
    }
}
