/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author saulo-silva
 */
public class Produto {
    
    double valor_Custo;
    String descricao;
    
    // Composição!
    Fornecedor fornecedor = new Fornecedor();

    public Produto(double valor_Custo, String descricao, Fornecedor _fornecedor) {
        this.valor_Custo = valor_Custo;
        this.descricao = descricao;
        this.fornecedor = _fornecedor;
    }

    public double getValor_Custo() {
        return valor_Custo;
    }

    public void setValor_Custo(double valor_Custo) {
        this.valor_Custo = valor_Custo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "valor_Custo=" + valor_Custo + ", descricao=" + descricao + ", fornecedor=" + fornecedor;
    }
       
}
