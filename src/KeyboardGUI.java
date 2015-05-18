import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class KeyboardGUI {

	private JFrame frame;
	private MusicPlayer notePlayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
<<<<<<< HEAD
		frame.setBounds(100, 100, 688, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("c1");
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
		btnNewButton.setBounds(235, 60, 45, 101);
		frame.getContentPane().add(btnNewButton);
		
		JButton buttonb1= new JButton("b1");
		buttonb1.setBackground(Color.WHITE);
		buttonb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonb1.setBounds(104, 159, 66, 122);
		frame.getContentPane().add(buttonb1);
	}
}
=======
		frame.setBounds(100, 100, 1500, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		/**
		 * Creating white keys
		 */
		int xw = 0;
		int xb = 45;
		int blackToDraw = 2;
		int drawn = 0;

		for(int i = 0; i < 25; i++) {
			JButton buttonb1 = new JButton("b1");
			buttonb1.setBackground(Color.WHITE);
			buttonb1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			buttonb1.setBounds(xw, 159, 60, 250);
			frame.getContentPane().add(buttonb1);
			xw += 60;
		}

		/**
		 * Creating black keys
		 */
		while (drawn < blackToDraw) {

			JButton btnNewButton = new JButton("c1");
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
			btnNewButton.setBounds(xb, 60, 30, 100);
			frame.getContentPane().add(btnNewButton);
			xb += 60;
			drawn += 1;
		}

	}}
>>>>>>> d0b3bdbdc4f7337c534bb60d062164102248017c
