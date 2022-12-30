package ex14;

import java.io.*;
import java.util.*;

public class FacilDAO {
	File file = new File("C:/Data/java/ex14/facil.txt");
	
	//�ü��� ����
	public void delete(int code, String facil) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			String lines = "";
			
			while((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				int lineCode = Integer.parseInt(st.nextToken());
				String lineFacil = st.nextToken();
				if(lineCode != code || !lineFacil.equals(facil)) {
					lines = lines + line + "\n";
				}
			}
			FileWriter writer = new FileWriter(file, false);
			
			writer.write(lines);
			writer.flush();
			writer.close();
		} catch(Exception e) {
			System.out.println("�ü��� ������ Ȯ�����ּ���. : " + e.toString());
		}
	}
	
	//�ü��� ���
	public void insert(int code, String facil) {
		try {
			FileWriter writer = new FileWriter(file, true);
			
			writer.write(code + "|" + facil + "\n");
			writer.flush();
			writer.close();
		} catch(Exception e) {
			System.out.println("�ü��� ����� Ȯ�����ּ���. : " + e.toString());
		}
	}
	
	//Ư�� ķ������ �ü��� ���
	public ArrayList<String> list(int code){
		ArrayList<String> array = new ArrayList<String>();
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
			System.out.println("�ü��� ����� Ȯ�����ּ���. : " + e.toString());
		}
		
		return array;
	}
}
