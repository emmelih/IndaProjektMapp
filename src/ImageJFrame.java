import javax.swing.*;
import java.awt.*;

/**
 * Created by Lovisa on 2015-05-20.
 */


public class ImageJFrame extends JFrame {

    Image image;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }

    public void setBackground() {
        ImageIcon icon = new ImageIcon("audio/tree.jpg");
        Image image = icon.getImage();
        this.image = image;
        repaint();
    }

}
