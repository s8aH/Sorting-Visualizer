

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
public class PixelList {
    ArrayList<Pixel> pixels;
    
    public PixelList(){
        pixels = new ArrayList<Pixel>();
    }
    
    public PixelList(int n){
        pixels = new ArrayList<>(n);
    }

    public PixelList(java.util.List<Pixel> list) {
        pixels = new ArrayList(Arrays.asList(list));
    }
    
    public Pixel getValue(int i){
        return pixels.get(i);
    }
    
    public void setValue(int idx, Pixel val){
        pixels.set(idx, val);
    }
    
    public int arraySize(){
        return pixels.size();
    }
    
    public void addValue(Pixel val){
        pixels.add(val);
    }
    
    public void swap(int i, int j){
        Pixel temp = pixels.get(i);
        pixels.set(i, pixels.get(j));
        pixels.set(j, temp);
        
        // repaint();
    }
    
    public void shuffle(){
        Collections.shuffle(pixels);
    }
    
    // returns the index of the minimum value of the list
    public int findMin(int idx){
        int min = idx;
        for(int i=idx+1;i<pixels.size();i++){
            if(pixels.get(i).getPos() < pixels.get(min).getPos()){
                min = i;
            }
        }
        return min;
    }
}
