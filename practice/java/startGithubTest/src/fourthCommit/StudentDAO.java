package fourthCommit;

import java.io.*;
import java.util.*;

public class StudentDAO {
	File file = new File("C:/Data/java/ex13/student.txt");
	StudentVO studentVO  = new StudentVO();
	ArrayList<StudentVO> array = new ArrayList<>();
	
	//������ �й� ��������
	public int getLastNo() {
		int no = 0;
		BufferedReader reader;
		String line = "";
		StringTokenizer st;
		
		try {	//������ �ڵ�
			reader = new BufferedReader(new FileReader(file));	//���� ������ �Է� �޾� reader�� ����
			
			while((line = reader.readLine()) != null) {	//reader�� ����� ������ �� �� �о� line�� �������� �� null�� �ƴ� ���� �ݺ�
				st = new StringTokenizer(line, "|");	//line�� ��� ������ "|" �������� ������ �ν� 
				no = Integer.parseInt(st.nextToken());	//st�� ���� ���� no�� ����
			}
		} catch(Exception e) {	//try���� ���ܰ� �߻��� ����� �ڵ�
			System.out.println("������ ��ȣ�� Ȯ�����ּ���." + e.toString());
		}
		return no;	//int Ÿ�� ��ȯ
	}
	
	//�л� �Է�
	public void insert(StudentVO vo) {
		try{	//������ �ڵ�
			FileWriter writer = new FileWriter(file, true);	//file�� �̾���� true ����
			
			writer.write(vo.getNo() + "|" + vo.getName() + "|" + vo.getAddress() + "\n");	//file�� ������ ���� ����
			writer.flush();	//���� ������ ������
			writer.close();
			
		} catch(Exception e) {	//try���� ���ܰ� �߻��� ����� �ڵ�
			System.out.println("�л� �Է��� Ȯ�����ּ���." + e.toString());
		}
	}
	
	//�л� ��ȸ
	public StudentVO read(int no) {
		BufferedReader reader;
		String line = "";
		StringTokenizer st;
		try {	//������ �ڵ�
			reader = new BufferedReader(new FileReader(file));	//���� ������ �Է� �޾� reader�� ����
			line = "";
			
			while((line = reader.readLine()) != null) {	//reader�� ����� ������ �� �� �о� line�� �������� �� null�� �ƴ� ���� �ݺ�
				st = new StringTokenizer(line, "|");	//line�� ��� ������ "|" �������� ������ �ν� 
				int lineNo = Integer.parseInt(st.nextToken());	//st�� ���� ���� lineNo�� ����
				if(no == lineNo) {	//���� no�� lineNo�� ���� ������ ������ �ڵ� (int ���̶� .equals �Ƚᵵ ��)
					studentVO.setNo(lineNo);
					studentVO.setName(st.nextToken());
					studentVO.setAddress(st.nextToken());
					
					break;
				}
			}
		} catch(Exception e) {	//try���� ���ܰ� �߻��� ����� �ڵ�
			System.out.println("�л� ��ȸ�� Ȯ�����ּ���." + e.toString());
		}
		return studentVO;
	}
	
	//�л� ���
	public ArrayList<StudentVO> list(){
		BufferedReader reader;
		String line = "";
		StringTokenizer st;
		StudentVO vo;
		try {
			reader = new BufferedReader(new FileReader(file));	//���� ������ �Է� �޾� reader�� ����
			line = "";
			
			while((line = reader.readLine()) != null) {	//reader�� ����� ������ �� �� �о� line�� �������� �� null�� �ƴ� ���� �ݺ�
				st = new StringTokenizer(line, "|");	//line�� ��� ������ "|" �������� ������ �ν� 
				vo = new StudentVO();
				
				vo.setNo(Integer.parseInt(st.nextToken()));		//st�� ���� ���� �� vo.set �� ����
				vo.setName(st.nextToken());
				vo.setAddress(st.nextToken());
				
				array.add(vo);	//���õ� vo array�� �߰�
			}
		} catch(Exception e) {
			System.out.println("�л� ����� Ȯ�����ּ���." + e.toString());
		}
		
		return array;
	}
	
}
