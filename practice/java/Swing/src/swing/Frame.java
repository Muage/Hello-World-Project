package swing;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();	//frame 생성,		frame : 프로그램의 전체적인 틀
		JPanel panel = new JPanel();	//panel 생성
		JLabel label = new JLabel("Hello World!");	//label 생성
		JButton btn1 = new JButton("Click");	//button 생성
		JButton btn2 = new JButton("Exit");	//button 생성
		JTextArea	textArea = new JTextArea();	//여러 줄의 내용을 적을 때
		JTextField	textField = new JTextField(200);	//한 줄의 내용을 적을 때 or 내용의 사이즈가 정해져 있을 때
		JPanel btnPanel = new JPanel();	//panel 생성
		
		panel.setLayout(new BorderLayout());	//panel의 위치 설정
		
		btnPanel.add(btn1);	//btnPanel에 btn1 추가
		btnPanel.add(btn2);	//btnPanel에 btn1 추가
		
		panel.add(label, BorderLayout.NORTH);	//label을 panel의 북쪽에 추가
		panel.add(btnPanel, BorderLayout.WEST);	//btnPanel을 panel의 서쪽에 추가
		panel.add(textArea, BorderLayout.CENTER);	//textArea를 panel의 중앙에 추가
		
		btn1.addActionListener(new ActionListener() {	//btn1의 기능 설정
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(textArea.getText());	//label의 내용을 textArea에 적은대로 변경
			}
		});
		
		btn2.addActionListener(new ActionListener() {	//btn2의 기능 설정
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	//프로그램 종료
			}
		});
		
		frame.add(panel);	//frame에 panel 삽입
		
		frame.setResizable(false);	//프로그램 창 크기 조절 가능 유무 설정
		frame.setVisible(true);	//실행시 창이 보이도록 설정
		frame.setPreferredSize(new Dimension(840, 840/12*9));	//실행시 사이즈 설정
		frame.setSize(840, 840/12*9);
		frame.setLocationRelativeTo(null);	//실행시 프로그램 위치
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//프로그램 종료
	}
}
