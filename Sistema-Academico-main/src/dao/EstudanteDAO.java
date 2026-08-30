package dao;

import banco.ConexaoBanco;
import classes.Estudante;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO {
    // CADASTRAR ESTUDANTE
    public boolean cadastrarEstudante(Estudante estudante) {
        String sql = "INSERT INTO estudante (matricula, nome_completo, data_nascimento) VALUES (?, ?, ?)";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, estudante.getMatricula());
            stmt.setString(2, estudante.getNomeCompleto());
            stmt.setDate(3, paraSql(estudante.getDataNascimento()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // CONSULTAR POR MATRÍCULA
    public Estudante buscarMatriculaEstudante(String matricula) {
        String sql = "SELECT * FROM estudante WHERE matricula = ?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, matricula);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Estudante(
                        rs.getInt("matricula"),
                        rs.getString("nome_completo"),
                        paraBr(rs.getDate("data_nascimento"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // CONSULTAR POR NOME
    public List<Estudante> buscarNomeEstudante(String nome) {
        List<Estudante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudante WHERE nome_completo LIKE ?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Estudante estudante = new Estudante(
                        rs.getInt("matricula"),
                        rs.getString("nome_completo"),
                        paraBr(rs.getDate("data_nascimento"))
                );
                lista.add(estudante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // EDITAR ESTUDANTE
    public boolean editarEstudante(Estudante estudante) {
        String sql = "UPDATE estudante SET nome_completo = ?, data_nascimento = ? WHERE matricula = ?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, estudante.getNomeCompleto());
            stmt.setDate(2, paraSql(estudante.getDataNascimento()));
            stmt.setInt(3, estudante.getMatricula());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // EXCLUIR ESTUDANTE
    public boolean excluirEstudante(String matricula) {
        String sql = "DELETE FROM estudante WHERE matricula = ?";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, matricula);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir estudante.");
            e.printStackTrace();
            return false;
        }
    }

    // LISTAR TODOS OS ESTUDANTES
    public List<Estudante> listarEstudantes() {
        List<Estudante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudante ORDER BY nome_completo";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estudante estudante = new Estudante(
                        rs.getInt("matricula"),
                        rs.getString("nome_completo"),
                        paraBr(rs.getDate("data_nascimento"))
                );
                lista.add(estudante);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar estudantes.");
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