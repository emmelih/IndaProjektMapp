import javax.swing.*;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class extends the JPanel class and overwrites the paint method, so that, when the additional method draw is called with the recording boolean true, the little red 'recording' dot is drawn. This class also implements KeyListener and it's methods, so that a Panel of this type can listen for that kind of action.
 * 
 * 
 * @author Emmeli Hansson and Lovisa von Heine
 * @date 2015-05-16
 *
 */
public class OurJPanel extends JPanel implements KeyListener{
	private boolean recording;
	private int x;
	private int y;
	
	/**
	 * Constructor.
	 */
	public OurJPanel(){
		super();
	}
	
	
	/**
	 * Paints a little red dot if recording is true. If recording is false, paints that dot in a different color which should be the same as the background.
	 */
	@Override
	public void paint(Graphics g){
		super.paint(g);
			if(recording){
				g.setColor(Color.RED);
				g.drawOval(1470+x, 70+y, 20, 20);
				g.fillOval(1470+x, 70+y, 20, 20);
			
			}
			if (!recording){
				g.setColor(new Color(255, 255, 240	));
				g.drawOval(1470+x, 70+y, 20, 20);
				g.fillOval(1470+x, 70+y, 20, 20);
			}
	}
	
	/**
	 * A method that draws a little dot by calling repaint().
	 * 
	 * @param recording the boolean which decides what color the dot should be.
	 * @param x the x coordinates at which the dot should be drawn.
	 * @param y the y coordinates at wich the dot should be drawn.
	 */
	public void draw(boolean recording, int x, int y){
		this.recording = recording;
		this.x = x;
		this.y = y;
		
		repaint();
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	

}
