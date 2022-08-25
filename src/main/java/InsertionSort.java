/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
public class InsertionSort implements SortAlgorithm{
    private static long stepDelay = 20;


    @Override
    public String getName() {
        return "Insertion Sort";
    }

    @Override
    public void runSort(SortArray array) {
        insertionSort(array);
    }

    @Override
    public String getDescription() {
        return "○ A simple sorting algorithm that divides array into sorted and unsorted parts. \n"
                + "○ The sorted part of the array is expanded one element at a time. \n"
                + "  - Find the correct place in the sorted part to place the element of the unsorted part by searching through all of the sorted elements. \n"
                + "  - Move the elements after the inserting point up one position to make space. \n"
                + "  - Insert the element into its correct place (among the items processed so far). \n"
                + "○ Inefficient on large arrays but works well for arrays that are almost sorted.";
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
        return "O(n)";
    }

    @Override
    public String getAverageTime() {
        return "O(n\u00B2)";
    }

    @Override
    public String getWorstCaseSpace() {
        return "O(1)";
    }

    // insertion sort algorithm
    // calls slide function on all elements of array
    private void insertionSort(SortArray array) {
        for(int i=1;i<array.arraySize();i++){
            slide(array, i);
        }
    }
    
    // Move the greater elements one position up to make space for the value at index loc. 
    // Assumes array is sorted, and loc is valid
    private void slide(SortArray array, int loc){
        int temp = array.getValue(loc);
        int j = loc-1;
        
        // compare temp with each element on the left of it until a smaller element is found
        while(j>=0 && array.getValue(j)>temp){
            array.setValue(j+1, array.getValue(j), stepDelay);
            j--;
        }
        array.setValue(j+1, temp, stepDelay);          
    }

    /* PPM Image Sort */
    
    @Override
    public void runSort(PPMFrame image) {
        insertionSort(image);
    }

    // insertion sort algorithm
    // calls slide function on all elements of pixelList
    private void insertionSort(PPMFrame image) {
        int refreshRate = 0;
        PixelList pixels = image.getPixels();
        for(int i=1;i<pixels.arraySize();i++){
            slide(pixels, i);
            refreshRate++;
            if(refreshRate >= 1000){
                refreshRate = 0;
                image.refresh();
            }
        }
    }
    
    // Move the greater elements one position up to make space for the value at index loc. 
    // Assumes array is sorted, and loc is valid
    private void slide(PixelList pixels, int loc){
        Pixel temp = pixels.getValue(loc);
        int j = loc-1;
        
        // compare temp with each element on the left of it until a smaller element is found
        while(j>=0 && pixels.getValue(j).getPos() > temp.getPos()){
            pixels.setValue(j+1, pixels.getValue(j));
            j--;
        }
        pixels.setValue(j+1, temp);          
    }
        
}
