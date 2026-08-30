package classes;

public class Curso {
    //atributos
    private int codigo;
    private String nomeCurso;
    private int cargaHoraria;
    private int profResponsavel;

    // construtores
    public Curso (int codigo, String nomeCurso, int cargaHoraria, Integer profResponsavel) {
        this.codigo = codigo;
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.profResponsavel = profResponsavel == null ? 0 : profResponsavel;
    }

    public Curso(){}

    //métodos
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getProfResponsavel() {
        return profResponsavel;
    }

    public void setProfResponsavel(int profResponsavel) {
        this.profResponsavel = profResponsavel;
    }

    public void exibirDados(){
        System.out.println("Código: " + getCodigo() +
                "Nome do curso: " + getNomeCurso() +
                "Carga horária: " + getCargaHoraria() +
                "Professor responsável: " + getProfResponsavel());
    }
}