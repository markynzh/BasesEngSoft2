package dao;

import banco.ConexaoBanco;
import classes.Professor;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    public boolean cadastrarProfessor(Professor professor) {

        String sql = "INSERT INTO professor (matricula, nome_completo, data_nascimento, especialidade) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, professor.getMatricula());
            stmt.setString(2, professor.getNomeCompleto());
            stmt.setDate(3, paraSql(professor.getDataNascimento()));
            stmt.setString(4, professor.getEspecialidade());


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar professor.");
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Data de nascimento inválida. Utilize o formato dd/MM/aaaa.");
            return false;
        }
    }

    // CONSULTAR POR MATRÍCULA
    public Professor buscarMatriculaProfessor(Integer matricula) {

        if (matricula == null) {
            return null;
        }

        String sql = "SELECT * FROM professor WHERE matricula = ?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, matricula);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Professor(
                        rs.getInt("matricula"),
                        rs.getString("nome_completo"),
                        paraBr(rs.getDate("data_nascimento")),
                        rs.getString("especialidade")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // CONSULTAR POR NOME
    public List<Professor> buscarNomeProfessor(String nome) {

        List<Professor> lista = new ArrayList<>();

        String sql = "SELECT * FROM professor WHERE nome_completo LIKE ?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Professor professor = new Professor(
                        rs.getInt("matricula"),
                        rs.getString("nome_completo"),
                        paraBr(rs.getDate("data_nascimento")),
                        rs.getString("especialidade")
                );

                lista.add(professor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // EDITAR PROFESSOR
    public boolean editarProfessor(Professor professor) {

        String sql = "UPDATE professor SET nome_completo = ?, data_nascimento = ?, especialidade = ? WHERE matricula = ?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, professor.getNomeCompleto());
            stmt.setDate(2, paraSql(professor.getDataNascimento()));
            stmt.setString(3, professor.getEspecialidade());
            stmt.setInt(4, professor.getMatricula());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar professor.");
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Data de nascimento inválida. Utilize o formato dd/MM/aaaa.");
            return false;
        }
    }

    // EXCLUIR PROFESSOR
    public boolean excluirProfessor(String matricula) {

        String sql = "DELETE FROM professor WHERE matricula = ?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, matricula);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir professor.");
            e.printStackTrace();
            return false;
        }
    }

    // LISTAR TODOS OS PROFESSORES
    public List<Professor> listarProfessores() {

        List<Professor> lista = new ArrayList<>();

        String sql = "SELECT * FROM professor ORDER BY nome_completo";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Professor professor = new Professor(
                        rs.getInt("matricula"),
                        rs.getString("nome_completo"),
                        paraBr(rs.getDate("data_nascimento")),
                        rs.getString("especialidade")
                );

                lista.add(professor);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar professores.");
            e.printStackTrace();
        }

        return lista;
    }

    // Converte "dd/MM/yyyy" (formato da tela) para java.sql.Date (formato do banco)
    private Date paraSql(String dataBr) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate data = LocalDate.parse(dataBr.trim(), formato);

        return Date.valueOf(data);
    }

    // Converte java.sql.Date (formato do banco) para "dd/MM/yyyy" (formato da tela)
    private String paraBr(Date dataSql) {

        if (dataSql == null) {
            return "";
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return dataSql.toLocalDate().format(formato);
    }
}