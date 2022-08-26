
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

    private JRadioButton barButton;
    private JRadioButton imageButton;
    private ButtonGroup displayButtonGroup;
    private String displayType;

    public MainMenuScreen(MainApp app) {
        super(app);
        onOpen();
    }
    
    // getter
    public String getDisplayType(){
        return displayType;
    }

    public void onOpen() {
        makeContent();
    }

    // makes contents for the screen
    private void makeContent() {        
        setBorderLayout();
        makeInstruction();
        //makeDisplayTypeButtons();
    }
    
    // makes a panel and set its layour and border
    private void setBorderLayout(){
        setLayout(new GridLayout(3,1));
    }
    
    private void makeInstruction(){
        // instruction
        JLabel label = new JLabel("<html> You must select an algorithm and data type before <br />"
                + "you can visualize it's execution on an array of numbers or pixels. </html>",
                SwingConstants.CENTER);
        label.setFont(new Font("Al Bayan", Font.PLAIN, 30));

        // add label to panel
        add(label);
    }
    
    private void makeDisplayTypeButtons(){
        // create radio buttons
        barButton = new JRadioButton("Bars", true);
        imageButton = new JRadioButton("Image", false);

        // add buttons to button group
        displayButtonGroup = new ButtonGroup();
        displayButtonGroup.add(barButton);
        displayButtonGroup.add(imageButton);        

        //add buttons to panel
        JPanel panel = new JPanel();
        panel.add(imageButton);
        panel.add(barButton);
        add(panel);
        
        if (barButton.isSelected()) {
                displayType = "bars";
            } else if (imageButton.isSelected()) {
                displayType = "image";
            } else {
                JOptionPane.showMessageDialog(this,
                        "You must select a data display type!",
                        "Crust Type Error",
                        JOptionPane.ERROR_MESSAGE);
            }
    }
}
