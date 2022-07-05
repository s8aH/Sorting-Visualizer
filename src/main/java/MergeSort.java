
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
public class MergeSort implements SortAlgorithm{
    private String algoDesc;   
    private long stepDelay = 20;

    @Override
    public String getName() {
        return "Merge Sort";
    }
    
    @Override
    public long getDelay() {
        return stepDelay;
    }

    @Override
    public String getDescription() {
        algoDesc = "○ Divide an array into two halves, sort the two halves, and then it merges those two sorted halves.\n" +
"○ We continuously split the array in half to divide until we are left with the individual items\n" +
"○ A divide and conquer algorithm";
        return algoDesc;
    }
    
    @Override
    public void setDelay(long delay) {
        this.stepDelay = delay;
    }
    
    @Override
    public void runSort(SortArray arr) {
        int lo = 0;
        int hi = arr.arraySize() - 1;
        mergeSort(arr, lo, hi);
    }
    

    
    private void mergeSort(SortArray arr, int lo, int hi){
        if(hi > lo){
            int mid = (hi + lo)/2;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid+1, hi);
            merge(arr, lo, mid, hi);
            
        }
    }
    
    // merges two sorted subarrays of arr[].
    // First subArray is arr[lo..mid].
    // second subArray is arr[mid+1..hi]
    private void merge(SortArray arr, int lo, int mid, int hi){
        // sizes of two subarrays
        int s1 = mid - lo + 1;
        int s2 = hi - mid;
        
        //copy data to temp. arrays
        int L[] = new int[s1];
        int R[] = new int [s2];
        for(int i=0;i<s1;i++){
            L[i] = arr.getValue(lo + i);
        }
        for(int j=0;j<s2;j++){
            R[j] = arr.getValue(mid+1 + j);
        }
        
        //merge temp arrays
        int i=0,j=0;
        int k=lo;
        while(i<s1 && j<s2){
            if(L[i] < R[j]){
                arr.addValue(k, L[i], stepDelay);
                i++;
            }else{
                arr.addValue(k, R[j], stepDelay);
                j++;
            }
            k++;
        }
        
        while (i < s1) {
            arr.addValue(k, L[i], stepDelay);
            i++;
            k++;
        }

        while (j < s2) {
            arr.addValue(k, R[j], stepDelay);
            j++;
            k++;
        }
    }  

    @Override
    public String getWorstCaseTime() {
        return "O(n long n)";
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
        return "O(n)";
    }
    
}
