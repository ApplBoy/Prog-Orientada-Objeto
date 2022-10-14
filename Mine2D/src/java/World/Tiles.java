/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package World;

import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

/**
 *
 * @author saulo-silva
 */
public class Tiles {
    public static int tamanhoTile = 20;
    public static int inventarioTamanho = 8;
    public static int invCelulaTamanho = 25;
    public static int invCelulaEspaco = 4;
    public static int invBordaEspaco = 4;
    public static int invBordaItem = 4;
    
    public static int[] ar = {-1,-1};
    public static int[] terra = {0,0};
    public static int[] grama = {1,0};
    public static int[] areia = {2,0};
    public static int[] madeira = {3,0};
    public static int[] folhas = {4,0};
    public static int[] pedra = {5,0};
    
    public static int[] personagem = {0, 18}; //posição do tile da personagem
    
    public static BufferedImage tileset_terreno;
    public static BufferedImage tile_Cel;
    public static BufferedImage tile_selCel;
    
    // --- OBS.: MUDE TODAS AS STRINGS PARA EXECUTAR NO SEU COMPUTADOR ---
    public static String netbeansLocal = "/home/saulo-silva/NetBeansProjects/";
    
    public Tiles(){
        try {
            tileset_terreno = ImageIO.read(new File(netbeansLocal+"Minecraft2D/src/main/java/imgs/tileset_terreno.png"));
            tile_Cel = ImageIO.read(new File(netbeansLocal+"Minecraft2D/src/main/java/imgs/tile_cel.png"));
            tile_selCel = ImageIO.read(new File(netbeansLocal+"Minecraft2D/src/main/java/imgs/tile_selCel.png"));
        } catch(Exception e){ }
    }
}
