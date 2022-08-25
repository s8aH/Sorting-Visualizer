
import java.util.ArrayList;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
public class SelectionSort implements SortAlgorithm{
    private static long stepDelay = 20;
    
    @Override
    public String getName() {
        return "Selection Sort";
    }

    @Override
    public String getDescription() {
        return "○ In every iteration of selection sort, find the minimum value in the unsorted subarray and is swapped with the current value and is moved to the sorted subarray.";
    }

    @Override
    public long getDelay() {
        return stepDelay;
    }

    @Override
    public void setDelay(long delay) {
        this.stepDelay = delay;
    }

    @Override
    public String getWorstCaseTime() {
        return "O(n\u00B2)";
    }

    @Override
    public String getBestCaseTime() {
        return "O(n\u00B2)";
    }

    @Override
    public String getAverageTime() {
        return "O(n\u00B2)";
    }

    @Override
    public String getWorstCaseSpace() {
        return "O(1)";
    }
    
    @Override
    public void runSort(SortArray arry) {
        selectionSort(arry);
    }
    
    // take the current element and exchange it with the smallest element on the
    // right hand side of the current element.
    public void selectionSort(SortArray array){
        for(int i=0;i<array.arraySize();i++){
            int min = array.findMin(i);
            array.swap(i, min, stepDelay);
        }
    }
    
    // Image Sort
    @Override
    public void runSort(PPMFrame image) {
        selectionSort(image);
    }
    
    public void selectionSort(PPMFrame image){
        PixelList pixels = image.getPixels();
        int refreshRate = 0;
        for(int i=0;i<pixels.arraySize();i++){
            int min = pixels.findMin(i);
            pixels.swap(i, min);
            
            refreshRate++;
            if(refreshRate >= 1000){
                refreshRate = 0;
                image.refresh();
            }
        }        
    }

    
}
