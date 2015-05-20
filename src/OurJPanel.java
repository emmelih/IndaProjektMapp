import javax.swing.*;

import java.awt.Graphics;
import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class OurJPanel extends JPanel {
	private boolean recording;
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
			if(recording){
				g.setColor(Color.RED);
				g.drawOval(1420, 70, 20, 20);
				g.fillOval(1420, 70, 20, 20);
			
			}
			if (!recording){
				g.setColor(Color.GREEN);
				g.drawOval(1420, 70, 20, 20);
				g.fillOval(1420, 70, 20, 20);
			}
	}
	
	public void draw(boolean recording){
		this.recording = recording;
		repaint();
	}
	
	

}
