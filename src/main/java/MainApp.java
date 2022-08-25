
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
    public Menu menu;
    static PPMFrame frame;
    public final JFrame window;
    private Screen screen;
    public static final int WIN_WIDTH = 1280;
    public static final int WIN_HEIGHT = 900;

    public int width, height, nColors;
    //public PixelList list;

    public MainApp() {
        window = new JFrame("Sorting Visualizer");
    }

    public static void main(String[] args){
        MainApp app = new MainApp();
        app.start();
    }
    
    // getters
    public JFrame getWindow(){
        return window;
    }

    public void start(){
        MainMenuScreen mainMenu = new MainMenuScreen(this);
        // make menu
        menu = new Menu(this, window);
        menu.makeMenu();
        //window.setJMenuBar(menu);
        pushScreen(mainMenu);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        window.setVisible(true); // to display the window
        window.setSize(WIN_WIDTH, WIN_HEIGHT); // sets the size of our window, win_width pixels wide and
                
    }

    // pushes the screen to the window
    public void pushScreen(Screen screen) {
        this.screen = screen;
        window.setContentPane(screen);
        window.validate();
        window.pack();
    }   
}

