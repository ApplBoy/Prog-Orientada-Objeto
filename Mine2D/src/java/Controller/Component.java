/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Char.Inventario;
import Char.Personagem;
import World.Tiles;
import World.Nivel;
import java.applet.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author saulo-silva
 * 
 * Essa é a classe controladora e possui a main, as outras classes podem ser 
 * autoexplicativas, espero eu, mas altere a Tiles.java pra executar no NetBeans
 * 
 */

public class Component extends Applet implements Runnable{
    
    private final long serialVersionUID = 1L;
    public static String name = "M E U  M I N E  2 D";
    public static boolean estaRodando = false;
    public static boolean taMovendo = false;
    public static boolean taPulando = false;
    //public static int moverDaBorda = 1000;
    public static int tamanhoPixel = 2;
    public static Dimension size = new Dimension(800, 640);
    public static Dimension pixel = new Dimension(size.width/tamanhoPixel, size.height/tamanhoPixel);
    private Image screen; //Display na tela em si
    public static double scrollX = 0, scrollY = 0; //Isso é o scroll da tela, influenciado pelo tick do personagem
    public static double dir = 0;
    
    public static Point mouse = new Point(0,0);
    public static boolean mouseEsquerdo = false;
    public static boolean mouseDireito = false;
    
    public static Nivel nivel;
    public static Personagem personagem;
    public static Inventario inventario;
    
    public Component(){
        //setSize(size);
        setPreferredSize(size);
        
        addKeyListener(new Listener());
        addMouseListener(new Listener());
        addMouseMotionListener(new Listener());
        addMouseWheelListener(new Listener());
    }
    
    public void start(){
        //Definindo os objetos aqui
        new Tiles(); //Carregar os tiles
        nivel = new Nivel();
        personagem = new Personagem(Tiles.tamanhoTile, Tiles.tamanhoTile*2);
        inventario = new Inventario();
        
        //Começando um loop do jogo
        estaRodando = true;
        new Thread(this).start();
    }
    
    public void stop(){
        estaRodando = false;
    }
    
    public static void main(String args[]){
        Component component = new Component();
        
        JFrame frame = new JFrame();
        frame.add(component);
        frame.pack();
        frame.setTitle(name);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        component.start();
        
    }
    
    public void tick(){
        //Tick = Movimento, tempo
        
        personagem.tick();
        nivel.tick((int) scrollX, (int) scrollY, (pixel.width/Tiles.tamanhoTile) + 2, (pixel.height/Tiles.tamanhoTile) + 2);
    }
    
    public void render(){
        //Renderização
        
        Graphics g = screen.getGraphics();
        
        //Desenhando na tela
        g.setColor(new Color(120,120,255));
        g.fillRect(0,0,pixel.width,pixel.height);
        //g.fillRect(0, 0, screen.getWidth(null), screen.getHeight(null));
        
        nivel.render(g);
        personagem.render(g);
        inventario.render(g);
        
        g = getGraphics();
        
        g.drawImage(screen, 0, 0, size.width, size.height, 0, 0, pixel.width, pixel.height, null);
        g.dispose(); //Arrumar lag
    }
    
    public void run(){
        screen = createVolatileImage(pixel.width, pixel.height); //acessando pela GPU a imagem (-lag)
        while(estaRodando){
            render();
            tick();
            
            try{
                Thread.sleep(5);
            } catch(Exception e){ }
        }
    }
}
