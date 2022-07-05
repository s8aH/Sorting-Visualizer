
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
public class MainMenuScreen extends Screen {  
    
    public MainMenuScreen(MainApp app) {
        super(app);
        onOpen();
    }
    
    
    public void onOpen(){
        JLabel label = new JLabel("Select an algorithm to visualize from the drop-down menu",
                SwingConstants.CENTER);
        label.setFont(new Font("Al Bayan",Font.PLAIN, 30));
        add(label);
    }    
}
