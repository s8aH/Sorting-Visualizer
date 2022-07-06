/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
public class QuickSort implements SortAlgorithm {
    private long stepDelay = 2;

    @Override
    public String getName() {
        return "Quick Sort";
    }

    @Override
    public String getDescription() {
        return "○ It picks an element as pivot and partitions an array around the picked pivot.\n" +
"○ Different version of quicksort that pick pivot in different ways:\n" +
"	§ Always pick first element as pivot\n" +
"	§ Always pick last element as pivot\n" +
"	§ Pick a random element as pivot\n" +
"	§ Pick median as pivot\n" +
"○ A Divide and Conquer algorithm\n" +
"	§a strategy of solving a large problem by. breaking the problem into smaller sub-problems. solving the sub-problems, then combining the solutions to the sub-problems to find the solution to the original problem";
    }

    @Override
    public long getDelay() {
        return stepDelay;
    }

    @Override
    public void setDelay(long delay) {
        stepDelay = delay;
    }

    @Override
    public String getWorstCaseTime() {
        return "O(n\u00B2)";
    }

    @Override
    public String getBestCaseTime() {
        return "O(n log n)";
    }

    @Override
    public String getAverageTime() {
        return "O(n log n)";
    }

    @Override
    public String getWorstCaseSpace() {
        return "O(log n)";
    }
    
    @Override
    public void runSort(SortArray array) {       
        quickSort(array, 0, array.arraySize()-1);
    }
    
    public void quickSort(SortArray array, int start, int end){
        if(start < end){
            int p = partition(array, start, end);
            quickSort(array, 0, p);
            quickSort(array, p+1, end);
        }               
    }
    
    // Takes last element as pivot, places the pivot at its appropriate position 
    // such that all lesser values (lesser than pivot) are to left of pivot and 
    // all greater values are to right of pivot, and then returns the correct 
    // position of the pivot
    public int partition(SortArray array, int start, int end){
        int pivot = array.getValue(end); // pivot
        int pIdx = start; // right position of pivot found so far
        for(int i=start;i<end;i++){
            if(array.getValue(i)<pivot){
                array.swap(i,pIdx,stepDelay);
                pIdx++;
            }
        }
        array.swap(end, pIdx, stepDelay);
        return pIdx;
    }    
}
