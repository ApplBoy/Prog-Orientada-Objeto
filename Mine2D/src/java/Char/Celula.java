/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Char;

import World.Tiles;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author saulo-silva
 */
public class Celula extends Rectangle{
    private static long serialVersionUID = 1L;
    
    public int[] id = {0,0};
    
    public Celula(Rectangle size, int[] id){
        setBounds(size);
        this.id = id;
    }
    
    public void render(Graphics g, boolean taSelecionado){
        g.drawImage(Tiles.tile_Cel, x, y, width, height,null);
        
        if(id != Tiles.ar){
            g.drawImage(Tiles.tileset_terreno, x + Tiles.invBordaItem, y + Tiles.invBordaItem, x + width - Tiles.invBordaItem, y + height - Tiles.invBordaItem, id[0] * Tiles.tamanhoTile, id[1] * Tiles.tamanhoTile, id[0] * Tiles.tamanhoTile + Tiles.tamanhoTile, id[1] * Tiles.tamanhoTile + Tiles.tamanhoTile, null);
        }
        
        if(taSelecionado){
            g.drawImage(Tiles.tile_selCel, x-1, y-1, width+2, height+2, null); //2 pixeis a mais pois ele é 2 pixeis maior que o não selecionado
        }
    }
}
