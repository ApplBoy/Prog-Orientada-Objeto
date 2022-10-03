/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author saulo-silva
 */
public class Autor {
    int codigo;
    String nome;
    
    public Autor(){
        this(0000, "N/A");
    }
    
    public Autor(int _codigo, String _nome){
        this.codigo = _codigo;
        this.nome = _nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + ", nome=" + nome;
    }
}
