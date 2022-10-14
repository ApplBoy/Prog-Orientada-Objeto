/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author saulo-silva
 */
public class RectangleDuplo {
    public double x, y, width, height;
    
    public RectangleDuplo() {
        
    }

    public RectangleDuplo(double x, double y, double width, double height) {
        setBounds(x, y, width, height);
    }
    
    public void setBounds(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    
}
