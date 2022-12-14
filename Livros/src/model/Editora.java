/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author saulo-silva
 */
public class Editora {
    int codigo;
    String nome, local;
    
    public Editora(){
        this(0000, "N/A", "S/L");
    }
    
    public Editora(int _codigo, String _nome, String _local){
        this.codigo = _codigo;
        this.nome = _nome;
        this.local = _local;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + ", nome=" + nome + ", local=" + local;
    }
    
}
