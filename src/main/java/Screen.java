
import java.awt.Dimension;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author maryhan
 */
public abstract class Screen extends JPanel{
    
    protected MainApp app;
    
    public Screen(MainApp app){
        this.app = app;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MainApp.WIN_WIDTH, MainApp.WIN_HEIGHT);
    }

    // abstract method for subclasses to override
    public abstract void onOpen();
    
}
