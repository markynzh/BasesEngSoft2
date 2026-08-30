package classes;

public abstract class Pessoa {
    //atributos
    private int matricula;
    private String nomeCompleto, dataNascimento;

    //construtor
    public Pessoa (int matricula, String nomeCompleto, String dataNascimento){
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa (){}

    //metodos getters
    public int getMatricula(){
        return matricula;
    }

    public String getNomeCompleto(){
        return nomeCompleto;
    }

    public String getDataNascimento(){
        return dataNascimento;
    }

    //metodos setters
    public void setMatricula (int matricula){
        this.matricula = matricula;
    }

    public void setNomeCompleto (String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }

    public void setDataNascimento (String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    //metodos comportamento
    public abstract void exibirDados();
}

