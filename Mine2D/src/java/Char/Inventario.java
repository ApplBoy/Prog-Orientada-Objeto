/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Char;

import Controller.Component;
import World.Tiles;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author saulo-silva
 */
public class Inventario {
    
    public Celula[] barraInv = new Celula[Tiles.inventarioTamanho];
    
    public static int selected = 0;
    
    public Inventario(){
        for(int i = 0; i < barraInv.length; i++){
            barraInv[i] = new Celula(new Rectangle( (Component.pixel.width / 2) - ((Tiles.inventarioTamanho * (Tiles.invCelulaTamanho + Tiles.invCelulaEspaco))/2) + (i * (Tiles.invCelulaTamanho + Tiles.invCelulaEspaco)), Component.pixel.height - (Tiles.invCelulaTamanho + Tiles.invBordaEspaco), Tiles.invCelulaTamanho, Tiles.invCelulaTamanho), Tiles.ar);
        }
        
        barraInv[0].id = Tiles.terra;
        barraInv[1].id = Tiles.grama;
        barraInv[2].id = Tiles.areia;
        barraInv[3].id = Tiles.madeira;
        barraInv[4].id = Tiles.folhas;
        barraInv[5].id = Tiles.pedra;
    }
    
    public void render(Graphics g){
        for(int i = 0; i < barraInv.length; i++){
            boolean taSelecionado = false;
            if(i == selected) {
                taSelecionado = true;
            }
            barraInv[i].render(g, taSelecionado);
        }
    }
}
