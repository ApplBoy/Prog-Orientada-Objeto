/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author saulo-silva
 */
public final class Estoque{
    
    int quantidade;
    Produto produto;

    public Estoque(int _quantidade, Produto _produto) {
        this.quantidade = _quantidade;
        this.produto = _produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "quantidade=" + quantidade + ", produto=" + produto;
    }

    
}
