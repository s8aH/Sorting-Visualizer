/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
public class HeapSort implements SortAlgorithm {

    private static long stepDelay = 20;

    // getters
    @Override
    public String getName() {
        return "Heap Sort";
    }

    @Override
    public String getDescription() {
        return "○ How it works:\n"
                + "	§ First, to build a max heap, we continue to swap until the parents are greater than their children\n"
                + "	§ Swap the first and the last node and delete the last node from the heap \n"
                + "	§ Then create a max heap on reduced array, assuming the rest are already sorted.";
    }

    @Override
    public long getDelay() {
        return stepDelay;
    }

    @Override
    public String getWorstCaseTime() {
        return "O(n log n)";
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
        return "O(1)";
    }

    // setters
    @Override
    public void setDelay(long delay) {
        this.stepDelay = delay;
    }

    @Override
    public void runSort(SortArray array) {
        heapSort(array);
    }

    // Heap Sort
    public void heapSort(SortArray array) {
        int n = array.arraySize();

        // Build max-heap
        // start heapifying each sub-subtree from the bottom up and end up
        for (int i = n / 2 - 1; i > 0; i--) { // n/2-1: the first index of a non-leaf node
            heapify(array, i, n);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            array.swap(0, i, stepDelay); // swap the root element and the element at end of the unsorted array
            heapify(array, 0, i); // heapify the unsorted array
        }
    }

    // Keep swapping until all nodes in the tree follow the property that they 
    // are greater than their children.
    private void heapify(SortArray array, int i, int n) {
        // Find largest among root, left child, and right child.
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array.getValue(left) > array.getValue(largest)) {
            largest = left;
        }
        if (right < n && array.getValue(right) > array.getValue(largest)) {
            largest = right;
        }

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            array.swap(i, largest, stepDelay);
            heapify(array, largest, n);
        }
    }

    /**
     * *********************************************************************
     * PPM Image Sort 
    *********************************************************************
     */
    @Override
    public void runSort(PPMFrame image) {
        heapSort(image);
    }

    private void heapSort(PPMFrame image) {
        PixelList pixels = image.getPixels();
        int n = pixels.arraySize();
        int refreshRate = 0;

        // Build max-heap
        // start heapifying each sub-tree from the bottom up and end up
        for (int i = n / 2 - 1; i > 0; i--) { // n/2-1: the first index of a non-leaf node
            heapify(pixels, i, n);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            if(refreshRate >= 100){
                refreshRate = 0;
                image.refresh();
            }
            refreshRate++;
            pixels.swap(0, i); // swap the root element and the element at end of the unsorted array
            heapify(pixels, 0, i); // heapify the unsorted array
        }
    }
    
    // Keep swapping until all nodes in the tree follow the property that they 
    // are greater than their children.
    private void heapify(PixelList pixels, int i, int n) {
        // Find largest among root, left child, and right child.
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && pixels.getValue(left).getPos() > pixels.getValue(largest).getPos()) {
            largest = left;
        }
        if (right < n && pixels.getValue(right).getPos() > pixels.getValue(largest).getPos()) {
            largest = right;
        }

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            pixels.swap(i, largest);
            heapify(pixels, largest, n);
        }
    }

}
