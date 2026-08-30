package classes;

public class Professor extends Pessoa {
    //atributos
    private String especialidade;

    //construtores
    public Professor (int matricula, String nomeCompleto, String dataNascimento, String especialidade){
        super (matricula, nomeCompleto, dataNascimento);
        this.especialidade = especialidade;
    }

    public Professor (){}

    //métodos getters
    @Override
    public int getMatricula(){
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

    public String getEspecialidade(){
        return especialidade;
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

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    //metodos de comportamento
    @Override
    public void exibirDados() {
        System.out.println("Nome: " + getNomeCompleto() +
                "Data de nascimento: " + getDataNascimento() +
                "Matrícula: " + getMatricula() +
                "Especialidade: " + getEspecialidade());
    }
}
