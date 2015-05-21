<<<<<<< HEAD
 import javax.swing.*;
 import java.awt.*;
 
 /**
  * Created by Lovisa on 2015-05-20.
  */

public class ImageJFrame extends JPanel {


    Image image;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
=======
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
>>>>>>> 57e546ae70b740a8c98c67857d76785d9b97cd80
        g.drawImage(image, 0, 0, this);
    }

    public void setBackground() {
<<<<<<< HEAD
        ImageIcon icon = new ImageIcon("audio/tree.jpg");
        Image image = icon.getImage();
        this.image = image;
      repaint();
	     }
	 
	 }

=======
        ImageIcon icon = new ImageIcon("audio/bg3.jpg");
        Image image = icon.getImage();
        this.image = image;
        repaint();
    }

}
>>>>>>> 57e546ae70b740a8c98c67857d76785d9b97cd80
