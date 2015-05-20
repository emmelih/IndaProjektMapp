import javax.swing.*;
import java.awt.*;

/**
 * Created by Lovisa on 2015-05-20.
 */


public class ImageJFrame extends JFrame {
        private Image image;
        public ImagePanel(Image image) {
            this.image = image;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.repaint(g);
            g.drawImage(image, 0, 0, this);
        }
    }

}
