/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model.Estoque;

/**
 *
 * @author saulo-silva
 */
public class EstoqueDAO {
    
    // Vetores! Um dos Exemplares e outro da Quantidade de cada exemplar...
    public ArrayList <Estoque> estante = new ArrayList();
    
    public EstoqueDAO(){}
    
    // Usa-se isso para alterar algum objeto Exemplar no vetor de Exemplares...
    /*
    public void setEstante(int i, Estoque livro) {
        this.estante.set(i, livro);
    }*/
    
}
