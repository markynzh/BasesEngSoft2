package classes;

public class Estudante extends Pessoa {
    //atributos/construtor
    public Estudante (int matricula, String nomeCompleto, String dataNascimento){
        super(matricula, nomeCompleto, dataNascimento);
    }

    public Estudante (){}

    //metodos getters
    @Override
    public int getMatricula() {
        return super.getMatricula();
    }

    @Override
    public String getNomeCompleto() {
        return super.getNomeCompleto();
    }

    @Override
    public String getDataNascimento() {
        return super.getDataNascimento();
    }

    //metodos setters
    @Override
    public void setMatricula(int matricula) {
        super.setMatricula(matricula);
    }

    @Override
    public void setNomeCompleto(String nomeCompleto) {
        super.setNomeCompleto(nomeCompleto);
    }

    @Override
    public void setDataNascimento(String dataNascimento) {
        super.setDataNascimento(dataNascimento);
    }

    //metodos de comportamento
    @Override
    public void exibirDados() {
        System.out.println("Nome: " + getNomeCompleto() +
                "Data de nascimento: " + getDataNascimento() +
                "Matrícula: " + getMatricula());
    }
}
