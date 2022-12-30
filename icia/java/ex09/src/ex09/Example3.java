package ex09;

import java.io.*;
import java.util.StringTokenizer;

public class Example3 {
	public static void execute() {
		//���Ͽ��� ������ �о����
		File file = new File("c://data/java/address.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				String name = st.nextToken();
				String tel = st.nextToken();
				String address = st.nextToken();
				
				System.out.println("�̸� : " + name);
				System.out.println("��ȭ : " + tel);
				System.out.println("�ּ� : " + address);
				System.out.println("");
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
