
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
    private JMenu menu1, menu2;
    private JMenuItem menuItem;
    
    public Menu(MainApp app, JFrame window){
        this.app = app;
        this.window = window;
    }
    
    public void makeMenu(){
        //add menu bar to the frame
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        //add File menu
        menu1 = new JMenu("Sort Algorithm");
        // option + ctrl + N to expand the File menu
        menu1.setMnemonic(KeyEvent.VK_A);

        //add Edit menu
        menu2 = new JMenu("Size");
        menu2.setMnemonic(KeyEvent.VK_S);

        //add menus to the menu bar
        menuBar.add(menu1);
        menuBar.add(menu2);

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
        menuItem.addActionListener(new selectListener());
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
        menuItem.setMnemonic(KeyEvent.VK_M);
        menuItem.addActionListener(new heapListener());

        // For Size Menu
        //copy
        menuItem = new JMenuItem("5");
        menu2.add(menuItem);
        menuItem.addActionListener(new sizeListener());
        menuItem.setMnemonic(KeyEvent.VK_C);
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_C,
                        KeyEvent.META_DOWN_MASK));
        //cut
        menuItem = new JMenuItem("10");
        menu2.add(menuItem);
        menuItem.addActionListener(new sizeListener());
        menuItem.setMnemonic(KeyEvent.VK_X);
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_X,
                        KeyEvent.META_DOWN_MASK));
        //paste
        menuItem = new JMenuItem("25");
        menu2.add(menuItem);
        menuItem.addActionListener(new sizeListener());
        menuItem.setMnemonic(KeyEvent.VK_V);
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_V,
                        KeyEvent.META_DOWN_MASK));
        //find
//        menuItem = new JMenuItem("50");
//        menu2.add(menuItem);
//        menuItem.addActionListener(new sizeListener());
//        menuItem.setMnemonic(KeyEvent.VK_F);
//        menuItem.setAccelerator(
//                KeyStroke.getKeyStroke(KeyEvent.VK_F,
//                        KeyEvent.META_DOWN_MASK));
//        //replace
//        menuItem = new JMenuItem("75");
//        menu2.add(menuItem);
//        menuItem.addActionListener(new sizeListener());
//        menuItem.setMnemonic(KeyEvent.VK_R);
//        menuItem.setAccelerator(
//                KeyStroke.getKeyStroke(KeyEvent.VK_R,
//                        KeyEvent.META_DOWN_MASK));
//        
//        menuItem = new JMenuItem("100");
//        menu2.add(menuItem);
//        menuItem.addActionListener(new sizeListener());
//        menuItem.setMnemonic(KeyEvent.VK_R);
//        menuItem.setAccelerator(
//                KeyStroke.getKeyStroke(KeyEvent.VK_R,
//                        KeyEvent.META_DOWN_MASK));

        //like a mac menu
        System.setProperty("apple.laf.useScreenMenuBar", "true");

    }
    /*
    private class menuListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            SortAlgorithm algo = null;
            MenuItem source = (MenuItem) e.getSource();
            String menuName = source.getName();
            if(menuName == "Merge Sort"){
                 algo = new MergeSort();
            }
            else if(menuName == null){
                throw new UnsupportedOperationException("No algorithm is selected");
            }
            
            app.pushScreen(new SortingVisualizerScreen(app, algo));
        }
    }
    */
    private static class insertListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class sizeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private class heapListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            app.pushScreen(new SortingVisualizerScreen(app, new HeapSort()));
        }
    }

    private class quickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            app.pushScreen(new SortingVisualizerScreen(app, new QuickSort()));
        }
    }

    private class selectListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody  
        }
    }
    
    private class mergeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            app.pushScreen(
                new SortingVisualizerScreen(app, new MergeSort()));
        }
    }
    
    private class bubbleListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            app.pushScreen(
                new SortingVisualizerScreen(app, new BubbleSort()));
        }
        
        

    }
}
