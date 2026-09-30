/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.IngredienteDAO;
import Model.ModelIngrediente;
import java.util.List;

/**
 *
 * @author Artur
 */
public class ControllerIngrediente {

    private IngredienteDAO ingredienteDAO;

    public ControllerIngrediente() {
        ingredienteDAO = new IngredienteDAO();
    }

    public boolean cadastrar(
            String nome,
            double quantidadeEstoque) {

        ModelIngrediente ingrediente = new ModelIngrediente(
                nome,
                quantidadeEstoque
        );

        return ingredienteDAO.inserir(ingrediente);
    }

    public List<ModelIngrediente> listarTodos() {
        return ingredienteDAO.listarTodos();
    }

    public ModelIngrediente buscarPorId(int codIngrediente) {
        return ingredienteDAO.buscarPorId(codIngrediente);
    }

    public boolean alterar(
            int codIngrediente,
            String nome,
            double quantidadeEstoque) {

        ModelIngrediente ingrediente = new ModelIngrediente(
                codIngrediente,
                nome,
                quantidadeEstoque
        );

        return ingredienteDAO.alterar(ingrediente);
    }

    public boolean excluir(int codIngrediente) {
        return ingredienteDAO.excluir(codIngrediente);
    }
}
