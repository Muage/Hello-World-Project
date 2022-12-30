package ex14;

import java.io.*;
import java.util.*;

public class TypeDAO {
	File file = new File("C:/Data/java/ex14/type.txt");
	
	//유형 삭제
	public void delete(int code, String type) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			String lines = "";
			
			while((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				int lineCode = Integer.parseInt(st.nextToken());
				String lineType = st.nextToken();
				if(lineCode != code || !lineType.equals(type)) {
					lines = lines + line + "\n";
				}
			}
			FileWriter writer = new FileWriter(file, false);
			
			writer.write(lines);
			writer.flush();
			writer.close();
		} catch(Exception e) {
			System.out.println("유형 삭제를 확인해주세요. : " + e.toString());
		}
	}
	
	//유형 등록
		public void insert(int code, String type) {
			try {
				FileWriter writer = new FileWriter(file, true);
				
				writer.write(code + "|" + type + "\n");
				writer.flush();
				writer.close();
			} catch(Exception e) {
				System.out.println("유형 등록을 확인해주세요. : " + e.toString());
			}
		}
	
	//특정 캠핑장의 Type 목록
	public ArrayList<String> list(int code) {
		ArrayList<String> array = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			
			while((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				int lineCode = Integer.parseInt(st.nextToken());
				if(code == lineCode) {
					array.add(st.nextToken());
				}
			}
		} catch(Exception e) {
			System.out.println("캠핑장 목록을 확인해주세요. : " + e.toString());
		}
		
		return array;
	}
}
