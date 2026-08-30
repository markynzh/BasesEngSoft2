package dao;

import banco.ConexaoBanco;
import classes.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    //CADASTRAR CURSO
    public boolean cadastrarCurso(Curso curso) {
        String sql = "INSERT INTO curso(nome_curso, carga_horaria, professor_responsavel) VALUES (?, ?, ?)";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, curso.getNomeCurso());
            stmt.setInt(2, curso.getCargaHoraria());

            if (curso.getProfResponsavel() > 0) {
                stmt.setInt(3, curso.getProfResponsavel());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //CONSULTAR CURSO PELO CODIGO
    public Curso buscarCodigoCurso(int codigo) {
        String sql = "SELECT * FROM curso WHERE codigo = ?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, codigo);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Curso(
                        rs.getInt("codigo"),
                        rs.getString("nome_curso"),
                        rs.getInt("carga_horaria"),
                        (Integer) rs.getObject("professor_responsavel")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //EDITAR CURSO
    public boolean editarCurso(Curso curso) {
        String sql = "UPDATE curso SET nome_curso=?, carga_horaria=?, professor_responsavel=? WHERE codigo=?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, curso.getNomeCurso());
            stmt.setInt(2, curso.getCargaHoraria());

            if (curso.getProfResponsavel() > 0) {
                stmt.setInt(3, curso.getProfResponsavel());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }

            stmt.setInt(4, curso.getCodigo());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //EXCLUIR CURSO
    public boolean excluirCurso(int codigo) {
        String sql = "DELETE FROM curso WHERE codigo=?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, codigo);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //LISTAR CURSOS
    public List<Curso> listarCursos() {

        List<Curso> lista = new ArrayList<>();

        String sql = "SELECT * FROM curso ORDER BY nome_curso";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

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
            e.printStackTrace();
        }

        return lista;
    }

    //ASSOCIAR PROFESSOR A UM CURSO
    public boolean associarProfessor(int codigoCurso, int matriculaProfessor) {
        String sql = "UPDATE curso SET professor_responsavel=? WHERE codigo=?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, matriculaProfessor);
            stmt.setInt(2, codigoCurso);

            stmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}