package tutorial_5.balls;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BallGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextArea textArea;
	public static JTextField textField_1;
	public static int width = 588;
	public static int height = 302;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BallGame frame = new BallGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BallGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new Renderer();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 6, width, height);
		contentPane.add(panel);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if (Renderer.start){
				btnNewButton.setText("Start");
				Renderer.start = false;
			}
			else{
				btnNewButton.setText("Stop");
				Renderer.start = true;
			}

			}
		});
		btnNewButton.setBounds(6, 316, 117, 56);
		contentPane.add(btnNewButton);

		textArea = new JTextArea();
		textArea.setBounds(135, 315, 211, 52);
		contentPane.add(textArea);
		textArea.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(358, 316, 211, 53);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

}
