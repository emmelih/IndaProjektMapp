import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import javax.swing.JPanel;

public class KeyboardGUI {

	private JFrame frame;
	private OurJPanel pianoPanel;
	private JLabel label;
	private MusicPlayer notePlayer;
	private Recorder recordMashin;
    private static int width;
    private static int numOctaves;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        width = 60;
        numOctaves = 3;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyboardGUI window = new KeyboardGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KeyboardGUI() {
		notePlayer = new MusicPlayer();
		recordMashin = new Recorder(notePlayer);
		initialize();
	}

			/**
             * Initialize the contents of the frame.
             */
	private void initialize() {

		frame = new JFrame("The Piano");
		//frame.setBounds(100, 100, 2000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());
		frame.getContentPane().setBackground(new Color(153, 204, 129));



		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;

		

		pianoPanel = new OurJPanel();
		pianoPanel.setLayout(null);
		pianoPanel.setPreferredSize(new Dimension(1500, 440));
		pianoPanel.setBackground(Color.white);
		pianoPanel.setOpaque(false);
		pianoPanel.setSize(pianoPanel.getPreferredSize());
		frame.add(pianoPanel);

		JOptionPane startpane = new JOptionPane();
		startpane.setSize(1000, 1000);
		startpane.showMessageDialog(frame,
				"THIS IS THE PIANO \n by Lovisa von Heijne and Emmeli Hansson \n Press OK to start playing",
				"The Piano", JOptionPane.PLAIN_MESSAGE);

		/**
		 * Create record button.
		 */
		JButton record = new JButton("RECORD");
		record.setBackground(new Color(153, 51, 51));
		record.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				recordMashin.startStopRecording();
				boolean recording=recordMashin.getIfRecording();
				pianoPanel.draw(recording);
			}
		});

		record.setBounds(1300, 70, 100, 50);
		pianoPanel.add(record);
		
		
		
		/**
		 * Create clear recorded button.
		 */
		JButton clearrecord = new JButton("Clear recorded");
		clearrecord.setBounds(1300, 150, 150, 30);
		clearrecord.setBackground(Color.GRAY);
		clearrecord.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				recordMashin.clearRecording();
			}
		});

		pianoPanel.add(clearrecord);
		
		/**
		 * Create play recorded button.
		 */
		JButton playrecord = new JButton("PLAY RECORDED");
		playrecord.setBackground(new Color(51, 153, 102));
		playrecord.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (recordMashin.getPlaying()){
					notePlayer.stop();
				}
				recordMashin.playRecorded();
			}
		});

		playrecord.setBounds(1300, 280, 100, 50);
		pianoPanel.add(playrecord);


		/**
		 * Creating white keys
		 */
		int xw = 0;
        int xb = 0;
        Scale scales = new Scale();
        //String note;

		for(int i = 0; i < numOctaves*7; i++) {
			String note = scales.getWhiteScale().get(i);
			JButton buttonb1 = new JButton("");
			buttonb1.setBackground(Color.WHITE);
			buttonb1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					notePlayer.startPlaying(note);
					if (recordMashin.getIfRecording()) {
						recordMashin.saveNotes(note);
					}
				}
			});
			buttonb1.setBounds(xw, 159, width, 250);
			pianoPanel.add(buttonb1);
			xw += width;
		}

		/**
		 * Creating black keys
		 */
		int counter = 0;
		for(int j = 0; j < numOctaves; j++) {


            // starting position for blacks in octave
            xb += (3*width/4);

            // c & d sharp
            for(int k = 0; k < 2; k++) {
                drawBlack(xb, scales.getBlackScale().get(counter));
                xb += width;
				counter += 1;
            }

            // starting position for next three
            xb += width;

            // f, g, a sharp
            for(int l = 0; l < 3; l++) {
                drawBlack(xb, scales.getBlackScale().get(counter));
                xb += width;
				counter += 1;
            }

            // new octave
            xb += width/4;
		}
		
	}

    public void drawBlack(int x, String filename){
        JButton btnNewButton = new JButton("");
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notePlayer.startPlaying(filename);
			}
		});
        btnNewButton.setBounds(x, 60, width / 2, 100);
		pianoPanel.add(btnNewButton);
    }

}