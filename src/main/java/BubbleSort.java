/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
public class BubbleSort implements SortAlgorithm {

    private static long stepDelay = 20;

    @Override
    public String getName() {
        return "Bubble Sort";
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
    public String getDescription() {
        return "○ The simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order.\n"
                + "○ Not suitable for large arrays \n"
                + "○ is a comparison sort \n"
                + "○ gets its name from the fact that elements tend to move up into the correct order like bubbles rising to the surface.";
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

    @Override
    public void runSort(SortArray array) {
        bubbleSort(array);
    }

    private void bubbleSort(SortArray array) {
        int len = array.arraySize();
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array.getValue(j) > array.getValue(j + 1)) {
                    array.swap(j, j + 1, stepDelay);
                }
            }
        }
    }

    /* PPM Image Sort */
    @Override
    public void runSort(PPMFrame image) {
        bubbleSort(image);
    }

    private void bubbleSort(PPMFrame image) {
        PixelList pixels = image.getPixels();
        int refreshRate = 0;
        int len = pixels.arraySize();

        for (int i = 0; i < len - 1; i++) {
            if (refreshRate >= 100) {
                refreshRate = 0;
                image.refresh();
            }
            for (int j = 0; j < len - i - 1; j++) {

                refreshRate++;
                if (pixels.getValue(j).getPos() > pixels.getValue(j + 1).getPos()) {
                    pixels.swap(j, j + 1);
                }
            }
        }
    }

}
