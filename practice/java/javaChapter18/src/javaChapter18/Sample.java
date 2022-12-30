package javaChapter18;

import java.io.InputStream;
import java.io.OutputStream;

public class Sample {
	public static void main(String[] args) throws Exception {
		// �ܼ� �����
		// System.in �ʵ�
		System.out.println("--- �� �� ---");
		System.out.println("1. ���� ��ȸ");
		System.out.println("2. ���� ���");
		System.out.println("3. ���� �Ա�");
		System.out.println("4. ���� �ϱ�");
		System.out.print("�޴��� �����ϼ���.");
		
		InputStream is = System.in;	// Ű���� �Է� ��Ʈ�� ���
		char inputChar = (char)is.read();	// �ƽ�Ű �ڵ� �а� ���ڷ� ����
		switch(inputChar) {
		case '1':
			System.out.println("���� ��ȸ�� �����ϼ̽��ϴ�.");
			break;
			
		case '2':
			System.out.println("���� ����� �����ϼ̽��ϴ�.");
			break;
			
		case '3':
			System.out.println("���� �Ա��� �����ϼ̽��ϴ�.");
			break;
			
		case '4':
			System.out.println("���� �ϱ⸦ �����ϼ̽��ϴ�.");
			break;
		}
		
		InputStream ins = System.in;
		byte[] datas = new byte[100];
		
		System.out.print("�̸�: ");
		int nameBytes = ins.read(datas);
		String name = new String(datas, 0, nameBytes-2);
		
		System.out.print("�ϰ� ���� ��: ");
		int commentBytes = ins.read(datas);
		String comment = new String(datas, 0, commentBytes-2);
		
		System.out.println("�Է��� �̸�: " + name);
		System.out.println("�Է��� �ϰ� ���� ��: " + comment);
		
		// System.out �ʵ�
		OutputStream os = System.out;
	}
}
