


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
public interface SortAlgorithm {
        
    public String getName();
    
    public void runSort(SortArray array);
    
    public void runSort(PPMFrame image);

    public String getDescription();

    public long getDelay();

    public void setDelay(long delay);

    public String getWorstCaseTime();

    public String getBestCaseTime();

    public String getAverageTime();

    public String getWorstCaseSpace();
}
