import java.awt.*;


import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * This class is the class that runs the virtual keyboard. It's where the Graphical User Interface is and all the JButtons that make up the keyboard are. 
 * 
 * @author Emmeli Hansson and Lovisa von Heine 
 * @date 2015-05-13
 *
 */
public class KeyboardGUI {

	private JFrame frame;
	private OurJPanel pianoPanel;
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
		frame.setBounds(50, 50, 1800, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());
		frame.getContentPane().setBackground(new Color(153, 204, 129));

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		
		/*
		 * The JPanel on which the keyboard keys and additional buttons are created.
		 */
		pianoPanel = new OurJPanel();
		pianoPanel.setLayout(null);
		pianoPanel.setPreferredSize(new Dimension(1500, 440));
		pianoPanel.setSize(pianoPanel.getPreferredSize());
		pianoPanel.addKeyListener(new OurJPanel(){
			@Override
			public void keyPressed(KeyEvent e){
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER){
					stop();
				}
			}
		});
		
		/*
		 * The change on the x axis and y axis, to move all buttons by the same distance.
		 */
		int changex = 150;
		int changey = 130;
		
		/*
		 * Add a little text description
		 */
		JTextArea text = new JTextArea("Here's a Piano. Feel free to play!");
		text.setEditable(false);
		Font f = new Font("Poor Richard", Font.BOLD, 40);
		text.setFont(f);
		text.setBackground(Color.WHITE);
		text.setOpaque(false);
		text.setBounds(600, 30, 700, 50);
		pianoPanel.add(text);
		
		JTextArea text2 = new JTextArea("Created by Lovisa von Heine and Emmeli Hansson");
		text2.setEditable(false);
		Font f1 = new Font("Poor Richard", Font.PLAIN, 20);
		text2.setFont(f1);
		text2.setBackground(Color.WHITE);
		text2.setOpaque(false);
		text2.setBounds(670, 100, 700, 40);
		pianoPanel.add(text2);
		
		/*
		 * Create a record button.
		 */
		JButton record = new JButton("RECORD");
		Font f2 = new Font("Poor Richard", Font.PLAIN, 20);
		record.setFont(f2);
		//record.setBackground(new Color(205, 201, 201));
		record.setBackground(new Color(205, 85, 85));
		record.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				recordMashin.startStopRecording();
				boolean recording=recordMashin.getIfRecording();
				pianoPanel.draw(recording, changex, changey);
			}
		});

		record.setBounds(1300+changex, 70+changey, 150, 50);
		pianoPanel.add(record);
		
		
		
		/*
		 * Create a clear recorded button.
		 */
		JButton clearrecord = new JButton("Clear recorded");
		clearrecord.setBounds(1300+changex, 150+changey, 150, 30);
		clearrecord.setFont(f2);
		clearrecord.setBackground(new Color(205, 201, 201));
		clearrecord.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				recordMashin.clearRecording();
			}
		});

		pianoPanel.add(clearrecord);
		
		/*
		 * Create a play recorded button.
		 */
		JButton playrecord = new JButton("Play Recorded");
		playrecord.setBackground(new Color(32, 178, 170));
		playrecord.setFont(f2);
		playrecord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				recordMashin.playRecorded();
			}
		});

		playrecord.setBounds(1300+changex, 280+changey, 150, 50);
		pianoPanel.add(playrecord);
		
		/*
		 * Create a stop playing file button (doesn't work for the playing recorded list action).
		 */
		JButton stopplayrecord = new JButton("STOP");
		stopplayrecord.setBackground(new Color(32, 178, 170));
		stopplayrecord.setFont(f2);
		stopplayrecord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				stop();
			}
		});

		stopplayrecord.setBounds(1300+changex, 350+changey, 150, 50);
		pianoPanel.add(stopplayrecord);


		/*
		 * Creating white keys
		 */
		int xw = changex;
        int xb = changex;
        int yw = 159+changey;
        int yb = 60+changey;
        Scale scales = new Scale();
        
        //The loop used to create all white keys.
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
			buttonb1.setBounds(xw, yw, width, 250);
			pianoPanel.add(buttonb1);
			xw += width;
		}

		/*
		 * Creating black keys
		 */
		int counter = 0;
		for(int j = 0; j < numOctaves; j++) {


            // starting position for blacks in octave
            xb += (3*width/4);

            // loop for c & d sharp
            for(int k = 0; k < 2; k++) {
                drawBlack(xb, yb, scales.getBlackScale().get(counter));
                xb += width;
				counter += 1;
            }

            // starting position for next three
            xb += width;

            // loop for f, g, a sharp
            for(int l = 0; l < 3; l++) {
                drawBlack(xb, yb, scales.getBlackScale().get(counter));
                xb += width;
				counter += 1;
            }

            // new octave
            xb += width/4;
		}
		
		/*
		 * Overlay of the pianoPanel onto a new panel whichin turn is added to the frame.
		 */
		
		ImageJPanel panel = new ImageJPanel();
		LayoutManager overlay = new OverlayLayout(panel);
		panel.setLayout(overlay);
		panel.setPreferredSize(new Dimension(1793, 665));
		panel.setBackground();
		
		pianoPanel.setBackground(Color.white);
		pianoPanel.setOpaque(false);
		
		panel.add(pianoPanel);
		
		frame.getContentPane().add(panel);
		
	}
	
	
	/**
	 * Help metod for creating the black keys.
	 * 
	 * @param x the x koordinate on which the key will be created.
	 * @param y the y koordinate on which the key will be created.
	 * @param filename the file adress to the right note file.
	 */
    public void drawBlack(int x,int y, String filename){
        JButton btnNewButton = new JButton("");
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notePlayer.startPlaying(filename);
			}
		});
        btnNewButton.setBounds(x, y, width / 2, 100);
		pianoPanel.add(btnNewButton);
    }
    
    /**
     * Helpmethod to kill the MusicPlayer and stop playing (doesn't work for the play recorded list, but does work for stop playing a key that has just been pressed).
     * 
     */
    private void stop()
    {
    	recordMashin.stopPlaying();
        //notePlayer.stop();
    }

}