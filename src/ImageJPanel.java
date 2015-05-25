 import javax.swing.*;
 import java.awt.*;
 
 /**
  * 
  * This class is an extension of the JPanel class, in which the paintComponents method is overwritten, so that it includes an image in the given Component when called upon. There is also an additional setBackground method in which repaint() is calles after the image has been imported. 
  * 
  * @author Lovisa von Heine and Emmeli  Hansson 
  * @date 2015-05-20.
  */

public class ImageJPanel extends JPanel {

	/**
	 * Constructor
	 */
	public ImageJPanel(){
		super();
	}


    private Image image;

    /**
     * Draws the image when called upon.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    /**
     * Method which sets the image with the given fileadress as background in the component.
     */
    public void setBackground() {
        ImageIcon icon = new ImageIcon("audio/images2.jpg");
        Image image = icon.getImage();
        this.image = image;
      repaint();
	     }
	 
	 }

