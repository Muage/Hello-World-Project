package ex09;

import java.io.*;

public class Example2 {
	public static void execute() {
		System.out.println("******************** �ּҰ��� ********************");
		File file = new File("c://data/java/address.txt");	//���� ����
		
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write("ȫ�浿, 010-0000-1111, ��õ ���� �漭��\n");
			writer.write("��û��, 010-2222-3333, ���� ������ �б�����\n");
			writer.flush();	//���� ���� ����
			writer.close();	//���� �ݱ�
			System.out.println("���� �Ϸ�");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
