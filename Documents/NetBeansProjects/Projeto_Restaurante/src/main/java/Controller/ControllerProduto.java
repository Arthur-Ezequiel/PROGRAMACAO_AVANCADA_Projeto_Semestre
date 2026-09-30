/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ProdutoDAO;
import Model.ModelProduto;
import java.util.List;

/**
 *
 * @author Artur
 */
public class ControllerProduto {

    private ProdutoDAO produtoDAO;

    public ControllerProduto() {
        produtoDAO = new ProdutoDAO();
    }

    public boolean cadastrar(
            String nome,
            String descricao,
            double preco,
            boolean emEstoque) {

        ModelProduto produto = new ModelProduto(
                nome,
                descricao,
                preco,
                emEstoque
        );

        return produtoDAO.inserir(produto);
    }

    public List<ModelProduto> listarTodos() {
        return produtoDAO.listarTodos();
    }

    public ModelProduto buscarPorId(int codProduto) {
        return produtoDAO.buscarPorId(codProduto);
    }

    public boolean alterar(
            int codProduto,
            String nome,
            String descricao,
            double preco,
            boolean emEstoque) {

        ModelProduto produto = new ModelProduto(
                codProduto,
                nome,
                descricao,
                preco,
                emEstoque
        );

        return produtoDAO.alterar(produto);
    }

    public boolean excluir(int codProduto) {
        return produtoDAO.excluir(codProduto);
    }
}