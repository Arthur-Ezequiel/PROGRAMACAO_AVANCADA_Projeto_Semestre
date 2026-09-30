/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Artur
 */
public class ModelCliente {

    private int codCliente;
    private String nome;
    private String contato;
    private String observacao;

    public ModelCliente() {
    }

    public ModelCliente(int codCliente, String nome, String contato, String observacao) {
        this.codCliente = codCliente;
        this.nome = nome;
        this.contato = contato;
        this.observacao = observacao;
    }

    public ModelCliente(String nome, String contato, String observacao) {
        this.nome = nome;
        this.contato = contato;
        this.observacao = observacao;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Código: " + codCliente
                + " | Nome: " + nome
                + " | Contato: " + contato
                + " | Observação: " + observacao;
    }
}
