import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class KeyboardGUI {

	private JFrame frame;
	private MusicPlayer notePlayer;
	private Recorder recordMashin;
    private static int width;
    private static int numOctaves;
	//private static LinkedList<String> whiteScale;
    //private static String note;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        width = 60;
        numOctaves = 3;
        //note = "";

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
        //width = 60;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/**
		 * Create record button.
		 */
		JButton record = new JButton("RECORD");
		record.setBounds(1300, 70, 100, 50);
		record.setBackground(Color.GRAY);
		record.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				recordMashin.startStopRecording();
			}
		});
		record.setBounds(1300, 70, 100, 50);
		frame.getContentPane().add(record);
		
		/**
		 * Create play recorded button.
		 */
		JButton playrecord = new JButton("PLAY RECORDED");
		playrecord.setBounds(1300, 280, 100, 50);
		playrecord.setBackground(Color.GREEN);
		playrecord.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				recordMashin.playRecorded();
			}
		});
		playrecord.setBounds(1300, 280, 100, 50);
		frame.getContentPane().add(playrecord);


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
					if (recordMashin.getIfRecording()){
						recordMashin.saveNotes(note);
					}
				}
			});
			buttonb1.setBounds(xw, 159, width, 250);
			frame.getContentPane().add(buttonb1);
			xw += width;
		}

		/**
		 * Creating black keys
		 */
		for(int j = 0; j < numOctaves; j++) {
            // starting position for blacks in octave
            xb += (3*width/4);

            // c & d sharp
            for(int k = 0; k < 2; k++) {
                drawBlack(xb, "audio/c3.mp3");
                xb += width;
            }

            // starting position for next three
            xb += width;

            // f, g, a sharp
            for(int l = 0; l < 3; l++) {
                drawBlack(xb, "audio/c3.mp3");
                xb += width;
            }

            // new octave
            xb += width/4;
		}
	}

    public void drawBlack(int x, String filename){
        JButton btnNewButton = new JButton("b");
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notePlayer.startPlaying(filename);
			}
        });
        btnNewButton.setBounds(x, 60, width/2, 100);
        frame.getContentPane().add(btnNewButton);

    }
    /*
	public LinkedList<String> getWhiteScale(){
		LinkedList<String> whiteScale = new LinkedList<String>();
		for(int i = 3; i < 6; i++) {
			whiteScale.add("audio/c" + i + ".mp3");
			whiteScale.add("audio/d" + i + ".mp3");
			whiteScale.add("audio/e" + i + ".mp3");
			whiteScale.add("audio/f" + i + ".mp3");
			whiteScale.add("audio/g" + i + ".mp3");
			whiteScale.add("audio/a" + i + ".mp3");
			whiteScale.add("audio/b" + i + ".mp3");
		}
		return whiteScale;
	}
	*/

}