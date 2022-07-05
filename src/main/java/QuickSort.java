/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
public class QuickSort implements SortAlgorithm {
    private long stepDelay = 20;
    
    public void quickSort(SortArray array, int start, int end){
        int p = partition(array, start, end);
        quickSort(array, 0, p);
        quickSort(array, p, end);        
    }
    
    // Choose a pivot and put all lesser value than pivot in left and greater values in right
    // return the index of the pivot
    public int partition(SortArray array, int start, int end){
        int pivot = array.getValue(end);
        int pIdx = start;
        for(int i=start;i<end;i++){
            if(array.getValue(i)<pivot){
                array.swap(i,pIdx,stepDelay);
                pIdx++;
            }
        }
        array.swap(end, pIdx, stepDelay);
        return pIdx;
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }

    @Override
    public void runSort(SortArray array) {
        
        quickSort(array, 0, array.arraySize()-1);
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
    
}
