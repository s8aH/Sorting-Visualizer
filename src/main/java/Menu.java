
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author maryhan
 */
public class Menu extends JMenuBar {

    protected MainApp app;
    private final JFrame window;
    static PPMFrame frame;
    private int width, height, nColors;
    private String type;
    private PixelList list;

    private JMenuBar menuBar;
    private String[] algorithms = {"Merge Sort", "Heap Sort", "Insertion Sort",
        "Quick Sort", "Selection Sort", "Bubble Sort"};
    private String[] dispTypes = {"Bars", "Image"};
    private JComboBox comboBox1, comboBox2;
    private JButton sortBtn;
    public boolean fileMenuAdded = false;

    JMenuItem menuItem1, menuItem2;

    public Menu(MainApp app, JFrame window) {
        this.app = app;
        this.window = window;
    }

    // getters & setters   
    public void setFileMenuAdded(boolean b) {
        fileMenuAdded = b;
    }

    public boolean isFileMenuAdded() {
        return fileMenuAdded;
    }

    // add component to the menu bar at position i
    public void addComp(Component comp, int i) {
        menuBar.add(comp, i);
        menuBar.validate();
    }

    public void makeMenu() {
        menuBar = new JMenuBar();

        // add menu bar to the frame     
        window.setJMenuBar(menuBar);

        // make sorting algorithm drop-down list 
        comboBox1 = new JComboBox();
        for (int i = 0; i < algorithms.length; i++) {
            comboBox1.addItem(algorithms[i]);
        }

        // make display type drop-down list
        comboBox2 = new JComboBox();
        for (int i = 0; i < dispTypes.length; i++) {
            comboBox2.addItem(dispTypes[i]);
        }

        // make sort button
        sortBtn = new JButton("GO!");
        // add actionListener to listen for change
        sortBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String algo = (String) comboBox1.getSelectedItem();
                switch (algo) {
                    case "Bubble Sort":
                        pushSortingScreen(new BubbleSort());
                        break;
                    case "Selection Sort":
                        pushSortingScreen(new SelectionSort());
                        break;
                    case "Insertion Sort":
                        pushSortingScreen(new InsertionSort());
                        break;
                    case "Merge Sort":
                        pushSortingScreen(new MergeSort());
                        break;
                    case "Quick Sort":
                        pushSortingScreen(new QuickSort());
                        break;
                    case "Heap Sort":
                        pushSortingScreen(new HeapSort());
                        break;
                }
            }
        });

        //add components to the menu bar
        menuBar.add(comboBox1);
        menuBar.add(comboBox2);
        menuBar.add(new JSeparator(SwingConstants.VERTICAL));
        menuBar.add(sortBtn);

        //like a mac menu
        System.setProperty("apple.laf.useScreenMenuBar", "true");
    }

    private void pushSortingScreen(SortAlgorithm sortAlgo) {
        String dispType = (String) comboBox2.getSelectedItem();

        if (dispType.equals("Bars")) {
            if (fileMenuAdded) {
                setFileMenuAdded(false);
                menuBar.remove(0);
                //menuBar.remove(1);
                menuBar.validate();
            }
            app.pushScreen(new SortingVisualizerScreen(app, sortAlgo));
        } else if (dispType.equals("Image")) {
            File image = new File("kitten.ppm");
            openImage(image, sortAlgo);

        } else {
            JOptionPane.showMessageDialog(null,
                    "ERROR: invalid data display type.",
                    "Data Display Type Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void openImage(File image, SortAlgorithm sortAlgo) {

        Scanner scan;
        try {
            scan = new Scanner(image);

            list = new PixelList();

            type = scan.nextLine();
            width = scan.nextInt();
            height = scan.nextInt();
            nColors = scan.nextInt();

            int i = 1;
            while (scan.hasNext()) {
                list.addValue(new Pixel(i++, scan.nextInt(), scan.nextInt(), scan.nextInt()));
            }

            scan.close();
            frame = new PPMFrame(app, this, sortAlgo, list, width, height, nColors, type);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(app.getWindow(), "Error: file " + image.getName() + " not found");
            //return; // can be removed
        }

        app.pushScreen(frame);
        window.setSize(width + 12, height + 60);

    }

    public void shuffle() {
        frame.shuffle();
        frame.refresh();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
    }

}
