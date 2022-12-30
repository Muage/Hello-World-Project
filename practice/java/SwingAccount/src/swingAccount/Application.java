package swingAccount;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Application {

	private final String ID = "danny";
	private final String PASS = "1234";
	private JFrame frame;
	private JTextField idField;
	private JPasswordField passField;
	private JPanel currPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
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
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("U:/코딩/java/SwingAccount/image/welcome.png").getImage());
		currPanel = loginPanel;
		
		frame.setSize(loginPanel.getDim());
		frame.setPreferredSize(loginPanel.getDim());
		ImagePanel tranPanel = new ImagePanel(new ImageIcon("U:/코딩/java/SwingAccount/image/gihub.png").getImage());
		frame.getContentPane().add(tranPanel);
		
		tranPanel.setVisible(false);
		ImagePanel sumPanel = new ImagePanel(new ImageIcon("U:/코딩/java/SwingAccount/image/gihub.png").getImage());
		frame.getContentPane().add(sumPanel);
		
		sumPanel.setVisible(false);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		idField = new JTextField();
		idField.setBounds(454, 57, 283, 37);
		idField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		loginPanel.add(idField);
		idField.setColumns(10);
		idField.setBorder(null);
		
		passField = new JPasswordField();
		passField.setBounds(454, 104, 283, 37);
		passField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passField.setBorder(null);
		loginPanel.add(passField);
		
		JCheckBox checkbox = new JCheckBox("Remember me?");
		checkbox.setBounds(454, 159, 148, 23);
		loginPanel.add(checkbox);
		
		JButton logInBtn = new JButton("");
		logInBtn.setBounds(454, 188, 283, 83);
		logInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID.equals(idField.getText()) && PASS.equals(passField.getText())) {
					currPanel.setVisible(false);
					sumPanel.setVisible(true);
					currPanel = sumPanel;
				} else {
					JOptionPane.showMessageDialog(null, "You Failed to log in");
				}
			}
		});
		logInBtn.setBorder(null);
		loginPanel.add(logInBtn);
		logInBtn.setIcon(new ImageIcon("U:/코딩/java/SwingAccount/image/img.png"));
		
		
		
		//Summary
		JButton tranBtn = new JButton("");
		tranBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				tranPanel.setVisible(true);
				currPanel = tranPanel;
			}
		});
		tranBtn.setIcon(new ImageIcon("U:/코딩/java/SwingAccount/image/img.png"));
		tranBtn.setBounds(29, 182, 259, 40);
		tranBtn.setBorder(null);
		sumPanel.add(tranBtn);
		
		//Transaction
		JButton sumBtn = new JButton("");
		sumBtn.setIcon(new ImageIcon("U:/코딩/java/SwingAccount/image/img.png"));
		sumBtn.setBorder(null);
		sumBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				sumPanel.setVisible(true);
				currPanel = sumPanel;
			}
		});
		sumBtn.setBounds(29, 122, 259, 40);
		tranPanel.add(sumBtn);
		
		frame.pack();
		
	}
}
