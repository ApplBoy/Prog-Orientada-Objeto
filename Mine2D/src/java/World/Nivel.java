/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package World;

import Controller.Component;
import Char.Inventario;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author saulo-silva
 */
public class Nivel {
    
    public int mundoWeight = 50, mundoHeight = 50, temperaturaInicial = 5, temperaturaFinal = 20; //Use esses valores para mudar a geração do mundo
    public Bloco[][] bloco = new Bloco[mundoWeight][mundoHeight]; //Vetor multidimensões
    
    public Nivel(){
        for (int dimensaoX = 0; dimensaoX < bloco.length; dimensaoX++){
            for (int dimensaoY = 0; dimensaoY < bloco[0].length; dimensaoY++){ //lendo bloco por bloco de cada coluna
                bloco[dimensaoX][dimensaoY] = new Bloco(new Rectangle(dimensaoX * Tiles.tamanhoTile, dimensaoY * Tiles.tamanhoTile, Tiles.tamanhoTile, Tiles.tamanhoTile), Tiles.ar);
            }
        }
        
        gerarNivel();
    }
    
    public void gerarNivel() {
        //Gerando chão
        for (int y = 0; y < bloco.length; y++){
            //aplicando o random
            for (int x = 0; x < bloco[0].length; x++){
                if(y > mundoHeight/4) {
                    
                    // Aqui ele verifica o blocos próximos um aos outros
                    if(new Random().nextInt(100) > temperaturaFinal){
                        try {
                            if(bloco[x-1][y-1].id == Tiles.terra) {
                                bloco[x][y].id = Tiles.terra;
                            }
                        } catch(Exception e) { }
                    }
                    if(new Random().nextInt(100) > temperaturaFinal + 10){
                        try {
                            if(bloco[x+1][y-1].id == Tiles.terra) {
                                bloco[x][y].id = Tiles.terra;
                            }
                        } catch(Exception e) { }
                    }
                    if(new Random().nextInt(100) > temperaturaFinal - 10){
                        try {
                            if(bloco[x][y-1].id == Tiles.terra) {
                                bloco[x][y].id = Tiles.terra;
                            }
                        } catch(Exception e) { }
                    }
                    
                    if(new Random().nextInt(100) < temperaturaInicial){
                        bloco[x][y].id = Tiles.terra;
                    }
                }
                
                // --- MODO DEBUG 2 ---
                /*if (y > mundoHeight/2){
                    bloco[x][y].id = Tiles.terra;
                }*/
            }
            
            //--- MODO DEBUG ---
            /*for (int y = 0; y < bloco[0].length; y++){ //lendo bloco por bloco de cada coluna
                //if (x == 0 || y == 0 || x == bloco.length-1 || y == bloco[0].length-1){
                if (x == 0 || y == 0 || x == mundoWeight-1 || y == mundoHeight-1){
                    bloco[x][y].id = Tiles.terra; //preencher os cantos com Terra
                }
            }*/
        }
        
        // Colocando grama
        
        for(int y = 0; y < bloco.length; y++){
            for(int x = 0; x < bloco[0].length; x++){
                if(bloco[x][y].id == Tiles.terra && bloco[x][y-1].id == Tiles.ar){
                    bloco[x][y].id = Tiles.grama;
                }
            }
        }
    }
    
    public void construir(int cameraX, int cameraY, int renderW, int renderH){
        if(Component.mouseEsquerdo || Component.mouseDireito){
            for (int x = 0; x < mundoWeight; x++){
                for (int y = 0; y < mundoHeight; y++){ //lendo bloco por bloco de cada coluna
                    //if( x >= 0 || y >= 0 || x < bloco.length || y < bloco[0].length){
                    if(bloco[x][y].contains(new Point((Component.mouse.x / Component.tamanhoPixel) + (int) Component.scrollX, (Component.mouse.y / Component.tamanhoPixel) + (int) Component.scrollY))){
                        int obj[] = Component.inventario.barraInv[Inventario.selected].id; //Captura o bloco selecionado
                        if(Component.mouseEsquerdo){
                            bloco[x][y].id = Tiles.ar;
                        } else if(Component.mouseDireito){
                            if(obj != Tiles.ar){ // Verifica se selecionou algum bloco válido
                                bloco[x][y].id = obj; //aplica o bloco no Pointer do mouse
                            }
                        }

                        break;
                    }
                }
            }
        }
    }
    
    public void tick(int cameraX, int cameraY, int renderW, int renderH){
        construir(cameraX, cameraY, renderW, renderH);
    }
    
    public void render(Graphics g){
        int selecaoX = 0, selecaoY = 0;
        for (int x = 0; x < mundoWeight; x++){
            for (int y = 0; y < mundoHeight; y++){ //lendo bloco por bloco de cada coluna
                //if( x >= 0 || y >= 0 || x < bloco.length || y < bloco[0].length){
                if(bloco[x][y].contains(new Point((Component.mouse.x / Component.tamanhoPixel) + (int) Component.scrollX, (Component.mouse.y / Component.tamanhoPixel) + (int) Component.scrollY))){
                    selecaoX = x; selecaoY = y; //registrar o mouse pra colocar um quadrado em cima de todos os blocos selecionados
                }
                bloco[x][y].render(g, false);
            }
        }
        bloco[selecaoX][selecaoY].render(g, true); //colocar quadrado de seleção no mouse
    }
    
}
