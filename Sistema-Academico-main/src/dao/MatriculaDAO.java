package dao;

import banco.ConexaoBanco;
import classes.Curso;
import classes.Estudante;
import classes.Matricula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {
    // MATRICULAR ESTUDANTE EM UM CURSO
    public boolean matricularEstudante(Matricula matricula) {

        String sql = "INSERT INTO matricula (estudante_matricula, curso_codigo, data_matricula) VALUES (?, ?, ?)";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, matricula.getEstudanteMatricula());
            stmt.setInt(2, matricula.getCursoCodigo());
            stmt.setDate(3, Date.valueOf(matricula.getDataMatricula()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao matricular estudante.");
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Data inválida. Utilize o formato yyyy-MM-dd.");
            return false;
        }
    }

    // REMOVER MATRÍCULA
    public boolean removerMatricula(int matriculaEstudante, int codigoCurso) {

        String sql = "DELETE FROM matricula WHERE estudante_matricula = ? AND curso_codigo = ?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, matriculaEstudante);
            stmt.setInt(2, codigoCurso);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao remover matrícula.");
            e.printStackTrace();
            return false;
        }
    }

    // LISTAR CURSOS DE UM ESTUDANTE
    public List<Curso> listarCursosDoEstudante(int matriculaEstudante) {

        List<Curso> lista = new ArrayList<>();

        String sql = "SELECT c.* " +
                "FROM curso c " +
                "INNER JOIN matricula m ON c.codigo = m.curso_codigo " +
                "WHERE m.estudante_matricula = ?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, matriculaEstudante);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Curso curso = new Curso(
                        rs.getInt("codigo"),
                        rs.getString("nome_curso"),
                        rs.getInt("carga_horaria"),
                        (Integer) rs.getObject("professor_responsavel")
                );

                lista.add(curso);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar cursos do estudante.");
            e.printStackTrace();
        }

        return lista;
    }

    // LISTAR TODAS AS VINCULAÇÕES (CURSO + ALUNO + PROFESSOR) PARA A TELA
    public List<Object[]> listarVinculacoes() {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT c.nome_curso, e.nome_completo AS aluno, p.nome_completo AS professor " +
                "FROM matricula m " +
                "INNER JOIN curso c ON c.codigo = m.curso_codigo " +
                "INNER JOIN estudante e ON e.matricula = m.estudante_matricula " +
                "LEFT JOIN professor p ON p.matricula = c.professor_responsavel " +
                "ORDER BY c.nome_curso, e.nome_completo";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                lista.add(new Object[]{
                        rs.getString("nome_curso"),
                        rs.getString("aluno"),
                        rs.getString("professor") == null ? "-" : rs.getString("professor")
                });
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar vinculações.");
            e.printStackTrace();
        }

        return lista;
    }

    // LISTAR ESTUDANTES MATRICULADOS EM UM CURSO
    public List<Estudante> listarEstudantesDoCurso(int codigoCurso) {

        List<Estudante> lista = new ArrayList<>();

        String sql = "SELECT e.* " +
                "FROM estudante e " +
                "INNER JOIN matricula m ON e.matricula = m.estudante_matricula " +
                "WHERE m.curso_codigo = ?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, codigoCurso);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Estudante estudante = new Estudante(
                        rs.getInt("matricula"),
                        rs.getString("nome_completo"),
                        rs.getString("data_nascimento")
                );

                lista.add(estudante);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar estudantes do curso.");
            e.printStackTrace();
        }

        return lista;
    }
}