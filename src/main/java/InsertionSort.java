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
        return "○ Remove an element from an unsorted input list and insert in the "
                + "correct position in an already-sorted, but partial list that "
                + "contains elements from the input list. \n"
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
        
}
