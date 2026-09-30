/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.Conexao;
import Model.ModelCliente;
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
public class ClienteDAO {

    public List<ModelCliente> listarTodos() {

        List<ModelCliente> clientes = new ArrayList<>();

        String sql = "SELECT CodCliente, Nome, Contato, Observacao "
                + "FROM Cliente "
                + "ORDER BY CodCliente";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql); ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {

                ModelCliente cliente = new ModelCliente();

                cliente.setCodCliente(resultado.getInt("CodCliente"));
                cliente.setNome(resultado.getString("Nome"));
                cliente.setContato(resultado.getString("Contato"));
                cliente.setObservacao(resultado.getString("Observacao"));

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes.");
            e.printStackTrace();
        }

        return clientes;
    }

    public boolean inserir(ModelCliente cliente) {

        String sql = "INSERT INTO Cliente (Nome, Contato, Observacao) "
                + "VALUES (?, ?, ?)";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getContato());
            comando.setString(3, cliente.getObservacao());

            comando.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente.");
            e.printStackTrace();
            return false;
        }
    }

    public ModelCliente buscarPorId(int codCliente) {

        String sql = "SELECT CodCliente, Nome, Contato, Observacao "
                + "FROM Cliente "
                + "WHERE CodCliente = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, codCliente);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {

                    ModelCliente cliente = new ModelCliente();

                    cliente.setCodCliente(resultado.getInt("CodCliente"));
                    cliente.setNome(resultado.getString("Nome"));
                    cliente.setContato(resultado.getString("Contato"));
                    cliente.setObservacao(resultado.getString("Observacao"));

                    return cliente;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente.");
            e.printStackTrace();
        }

        return null;
    }

    public boolean alterar(ModelCliente cliente) {

        String sql = "UPDATE Cliente "
                + "SET Nome = ?, Contato = ?, Observacao = ? "
                + "WHERE CodCliente = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getContato());
            comando.setString(3, cliente.getObservacao());
            comando.setInt(4, cliente.getCodCliente());

            int linhasAfetadas = comando.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao alterar cliente.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int codCliente) {

        String sql = "DELETE FROM Cliente WHERE CodCliente = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, codCliente);

            int linhasAfetadas = comando.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente.");
            e.printStackTrace();
            return false;
        }
    }
}
