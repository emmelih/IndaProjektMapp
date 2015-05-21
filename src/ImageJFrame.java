 import javax.swing.*;
 import java.awt.*;
 
 /**
  * Created by Lovisa on 2015-05-20.
  */

public class ImageJFrame extends JPanel {
	
	public ImageJFrame(){
		super();
	}


    Image image;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    public void setBackground() {
        ImageIcon icon = new ImageIcon("audio/images2.jpg");
        Image image = icon.getImage();
        this.image = image;
      repaint();
	     }
	 
	 }

