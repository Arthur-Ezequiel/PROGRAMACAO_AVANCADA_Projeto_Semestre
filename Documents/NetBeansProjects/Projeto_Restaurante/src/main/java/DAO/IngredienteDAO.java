/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.Conexao;
import Model.ModelIngrediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Artur
 */
public class IngredienteDAO {

    public boolean inserir(ModelIngrediente ingrediente) {

        String sql = """
        INSERT INTO Ingrediente
        (Nome, qtestoque)
        VALUES (?, ?)
        """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, ingrediente.getNome());
            stmt.setDouble(2, ingrediente.getQuantidadeEstoque());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ModelIngrediente> listarTodos() {

        List<ModelIngrediente> ingredientes = new ArrayList<>();

        String sql = """
        SELECT CodIngrediente, Nome, qtestoque
        FROM Ingrediente
        ORDER BY CodIngrediente
        """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                ModelIngrediente ingrediente
                        = new ModelIngrediente();

                ingrediente.setCodIngrediente(
                        rs.getInt("CodIngrediente"));

                ingrediente.setNome(
                        rs.getString("Nome"));

                ingrediente.setQuantidadeEstoque(
                        rs.getDouble("qtestoque"));

                ingredientes.add(ingrediente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ingredientes;
    }

    public ModelIngrediente buscarPorId(int codIngrediente) {

        String sql = """
        SELECT CodIngrediente, Nome, qtestoque
        FROM Ingrediente
        WHERE CodIngrediente = ?
        """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codIngrediente);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    ModelIngrediente ingrediente
                            = new ModelIngrediente();

                    ingrediente.setCodIngrediente(
                            rs.getInt("CodIngrediente"));

                    ingrediente.setNome(
                            rs.getString("Nome"));

                    ingrediente.setQuantidadeEstoque(
                            rs.getDouble("qtestoque"));

                    return ingrediente;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean alterar(ModelIngrediente ingrediente) {

        String sql = """
        UPDATE Ingrediente
        SET Nome = ?,
            qtestoque = ?
        WHERE CodIngrediente = ?
        """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, ingrediente.getNome());
            stmt.setDouble(2, ingrediente.getQuantidadeEstoque());
            stmt.setInt(3, ingrediente.getCodIngrediente());

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int codIngrediente) {

        String sql = """
        DELETE FROM Ingrediente
        WHERE CodIngrediente = ?
        """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codIngrediente);

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
