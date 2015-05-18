import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class KeyboardGUI {

	private JFrame frame;
	private MusicPlayer notePlayer;
    private static int width;
    private static int numOctaves;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        width = 60;
        numOctaves = 4;

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
		frame.getContentPane().setLayout(null);


		/**
		 * Creating white keys
		 */
		int xw = 0;
        int xb = 0;

		for(int i = 0; i < numOctaves*7; i++) {
			JButton buttonb1 = new JButton("");
			buttonb1.setBackground(Color.WHITE);
			buttonb1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
                    notePlayer.startPlaying("audio/c3.mp3");
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
                drawBlack(xb);
                xb += width;
            }

            // starting position for next three
            xb += width;

            // f, g, a sharp
            for(int l = 0; l < 3; l++) {
                drawBlack(xb);
                xb += width;
            }

            // new octave
            xb += width/4;
		}
	}

    public void drawBlack(int x){
        JButton btnNewButton = new JButton("b");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
            }
        });
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(x, 60, width/2, 100);
        frame.getContentPane().add(btnNewButton);

    }

}