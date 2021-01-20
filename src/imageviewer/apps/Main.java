package imageviewer.apps;

import imageviewer.control.ImagePresenter;
import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{

    private List<Image> list;
    private ImageDisplay imageDisplay;
    private ImagePresenter imagePresenter;
    
    public static void main(String[] args) {
        new Main().execute();
    }
    
    public Main() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.list = new FileImageLoader(new File("fotos")).load();
        this.getContentPane().add(createImagePanel());       
        this.imageDisplay.display(list.get(0));
        this.imagePresenter = new ImagePresenter(list, imageDisplay);
    }
    
    private void execute() {
        this.setVisible(true);
    }

    private JPanel createImagePanel() {
        ImagePanel imagePanel = new ImagePanel();
        this.imageDisplay = imagePanel;
        return imagePanel;
    }
    
}
