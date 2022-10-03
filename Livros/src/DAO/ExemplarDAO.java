/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model.Exemplar;

/**
 *
 * @author saulo-silva
 */
public class ExemplarDAO {
    
    // Vetores! Um dos Exemplares e outro da Quantidade de cada exemplar...
    public ArrayList <Exemplar> estante = new ArrayList();
    public ArrayList <Integer> quantidade = new ArrayList();
    
    public ExemplarDAO(){}
    
    // Usa-se isso para alterar algum objeto Exemplar no vetor de Exemplares...
    public void setEstante(int i, Exemplar livro) {
        this.estante.set(i, livro);
    }
    
    // Aqui vê-se os códigos são iguais entre os Exemplares
    public int equalLivros(int i, Exemplar Livro){
        if (this.estante.get(i).getCodigo() == Livro.getCodigo()){
            return 1;
        }
        else {
            return 0;
        }
    }
    
}
