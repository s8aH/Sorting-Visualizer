
import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
class Pixel {
    
    private int pos, red, green, blue;
            
    Pixel(int pos, int red, int green , int blue) {
        this.pos = pos;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    
    // getters
    public int getPos(){
        return pos;
    }
    
    public Color getColor(){
        return new Color(red,green,blue);
    }
    
    public int getRGB(){
        return new Color(red,green,blue).getRGB();
    }
    
    public int getRed(){
        return red;
    }
    
    public int getGreen(){
        return green;
    }
    
    public int getBlue(){
        return blue;
    }
    
    // setters
    public void setPos(int i){
        this.pos = i;
    }
    
    public void setRed(int red){
        this.red = red;
    }
    
    public void setGreen(int green){
        this.green = green;
    }
    
    public void setBlue(int blue){
        this.blue = blue;
    }
    
}
