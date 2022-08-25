
import java.util.ArrayList;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author maryhan
 */
public class MergeSort implements SortAlgorithm {

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
        algoDesc = "○ If the array has 0 or 1 elements, do nothing. Stop.\n"
                + "○ Continuously split the array into two (approximately) equal halves.\n"
                + "Sort each half recursively. \n"
                + "Merge the sorted halves to produce one sorted result."
                + "○ A \"divide and conquer\" algorithm";
        return algoDesc;
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

    private void mergeSort(SortArray arr, int lo, int hi) {
        if (hi > lo) {
            int mid = (hi + lo) / 2;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    // merges two sorted subarrays of arr[].
    // First subArray is arr[lo..mid].
    // second subArray is arr[mid+1..hi]
    private void merge(SortArray arr, int lo, int mid, int hi) {
        // sizes of two subarrays
        int s1 = mid - lo + 1;
        int s2 = hi - mid;

        //copy data to temp. arrays
        int L[] = new int[s1];
        int R[] = new int[s2];
        for (int i = 0; i < s1; i++) {
            L[i] = arr.getValue(lo + i);
        }
        for (int j = 0; j < s2; j++) {
            R[j] = arr.getValue(mid + 1 + j);
        }

        //merge temp arrays
        int i = 0, j = 0;
        int k = lo;
        while (i < s1 && j < s2) {
            if (L[i] < R[j]) {
                arr.addValue(k, L[i], stepDelay);
                i++;
            } else {
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

    // Image Sort
    @Override
    public void runSort(PPMFrame image) {
        mergeSort(image, image.getPixels(), 0, image.getPixels().arraySize() - 1, 0);
    }

    public void mergeSort(PPMFrame image, PixelList pixels, int startIndex, int endIndex, int refreshRate) {
        refreshRate = 0;

        //Divide till you breakdown your list to single element
        if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
            int mid = (endIndex + startIndex) / 2;
            mergeSort(image, pixels, startIndex, mid, refreshRate);
            mergeSort(image, pixels, mid + 1, endIndex, refreshRate);

            //merging Sorted array produce above into one sorted array
            merge(image, pixels, startIndex, mid, endIndex, refreshRate);
        }
    }

    public void merge(PPMFrame image, PixelList pixels, int lo, int mid, int hi, int refreshRate) {

        //Below is the mergedarray that will be sorted array Array[i-mid] , Array[(mid+1)-hi]
        PixelList mergedSortedArray = new PixelList();

        int leftIndex = lo;
        int rightIndex = mid + 1;

        while (leftIndex <= mid && rightIndex <= hi) {

            if (pixels.getValue(leftIndex).getPos() <= pixels.getValue(rightIndex).getPos()) {
                mergedSortedArray.addValue(pixels.getValue(leftIndex));
                leftIndex++;
            } else {
                mergedSortedArray.addValue(pixels.getValue(rightIndex));
                rightIndex++;
            }
        }

        //Either of below while loop will execute
        while (leftIndex <= mid) {
            mergedSortedArray.addValue(pixels.getValue(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= hi) {
            mergedSortedArray.addValue(pixels.getValue(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = lo;
        //Setting sorted array to original one
        while (i < mergedSortedArray.arraySize()) {
            if (refreshRate >= 1000) {
                refreshRate = 0;
                image.refresh();
            }
            refreshRate++;
            pixels.setValue(j, mergedSortedArray.getValue(i++));
            j++;
        }
    }

}
