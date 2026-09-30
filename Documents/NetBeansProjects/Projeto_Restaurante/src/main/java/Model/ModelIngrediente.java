/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Artur
 */
public class ModelIngrediente {

    private int codIngrediente;
    private String nome;
    private double quantidadeEstoque;

    public ModelIngrediente() {
    }

    public ModelIngrediente(
            int codIngrediente,
            String nome,
            double quantidadeEstoque) {

        this.codIngrediente = codIngrediente;
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public ModelIngrediente(
            String nome,
            double quantidadeEstoque) {

        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getCodIngrediente() {
        return codIngrediente;
    }

    public void setCodIngrediente(int codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
