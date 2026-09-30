/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ClienteDAO;
import Model.ModelCliente;
import java.util.List;

/**
 *
 * @author Artur
 */
public class ControllerCliente {

    private ClienteDAO clienteDAO;

    public ControllerCliente() {
        clienteDAO = new ClienteDAO();
    }

    public boolean cadastrar(String nome, String contato, String observacao) {

        ModelCliente cliente = new ModelCliente(
                nome,
                contato,
                observacao
        );

        return clienteDAO.inserir(cliente);
    }

    public List<ModelCliente> listarTodos() {
        return clienteDAO.listarTodos();
    }

    public ModelCliente buscarPorId(int codCliente) {
        return clienteDAO.buscarPorId(codCliente);
    }

    public boolean alterar(int codCliente, String nome, String contato, String observacao) {

        ModelCliente cliente = new ModelCliente(
                codCliente,
                nome,
                contato,
                observacao
        );

        return clienteDAO.alterar(cliente);
    }

    public boolean excluir(int codCliente) {
        return clienteDAO.excluir(codCliente);
    }
}
