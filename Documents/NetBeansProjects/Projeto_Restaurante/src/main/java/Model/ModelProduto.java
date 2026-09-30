/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Artur
 */
public class ModelProduto {

    private int codProduto;
    private String nome;
    private String descricao;
    private double preco;
    private boolean emEstoque;
    
    

    public ModelProduto() {
    }

    public ModelProduto(int codProduto, String nome, String descricao,
            double preco, boolean emEstoque) {

        this.codProduto = codProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.emEstoque = emEstoque;
    }

    public ModelProduto(String nome, String descricao,
            double preco, boolean emEstoque) {

        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.emEstoque = emEstoque;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isEmEstoque() {
        return emEstoque;
    }

    public void setEmEstoque(boolean emEstoque) {
        this.emEstoque = emEstoque;
    }
}
