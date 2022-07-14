
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author maryhan
 */
public class Menu {

    protected MainApp app;
    private final JFrame window;

    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenuItem menuItem;
    private String displayType;

    public Menu(MainApp app, JFrame window, String dt) {
        this.app = app;
        this.window = window;
        this.displayType = dt;
    }

    public void makeMenu() {
        //add menu bar to the frame
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        //add File menu
        menu1 = new JMenu("Sort Algorithm");
        // option + ctrl + N to expand the File menu
        menu1.setMnemonic(KeyEvent.VK_A);

        //add menus to the menu bar
        menuBar.add(menu1);

        //add menu items to the menu
        // Bubble Sort
        menuItem = new JMenuItem("Bubble Sort");
        menu1.add(menuItem);
        menuItem.addActionListener(new bubbleListener()); // new listener class listens for actions on the New button
        // after expanding the menu, press N to click the New menu option.
        menuItem.setMnemonic(KeyEvent.VK_B);
        // Cmd + N to click the New button
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_B,
                        KeyEvent.META_DOWN_MASK)); // META is Cmd key

        // Selection Sort
        menuItem = new JMenuItem("Selection Sort");
        menu1.add(menuItem);
        menuItem.addActionListener(new selectionListener());
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S,
                        KeyEvent.META_DOWN_MASK));

        // Insertion Sort
        menuItem = new JMenuItem("Insertion Sort");
        menu1.add(menuItem);
        menuItem.addActionListener(new insertListener());
        menuItem.setMnemonic(KeyEvent.VK_I);
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_I,
                        KeyEvent.META_DOWN_MASK));
        // Merge Sort
        menuItem = new JMenuItem("Merge Sort");
        menu1.add(menuItem);
        menuItem.setMnemonic(KeyEvent.VK_M);
        menuItem.addActionListener(new mergeListener());
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_M,
                        KeyEvent.META_DOWN_MASK));

        // Quick Sort
        menuItem = new JMenuItem("Quick Sort");
        menu1.add(menuItem);
        menuItem.addActionListener(new quickListener());
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                        KeyEvent.META_DOWN_MASK));

        // Heap Sort
        menuItem = new JMenuItem("Heap Sort");
        menu1.add(menuItem);
        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.addActionListener(new heapListener());
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_H,
                        KeyEvent.META_DOWN_MASK));

        //like a mac menu
        System.setProperty("apple.laf.useScreenMenuBar", "true");

    }

    private class insertListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pushSortingScreen(new InsertionSort());
        }
    }

    private class heapListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pushSortingScreen(new HeapSort());
        }
    }

    private class quickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pushSortingScreen(new QuickSort());
        }
    }

    private class selectionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pushSortingScreen(new SelectionSort());
        }
    }

    private class mergeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pushSortingScreen(new MergeSort());
        }
    }

    private class bubbleListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            pushSortingScreen(new BubbleSort());
        }
    }

    private void pushSortingScreen(SortAlgorithm sortAlgo) {
        //app.pushScreen(new SortingVisualizerScreen(app, sortAlgo));

        if (displayType.equals("bars")) {
            app.pushScreen(new SortingVisualizerScreen(app, sortAlgo));
        } else if (displayType.equals("image")) {
            app.pushScreen(new ImageSortingVisualizerScreen(app, sortAlgo));
        } else {
            JOptionPane.showMessageDialog(app.getWindow(),
                    "ERROR: invalid data display type.",
                    "Crust Type Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}
