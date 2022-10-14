/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Char.Inventario;
import World.Tiles;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 *
 * @author saulo-silva
 */
public class Listener implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener{
    
    Listener(){}

    // MOVIMENTOS BÁSICOS ---
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int tecla = ke.getKeyCode();
        //System.out.println(tecla); !!! DEBUG
        switch(tecla){
            case KeyEvent.VK_D:
                Component.taMovendo = true;
                Component.dir = Component.personagem.velocidadeMovimento;
                break;
                
            case KeyEvent.VK_A:
                Component.taMovendo = true;
                Component.dir = -Component.personagem.velocidadeMovimento;
                break;
                
            case KeyEvent.VK_W:
                Component.taPulando = true;
                
                break;
                
            case KeyEvent.VK_ESCAPE:
                System.exit(0);

                break;
        }
        
        
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int tecla = ke.getKeyCode();
        
        switch(tecla){
            case KeyEvent.VK_D:
                if(Component.dir == Component.personagem.velocidadeMovimento){
                    Component.taMovendo = false;
                }
                break;
                
            case KeyEvent.VK_A:
                if(Component.dir == -Component.personagem.velocidadeMovimento){
                    Component.taMovendo = false;
                }
                break;
                
            case KeyEvent.VK_W:
                Component.taPulando = true;
                
                break;
        }
    }
    
    // MOVIMENTOS AVANÇADOS ---

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON1){ //Botão Esquerdo
            Component.mouseEsquerdo = true;
        } else if (me.getButton() == MouseEvent.BUTTON3){ //Botão Direito
            Component.mouseDireito = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON1){ //Botão Esquerdo
            Component.mouseEsquerdo = false;
        } else if (me.getButton() == MouseEvent.BUTTON3){ //Botão Direito
            Component.mouseDireito = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        Component.mouse.setLocation(me.getX(), me.getY());
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        Component.mouse.setLocation(me.getX(), me.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        if(mwe.getWheelRotation() > 0) { //Pra baixo
            if(Inventario.selected < Tiles.inventarioTamanho - 1){
                Inventario.selected++;
            } else {
                Inventario.selected = 0;
            }
        } else if (mwe.getWheelRotation() < 0) { //Pra cima
            if(Inventario.selected < 1){
                Inventario.selected = Tiles.inventarioTamanho - 1;
            } else {
                Inventario.selected--;
            }
        }
    }
    
    
}
