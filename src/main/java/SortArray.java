
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
class SortArray extends JPanel {
    protected static long stepDelay = 20;
    
    private final int[] array;
    
    private final int WIN_WIDTH = 1280;
    private final int WIN_HEIGHT = 550;
    private final int BAR_WIDTH = 5;
    private final int NUM_BARS = WIN_WIDTH / BAR_WIDTH;
    private final int[] barColours;
    
    private SortAlgorithm algorithm;
    private String algoName = "";
    private JSpinner spinner;
    private long algorithmDelay = 0;
    
    // Constructor to set values and the background
    public SortArray(){
        setBackground(Color.GRAY);
        barColours = new int[NUM_BARS];
        array = new int [NUM_BARS];
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = i;
            barColours[i] = 0; // white as default bar colour
        }
    }
    
    public void setName(String algoName) {
        this.algoName = algoName;
    }
    
    public void setValue(int idx, int val){
        array[idx] = val;
    }
    
    public int getValue(int index){
        return array[index];
    }
    
    // returns array size
    public int arraySize() {
        return array.length;
    }
    
    public long getAlgorithmDelay(){
        return algorithmDelay;
    }
    
    public String getAlgorithmName(){
        return algoName;
    }

    // sets algorithm
    public void setAlgorithm(SortAlgorithm algorithm) {
        this.algorithm = algorithm;
        algorithmDelay = algorithm.getDelay();
    }
    
    // shuffles the array values by swapping random indices
    public void shuffle(){
        Random rand = new Random();
        for(int i=0;i<array.length;i++){
            int swapWithIdx = rand.nextInt(array.length - 1);
            swap(i, swapWithIdx, 5);
        }
    }
    
    // Find the position of the minimum value from index idx to the end of the array.
    public int findMin(int idx){
        int min = idx;
        for(int i=idx+1;i<arraySize();i++){
            if(getValue(i) < getValue(min)){
                min = i;
            }
        }
        return min;
    }
       
    // swap two values at idx1 and idx2 in the array
    // idx1: first index
    // idx2: second index
    public void swap(int idx1, int idx2, long millisecondDelay){
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
        
        // bars being swapped are set to pink
        barColours[idx1] = 100;
        barColours[idx2] = 100;
        
        repaint();
        try {
            Thread.sleep(millisecondDelay);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // reesets the bar colours. repaint() calls the paintComponent() method
    public void resetColours() {
        for (int i = 0; i < NUM_BARS; i++) {
            barColours[i] = 0; // white as default bar colour
        }
        repaint();
    }
    
    // adds a single value at the given index of the array then repaints
    public void addValue(int index, int val, long millisecondDelay){
        array[index] = val;
        barColours[index] = 100;
        try {
            Thread.sleep(millisecondDelay);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        repaint(); // erase and perform redraw of the component

    }
    
    // draws bars with the array values and sets bar colours
    @Override
    public void paintComponent(Graphics g){
        Graphics2D panelGraphics = (Graphics2D) g.create();
        super.paintComponent(panelGraphics);
        
        panelGraphics.setColor(Color.PINK);
        panelGraphics.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        panelGraphics.drawString(algoName, 100, 30);
        
        for(int i=0;i<NUM_BARS;i++){
            int bar_height = array[i] * 2;
            int col = barColours[i] * 2;
            int xcor = i + (BAR_WIDTH - 1) * i;
            int ycor = WIN_HEIGHT - bar_height;
            
            panelGraphics.setColor(new Color(255,255,255-col));
            panelGraphics.fillRect(xcor, ycor, BAR_WIDTH, bar_height);
            
            if (barColours[i] > 0) {
                barColours[i] -= 10;
            }
        }
    
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT);
    }
}
