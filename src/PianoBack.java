 import javax.swing.*;
 import java.awt.*;
 
 /**
  * Created by Lovisa on 2015-05-20.
  */

public class PianoBack extends JPanel {



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.drawRect(0, 60, 21*60 , 100);
        //(xw, 
        g.fillRect(0, 60, 21*60 , 100);
    }

    public void setWhiteRect() {
      repaint();
	     }
	 
	 }

