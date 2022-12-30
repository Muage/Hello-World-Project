package ex14;

import java.io.*;
import java.util.*;

public class CampDAO {
	File file = new File("C:/Data/java/ex14/camp.txt");
	
	//�������ڵ� ��������
	public int getLastCode() {
		int code = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			
			while((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				code = Integer.parseInt(st.nextToken());
			}
			reader.close();
		} catch(Exception e) {
			System.out.println("������ �ڵ带 Ȯ�����ּ���. : " + e.toString());
		}
		return code;
	}
	//ķ������
	public void insert(CampVO campVO) {
		try {
			FileWriter writer = new FileWriter(file, true);
			
			writer.write(campVO.getCode() + "|" + campVO.getName() + "|" + campVO.getAddress() + "\n");
			writer.flush();
			writer.close();
		} catch (Exception e) {
			System.out.println("ķ���� ����� Ȯ�����ּ���. : " + e.toString());
		}
	}
	
	//ķ������ȸ
	public CampVO read(int code) {
		CampVO campVO = new CampVO();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			
			while((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				int lineCode = Integer.parseInt(st.nextToken());
				
				if(code == lineCode) {
					campVO.setCode(lineCode);
					campVO.setName(st.nextToken());
					campVO.setAddress(st.nextToken());
				}
			}
		} catch(Exception e) {
			System.out.println("ķ���� ��ȸ�� Ȯ�����ּ���. : " + e.toString());
		}
		return campVO;
	}
	
	//ķ������
	public ArrayList<CampVO> list(){
		ArrayList<CampVO> array = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			
			while((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				CampVO campVO = new CampVO();
				
				campVO.setCode(Integer.parseInt(st.nextToken()));
				campVO.setName(st.nextToken());
				campVO.setAddress(st.nextToken());
				
				array.add(campVO);
			}
		} catch(Exception e) {
			System.out.println("ķ���� ����� Ȯ�����ּ���. : " + e.toString());
		}
		return array;
	}
}
