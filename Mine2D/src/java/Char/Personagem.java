/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Char;

import Controller.Component;
import Controller.RectangleDuplo;
import World.Tiles;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author saulo-silva
 */
public class Personagem extends RectangleDuplo{
    public double velocidadeQueda = 1; //Gravity pls
    public double velocidadeMovimento = 0.5;
    public double velocidadePulo = velocidadeQueda;
    public int distanciaPulo = 40, contadorPulo = 0;
    public int animacao = 0;
    public int animacaoFrame = 0;
    public int animacaoTempo = 30;
    
    public boolean acaoPular = false;
    
    public Personagem( int width, int height){
        setBounds((Component.pixel.width/2) - (width/2), (Component.pixel.height/2) - (height/2), width, height);
    }
    
    public void tick(){
        if (!acaoPular && !colisaoBloco(new Point((int) x + 2, (int) (y + height)), new Point ((int) (x + width) - 2, (int) y))){
            movimentar(); //Movimentar em queda
            y += velocidadeQueda;
            Component.scrollY += velocidadeQueda;
        } else {
            if(Component.taPulando == true){
                acaoPular = true; //Agora ele pula (subir na dimensão Y) aqui
                Component.taPulando = false;
            }
        }
        
        movimentar(); //Movimentar sem cair
        
        if(acaoPular){
            if(!colisaoBloco(new Point((int) x + 2, (int) y), new Point ((int) (x + width) - 2, (int) y))){
                if(contadorPulo >= distanciaPulo){
                    acaoPular = false;
                    contadorPulo = 0;
                } else {
                    y -= velocidadePulo;
                    Component.scrollY -= velocidadePulo;
                    contadorPulo += 1;
                }
            } else {
                acaoPular = false;
                
                contadorPulo = 0;
            }
        }
    }
    
    void movimentar(){
        if (Component.taMovendo){
            boolean podeMover = false; //para não passar as paredes
            
            if(Component.dir == velocidadeMovimento){
                podeMover = colisaoBloco(new Point((int) (x + width), (int) y), new Point ((int) (x + width), (int) (y + (height - 2))));
            } else if(Component.dir == -velocidadeMovimento){
                podeMover = colisaoBloco(new Point((int) x - 1, (int) y), new Point ((int) x - 1, (int) (y + (height - 2))));
            }
            
            if (animacaoFrame >= animacaoTempo){ //para parar a animação de movimento ao encontrar uma parede só colocar dentro o if(!podeMover)
                if(animacao > 0){
                    animacao = 0;
                } else {
                    animacao += 1;
                }
                animacaoFrame = 0;
            } else {
                animacaoFrame += 1;
            }
            
            if(!podeMover){
                x += Component.dir;
                Component.scrollX += Component.dir;
            }
        } else {
            animacao = 0;
        }
    }
    
    public boolean colisaoBloco(Point pt1, Point pt2){ //tá colidindo no y ou no x?
        for(int x = (int) (this.x/Tiles.tamanhoTile); x < (int) (this.x/Tiles.tamanhoTile) + 3; x++){
            for(int y = (int) (this.y/Tiles.tamanhoTile); y < (int) (this.y/Tiles.tamanhoTile) + 3; y++){
                if( x >= 0 && y >= 0 && x < Component.nivel.bloco.length && y < Component.nivel.bloco[0].length)
                if(Component.nivel.bloco[x][y].id != Tiles.ar) {
                    if(Component.nivel.bloco[x][y].contains(pt1) || Component.nivel.bloco[x][y].contains(pt2)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void render(Graphics g){
        /* Debug Personagem
        g.setColor(new Color(255, 100, 100));
        g.fillRect((int) x, (int) y, (int) width, (int) height);*/
        
        if (Component.dir == velocidadeMovimento){
            // Essa é pra girar a personagem para ela ficar olhando para a direita
            g.drawImage(Tiles.tileset_terreno, (int) x - (int) Component.scrollX, (int) y - (int) Component.scrollY, (int) x + (int) width - (int) Component.scrollX, (int) y + (int) height - (int) Component.scrollY, /* Coordenadas Reais - Coordenadas Imagens */ (Tiles.personagem[0] * Tiles.tamanhoTile) + (Tiles.tamanhoTile * animacao), Tiles.personagem[1] * Tiles.tamanhoTile, (Tiles.personagem[0] * Tiles.tamanhoTile) + (Tiles.tamanhoTile * animacao) + (int) width, Tiles.personagem[1] * Tiles.tamanhoTile + (int) height, null);
        } else {
            // Essa é pra girar a personagem para ela ficar olhando para a esquerda
            g.drawImage(Tiles.tileset_terreno, (int) x - (int) Component.scrollX, (int) y - (int) Component.scrollY, (int) x + (int) width - (int) Component.scrollX, (int) y + (int) height - (int) Component.scrollY, /* Coordenadas Reais - Coordenadas Imagens */ (Tiles.personagem[0] * Tiles.tamanhoTile) + (Tiles.tamanhoTile * animacao) + (int) width, Tiles.personagem[1] * Tiles.tamanhoTile, (Tiles.personagem[0] * Tiles.tamanhoTile) + (Tiles.tamanhoTile * animacao), Tiles.personagem[1] * Tiles.tamanhoTile + (int) height, null);
        }
    }
}
