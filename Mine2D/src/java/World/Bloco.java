/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package World;

import Controller.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author saulo-silva
 */
public class Bloco extends Rectangle{
    private static final long serialVersionUID = 1L;
    public int[] id = {-1, -1};
    
    public Bloco(Rectangle size, int[] id){
        setBounds(size);
        this.id = id;
    }
    
    public void render(Graphics g, boolean taSelecionado){
        if (id != Tiles.ar && !taSelecionado){ // se não for ar então desenhe o bloco
            g.drawImage(Tiles.tileset_terreno, x - (int) Component.scrollX, y - (int) Component.scrollY, x + width - (int) Component.scrollX, y + height - (int) Component.scrollY, id[0] * Tiles.tamanhoTile, id[1] * Tiles.tamanhoTile, id[0] * Tiles.tamanhoTile + Tiles.tamanhoTile, id[1] * Tiles.tamanhoTile + Tiles.tamanhoTile, null);
        } else if (id != Tiles.ar){ //Mostrar um quadrado de seleção do bloco
            g.setColor(Color.BLACK);
            g.drawRect(x - (int) Component.scrollX, y - (int) Component.scrollY, Tiles.tamanhoTile, Tiles.tamanhoTile);
        }
    }
}
