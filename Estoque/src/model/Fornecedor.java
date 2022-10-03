/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author saulo-silva
 */
public class Fornecedor {

    String nome, endereco, email;
    
    public Fornecedor(){
        this("N/a", "S/l", "N/a");
    }
    
    public Fornecedor(String _nome, String _endereco, String _email){
        this.nome = _nome;
        this.endereco = _endereco;
        this.email = _email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "nome=" + nome + ", endereco=" + endereco + ", email=" + email;
    }
    
    
}
