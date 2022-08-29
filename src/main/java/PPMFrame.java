/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryhan
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;

@SuppressWarnings("serial")
public class PPMFrame extends Screen {

    private Menu menu;
    private SortAlgorithm algorithm;
    public JButton sortBtn;
    //private PPMImage img;
    private JLabel img;

    private PixelList pixels = new PixelList();
    private int width, height, nColors;
    private String type;

    SwingWorker swingWorker;

    public PPMFrame(MainApp app, Menu menu, SortAlgorithm sa, PixelList pixels, int width, int height, int nColors, String type) {
        super(app);
        this.menu = menu;
        this.algorithm = sa;

        this.pixels = pixels;
        this.width = width;
        this.height = height;
        this.nColors = nColors;
        this.type = type;

        onOpen();
    }

    public void makeContent() {

        JPanel main = new JPanel();
        add(main);
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        sortBtn = new JButton(new ImageIcon("play.png"));
        sortBtn.addActionListener((ActionEvent e) -> {
            startVisSort();
        });
        main.add(sortBtn);

        JPanel image = new JPanel();
        //img = new PPMImage(this.getImage(), pixels, height, width);
        img = new JLabel(this.makeImage());
        
        image.add(img);
        main.add(image);

        // added a small empty border to the entire content pane, giving it a 
        //little room around the edges
        image.setBorder(BorderFactory.createEmptyBorder());
    }

    // add File menu and a vertical separator to the menu bar, then set 
    // fileMenuAdded variable in Menu class to true.
    public void makeMenuBar() {
        menu.addComp(makeFileMenu(), 0);
        //menu.addComp(new JSeparator(SwingConstants.VERTICAL), 1);
        menu.setFileMenuAdded(true);
    }

    // update the menu bar by adding file menu 
    public JMenu makeFileMenu() {
        JMenu menu;
        JMenuItem menuItem1, menuItem2, menuItem3, menuItem4;

        // set up the File menu
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);

        // add Open menu item
        menuItem1 = new JMenuItem("Open...");
        menuItem1.setMnemonic(KeyEvent.VK_O);
        menuItem1.addActionListener(new OpenMenuItemListener());
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                KeyEvent.META_DOWN_MASK));
        menu.add(menuItem1);

        // add default images
        menuItem2 = new JMenuItem("Kitten Image");
        menuItem2.addActionListener(new ImageListener("kitten.ppm"));
        menu.add(menuItem2);
        
        menuItem3 = new JMenuItem("Galaxy Image");
        menuItem3.addActionListener(new ImageListener("galaxy.ppm"));
        menu.add(menuItem3);
        
        menuItem4 = new JMenuItem("Violin Image");
        menuItem4.addActionListener(new ImageListener("violin.ppm"));
        menu.add(menuItem4);

        return menu;
    }

    public PixelList getPixels() {
        return pixels;
    }

    public void setPixels(PixelList pixels) {
        this.pixels = pixels;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getnColors() {
        return nColors;
    }

    public void setnColors(int nColors) {
        this.nColors = nColors;
    }

    public String getImageType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ImageIcon makeImage() {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < pixels.arraySize(); i++) {
            bi.setRGB(i % width, i / width, pixels.getValue(i).getRGB());
        }
        return new ImageIcon(bi);
    }

    @Override
    public void onOpen() {
        if (menu.isFileMenuAdded() == false) {
            makeMenuBar();
        }
        makeContent();

        setSize(width + 12, height + 60);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*----------*
    * Listeners *
    *-----------*/
    public class OpenMenuItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //ArrayList<Pixel> list = new ArrayList<Pixel>();

            // select then open a file 
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(null);
            File imageFile = fc.getSelectedFile();
            // user opens a dialog can click cancel w/o selecting a file.
            if (imageFile == null) {
                return;
            }

            menu.openImage(imageFile, algorithm);
        }
    }

    public class ImageListener implements ActionListener {
        private String fileName;
        public ImageListener(String fileName){
            this.fileName = fileName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            File imageFile = new File(fileName);
            menu.openImage(imageFile, algorithm);
        }
    }
    
    public void shuffle() {
        pixels.shuffle();
        refresh();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
           return;
        }
    }
    
    public void refresh() {
        img.setIcon(this.makeImage());
        repaint();
    }

    public void startVisSort() {
        swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() {
                shuffle(); // works
                //algorithm.runSort(img);
                sort();

                return null;
            }
        };

        swingWorker.execute();

    }
    
    public void sort(){
        algorithm.runSort(this);
    }
    
}
