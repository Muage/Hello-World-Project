package swing;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class WindowBuilder {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilder window = new WindowBuilder();
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
	public WindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("New WindowBuilder");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel endPage = new JPanel();
		endPage.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(endPage);
		endPage.setLayout(null);
		
		JButton beforeBtn = new JButton("GO TO LAST");
		beforeBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		beforeBtn.setBounds(482, 40, 263, 484);
		endPage.add(beforeBtn);
		
		JPanel startPage = new JPanel();
		startPage.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(startPage);
		startPage.setLayout(null);
		
		JButton nextBtn = new JButton("GO TO NEXT");
		nextBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nextBtn.setBounds(48, 32, 289, 473);
		startPage.add(nextBtn);
		
		endPage.setVisible(false);
		
		nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(true);
				startPage.setVisible(false);
			}
		});
		
		beforeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startPage.setVisible(true);
				endPage.setVisible(false);
			}
		});
	}
}
