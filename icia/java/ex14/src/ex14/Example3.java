package ex14;

import java.util.*;

public class Example3 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		CampDAO campDAO = new CampDAO();
		CampVO campVO = null;
		TypeDAO typeDAO = new TypeDAO();
		String[] type = {"���", "����ķ��", "ī���", "�۷���", "���"};
				
		boolean run = true;
		int switchMenu;
		
		while(run) {
			System.out.println("����������������������������������������������������������������������������������������������������");
			System.out.println("�� 1.�ü���������� �� 2.�ü����������� �� 0.�������� ���ư��� ��");
			System.out.println("����������������������������������������������������������������������������������������������������");
			
			switchMenu = Main.input("�޴��� �������ּ���.");
			
			switch(switchMenu) {
			case 0:
				run = false;
				
				break;
				
			case 1:
				int code = Main.input("ķ���� ��ȣ�� �Է����ּ���.");
				campVO = campDAO.read(code);
				if(campVO.getName() == null) {
					System.out.println("�Է��Ͻ� ��ȣ�� ��ϵ� ķ������ �����ϴ�.\n");
					break;
				}
				System.out.println("ķ���� �̸� : " + campVO.getName());
				System.out.println("ķ���� �ּ�: " + campVO.getAddress());
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
				ArrayList<String> tarray = typeDAO.list(code);
				ArrayList<String> check = new ArrayList<>();
				
				for(int i=0; i<type.length; i++) {
					
					boolean isFind = false;
					for(String t : tarray) {
						if(t.equals(type[i])) isFind = true;
					}
					if(isFind == true) {
							check.add("O");
					} else {
						check.add("X");
					}
					System.out.printf("[%d] %s \t[ %s ]\n", i, type[i], check.get(i));
				}
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
				int sel = Main.input("������ �������ּ���.");
				if(sel == 0) break;
				if(check.get(sel).equals("O")) {
					System.out.println("�̹� ��ϵǾ� �ִ� �����Դϴ�.\n");
					break;
				}
				//���� ���
				typeDAO.insert(code, type[sel]);
				System.out.println(type[sel] + " ������ ��ϵǾ����ϴ�.\n");
				
				break;
				
			case 2:
				code = Main.input("ķ���� ��ȣ�� �Է����ּ���.");
				campVO = campDAO.read(code);
				if(campVO.getName() == null) {
					System.out.println("�ش� ķ������ �����ϴ�.\n");
					break;
				}
				System.out.println("ķ���� �̸�: " + campVO.getName());
				System.out.println("ķ���� �ּ�: " + campVO.getAddress());
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
				tarray = typeDAO.list(code);
				check = new ArrayList<>();
				
				
				for(int i=0; i<type.length; i++) {
					//�ü��� ���� Ȯ��
					
					boolean isFind = false;
					for(String t : tarray) {
						if(type[i].equals(t)) isFind = true;
					}
					if(isFind == true) {
						check.add("O");
					} else {
						check.add("X");
					}
					System.out.printf("[%d] %s \t[ %s ]\n", i, type[i], check.get(i));
				}
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
				sel = Main.input("������ �������ּ���.");
				if(sel == 0) break;
				if(check.get(sel).equals("X")) {
					System.out.println("��ϵ��� ���� �����Դϴ�.\n");
					break;
				}
				typeDAO.delete(code, type[sel]);
				System.out.println(type[sel] + "������ �����Ǿ����ϴ�.\n");
				
				break;
			
			default:
				System.out.println("0~2�� �� �������ּ���.\n");
			}
		}
	}
}
