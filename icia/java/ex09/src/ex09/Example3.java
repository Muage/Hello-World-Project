package ex09;

import java.io.*;
import java.util.StringTokenizer;

public class Example3 {
	public static void execute() {
		//파일에서 데이터 읽어오기
		File file = new File("c://data/java/address.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				String name = st.nextToken();
				String tel = st.nextToken();
				String address = st.nextToken();
				
				System.out.println("이름 : " + name);
				System.out.println("전화 : " + tel);
				System.out.println("주소 : " + address);
				System.out.println("");
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
