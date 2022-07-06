
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingWorker;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
public class SortingVisualizerScreen extends Screen {
    private final SortArray sortArray;
    private final SortAlgorithm algorithm;
    SwingWorker swingWorker;
    
    public SortingVisualizerScreen(MainApp app, SortAlgorithm algo) {
        super(app);
        sortArray = new SortArray();
        this.algorithm = algo;
        onOpen();
    }
    
    // generate new array and reset bar colours to white
    public void shuffleAndReset(){
        sortArray.shuffle();
        sortArray.resetColours();
        try {
            Thread.sleep(2);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    // begins visual sorter
    //applies the required operations of adding name, colouring bars, sorting, 
    //and then resetting colours.
    public void startVisSort(){
        swingWorker = new SwingWorker(){
            @Override
            protected Object doInBackground(){
                shuffleAndReset();
                
                sortArray.setName(algorithm.getName());
                sortArray.setAlgorithm(algorithm);
                algorithm.runSort(sortArray);
                
                sortArray.resetColours();
                
                return null;
            }
        };
        
        swingWorker.execute();
    }
    
    public void onOpen(){
        // generate an unsorted array
        shuffleAndReset();
        // vertical stack
        JPanel main = new JPanel();
        JPanel subSection = new JPanel();
        JPanel buttonContainer = new JPanel();
        JPanel descContainer = new JPanel();
        JPanel perfContainer = new JPanel();
        JPanel smallPanelL = new JPanel();
        JPanel smallPanelR = new JPanel();

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        subSection.setLayout(new GridLayout(2,1));
        buttonContainer.setLayout(new FlowLayout());
        perfContainer.setLayout(new BoxLayout(perfContainer, BoxLayout.X_AXIS));        
        smallPanelL.setLayout(new BoxLayout(smallPanelL, BoxLayout.Y_AXIS));        
        smallPanelR.setLayout(new BoxLayout(smallPanelR, BoxLayout.Y_AXIS));        

        // Sorting array visualizer
        //add(sortArray);
        
        // Add Buttons
        JButton sortButton = new JButton("Sort!");
        buttonContainer.add(sortButton);
        JButton newArrayButton = new JButton("Generate New Array");
        buttonContainer.add(newArrayButton);
        
        // Sort Button
        sortButton.addActionListener((ActionEvent e) -> {
            newArrayButton.setText("Stop and Generate New Array");
            startVisSort();           
        });
        
        // Generate New Array Button
        // stops execution if already running then generate New Array Button
        newArrayButton.addActionListener((ActionEvent e) -> {
            newArrayButton.setText("Generate New Array");
            swingWorker.cancel(true);
            shuffleAndReset();
        });        
        
        // Algorithm Description
        descContainer.setBorder(BorderFactory.createTitledBorder(algorithm.getName()));
        JTextArea textArea= new JTextArea(algorithm.getDescription(),3,90);
        textArea.setLineWrap(true);
        JScrollPane scrollArea = new JScrollPane(textArea);
        // set text field size
        textArea.setMaximumSize(new Dimension(27, 100));
        scrollArea.setVerticalScrollBarPolicy(
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollArea.setHorizontalScrollBarPolicy(
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        descContainer.add(scrollArea);
        
        // Performance      
        perfContainer.setBorder(BorderFactory.createTitledBorder("Performance"));

        smallPanelL.add(new JLabel("Worst-case time complexity:"));       
        smallPanelL.add(new JLabel("Average time complexity:"));
        smallPanelL.add(new JLabel("Best-case time complexity:"));
        smallPanelL.add(new JLabel("Worst-case space complexity:"));
        
        smallPanelR.add(new JLabel(algorithm.getWorstCaseTime()));
        smallPanelR.add(new JLabel(algorithm.getAverageTime()));
        smallPanelR.add(new JLabel(algorithm.getBestCaseTime()));
        smallPanelR.add(new JLabel(algorithm.getWorstCaseSpace()));
        perfContainer.add(smallPanelL);
        perfContainer.add(smallPanelR);
        
        add(main);
        main.add(sortArray);
        sortArray.setPreferredSize(sortArray.getPreferredSize());
        main.add(buttonContainer);
        main.add(subSection);
        subSection.add(descContainer);
        subSection.add(perfContainer);
        
        setVisible(true);
    }
}
