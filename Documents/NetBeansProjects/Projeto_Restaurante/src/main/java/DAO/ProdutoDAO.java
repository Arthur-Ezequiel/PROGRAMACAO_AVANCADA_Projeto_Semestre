/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.Conexao;
import Model.ModelProduto;
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
public class ProdutoDAO {

    public boolean inserir(ModelProduto produto) {

        String sql = """
        INSERT INTO Produto
        (Nome, Descricao, Preco, EmEstoque)
        VALUES (?, ?, ?, ?)
        """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setBoolean(4, produto.isEmEstoque());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ModelProduto> listarTodos() {

        List<ModelProduto> produtos = new ArrayList<>();

        String sql = """
        SELECT CodProduto, Nome, Descricao, Preco, EmEstoque
        FROM Produto
        ORDER BY CodProduto
        """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                ModelProduto produto = new ModelProduto();

                produto.setCodProduto(rs.getInt("CodProduto"));
                produto.setNome(rs.getString("Nome"));
                produto.setDescricao(rs.getString("Descricao"));
                produto.setPreco(rs.getDouble("Preco"));
                produto.setEmEstoque(rs.getBoolean("EmEstoque"));

                produtos.add(produto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    public ModelProduto buscarPorId(int codProduto) {

        String sql = """
        SELECT CodProduto, Nome, Descricao, Preco, EmEstoque
        FROM Produto
        WHERE CodProduto = ?
        """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codProduto);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    ModelProduto produto = new ModelProduto();

                    produto.setCodProduto(rs.getInt("CodProduto"));
                    produto.setNome(rs.getString("Nome"));
                    produto.setDescricao(rs.getString("Descricao"));
                    produto.setPreco(rs.getDouble("Preco"));
                    produto.setEmEstoque(rs.getBoolean("EmEstoque"));

                    return produto;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean alterar(ModelProduto produto) {

        String sql = """
        UPDATE Produto
        SET Nome = ?,
            Descricao = ?,
            Preco = ?,
            EmEstoque = ?
        WHERE CodProduto = ?
        """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setBoolean(4, produto.isEmEstoque());
            stmt.setInt(5, produto.getCodProduto());

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int codProduto) {

        String sql = """
        DELETE FROM Produto
        WHERE CodProduto = ?
        """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codProduto);

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
