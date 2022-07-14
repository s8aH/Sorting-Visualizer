
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */

public class MainApp {
    private final JFrame window;
    private Screen screen;
    
    public static final int WIN_WIDTH = 1280;
    public static final int WIN_HEIGHT = 900;
            
    public MainApp(){
        window = new JFrame("Sorting Visualizer"); // titles for the window
    }    
       
    // getters
    public JFrame getWindow(){
        return window;
    }
    
    public Screen getCurrentScreen(){
        return screen;
    }
    
    // pushes the screen to the window
    public void pushScreen(Screen screen){
        this.screen = screen;
        window.setContentPane(screen);
        window.validate();
    }
    
    public void start(){
        MainMenuScreen mainMenu = new MainMenuScreen(this);
        
        pushScreen(mainMenu);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        window.setVisible(true); // to display the window
        window.setSize(WIN_WIDTH, WIN_HEIGHT); // sets the size of our window, win_width pixels wide and
                // win_height pixels tall
        //window.pack(); //sizes the frame so that all its contents are at or above their preferred sizes.
    }
    
    public static void main(String[] args){
        MainApp app = new MainApp();
        app.start();
    }    
}

