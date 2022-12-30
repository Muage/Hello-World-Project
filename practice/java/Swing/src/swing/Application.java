package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Application {

	private JFrame frame;
	private JPasswordField password;
	private JTextField name;
	private JTextField age;
	private JTextField birthday;
	private JTextField phone;
	private JTextField search;

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
		Customer customer = new Customer();
		
		frame = new JFrame();
		ImgPanel welcomePanel = new ImgPanel(new ImageIcon("U:/코딩/java/Swing/image/welcome.png").getImage());
		welcomePanel.setBounds(0, 1, 1184, 567);
		frame.setSize(welcomePanel.getWidth(), welcomePanel.getHeight());
		frame.getContentPane().setLayout(null);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 1184, 568);
		tablePanel.setVisible(false);
//		String[][] data = customer.getCustomers();
		String[][] data = new String[][] {{"1", "2", "3"}, {"4", "5", "6"}};
		String[] headers = new String[] {"Name", "Phone", "Gender"};
		tablePanel.setLayout(null);
		JTable table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setAlignmentX(0);
		table.setSize(800, 600);
		table.setPreferredScrollableViewportSize(new Dimension(800, 600));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(314, 57, 730, 501);
		tablePanel.add(scrollPane);
		frame.getContentPane().add(tablePanel);
		
		search = new JTextField();
		search.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		search.setBounds(313, 10, 730, 32);
		tablePanel.add(search);
		search.setColumns(10);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		
		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(200);
		columnModels.getColumn(2).setPreferredWidth(50);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1184, 568);
		mainPanel.setBackground(Color.white);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JLabel labelWelcome = new JLabel("Welcome This is Main Panel");
		labelWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelWelcome.setBounds(419, 10, 351, 76);
		mainPanel.add(labelWelcome);
		
		JLabel labelName = new JLabel("Name");
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		labelName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelName.setBounds(237, 117, 147, 34);
		mainPanel.add(labelName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAge.setBounds(237, 178, 147, 34);
		mainPanel.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGender.setBounds(237, 241, 147, 34);
		mainPanel.add(lblGender);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNote.setBounds(621, 241, 147, 34);
		mainPanel.add(lblNote);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblBirthday.setBounds(621, 178, 147, 34);
		mainPanel.add(lblBirthday);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPhone.setBounds(621, 117, 147, 34);
		mainPanel.add(lblPhone);
		
		name = new JTextField();
		name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		name.setBounds(406, 117, 147, 34);
		mainPanel.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		age.setColumns(10);
		age.setBounds(406, 178, 147, 34);
		mainPanel.add(age);
		
		birthday = new JTextField();
		birthday.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		birthday.setColumns(10);
		birthday.setBounds(797, 178, 147, 34);
		mainPanel.add(birthday);
		
		phone = new JTextField();
		phone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBounds(797, 117, 147, 34);
		mainPanel.add(phone);
		
		JComboBox gender = new JComboBox(new String[] {"Male", "Female"});
		gender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		gender.setBounds(406, 241, 147, 34);
		mainPanel.add(gender);
		
		JTextArea note = new JTextArea();
		note.setBounds(797, 241, 147, 147);
		note.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.add(note);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameText = name.getText();
				String ageText = age.getText();
				String phoneText = phone.getText();
				String genderText = gender.getSelectedItem().toString();
				String noteText = note.getText();
				
				customer.createCustomer(nameText, phoneText, genderText, ageText, noteText);
				JOptionPane.showMessageDialog(null, "Your data has been saved successfully");
				mainPanel.setVisible(false);
				tablePanel.setVisible(true);
//				Customer customer = new Customer(nameText, ageText, phoneText, birthdayText, birthdayText, genderText, noteText);
			}
		});
		
		btnNewButton.setBounds(552, 456, 97, 23);
		mainPanel.add(btnNewButton);
		frame.getContentPane().add(welcomePanel);
		
		JLabel labelLogin = new JLabel("Log In");
		labelLogin.setForeground(Color.WHITE);
		labelLogin.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelLogin.setBounds(12, 10, 149, 59);
		welcomePanel.add(labelLogin);
		
		JTextArea id = new JTextArea();
		id.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		id.setToolTipText("ID");
		id.setBounds(84, 79, 249, 38);
		welcomePanel.add(id);
		
		password = new JPasswordField();
		password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		password.setBounds(84, 160, 249, 38);
		welcomePanel.add(password);
		
		JLabel labelId = new JLabel("ID");
		labelId.setForeground(Color.WHITE);
		labelId.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelId.setBounds(12, 79, 60, 38);
		welcomePanel.add(labelId);
		
		JLabel labelPs = new JLabel("PS");
		labelPs.setForeground(Color.WHITE);
		labelPs.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelPs.setBounds(12, 160, 60, 38);
		welcomePanel.add(labelPs);
		
		JButton btnLogIn = new JButton("");
		btnLogIn.setIcon(new ImageIcon("U:\\코딩\\java\\Swing\\image\\img.png"));
		btnLogIn.setPressedIcon(new ImageIcon("U:\\코딩\\java\\Swing\\image\\img.png"));
		btnLogIn.setBounds(12, 241, 321, 59);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().equals("Danny") && Arrays.equals(password.getPassword(), "hello".toCharArray())) {
					System.out.println("Hello Danny");
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "fail");
				}
			}
		});
		welcomePanel.add(btnLogIn);
		
		frame.setJMenuBar(menuBar());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		return bar;
	}
}

class ImgPanel extends JPanel {
	private Image img;
	
	public ImgPanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}
	
	public int getWidth() {
		return img.getWidth(null);
	}
	
	public int getHeight() {
		return img.getHeight(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
