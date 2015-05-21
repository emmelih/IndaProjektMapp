import javax.swing.*;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class OurJPanel extends JPanel implements KeyListener{
	private boolean recording;
	private int x;
	private int y;
	
	public OurJPanel(){
		super();
	}
	
	
	
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
