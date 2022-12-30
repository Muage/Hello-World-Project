package ex14;

import java.util.*;

public class Example2 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		CampDAO campDAO = new CampDAO();
		CampVO campVO = null;
		FacilDAO facilDAO = new FacilDAO();
				
		boolean run = true;
		int switchMenu;
		String[] facility = {"���", "ȭ���", "����", "����", "��������", "������", "������", "������"};
		
		while(run) {
			System.out.println("����������������������������������������������������������������������������������������");
			System.out.println("�� 1.�ü������ �� 2.�ü������� �� 0.�������� ���ư��� ��");
			System.out.println("����������������������������������������������������������������������������������������");
			
			switchMenu = Main.input("�޴��� �������ּ���.");
			
			switch(switchMenu) {
			case 0:
				run = false;
				
				break;
				
			case 1:
				int code = Main.input("ķ���� ��ȣ�� �Է����ּ���.");
				campVO = campDAO.read(code);
				if(campVO.getName() == null) {
					System.out.println("�ش� ķ������ �����ϴ�.\n");
					break;
				}
				System.out.println("ķ���� �̸�: " + campVO.getName());
				System.out.println("ķ���� �ּ�: " + campVO.getAddress());
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
				ArrayList<String> farray = facilDAO.list(code);
				ArrayList<String> check = new ArrayList<>();
				
				for(int i=0; i<facility.length; i++) {
					
					//�ü��� ���� Ȯ��
					boolean isFind = false;
					for(String f : farray) {
						if(facility[i].equals(f)) isFind = true;
					}
					if(isFind == true) {
						check.add("O");
					} else {
						check.add("X");
					}
					System.out.printf("[%d] %s \t[ %s ]\n", i, facility[i], check.get(i));
				}
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
				int sel = Main.input("�ü����� �������ּ���.");
				if(sel == 0) break;
				if(check.get(sel).equals("O")) {
					System.out.println("�̹� ��ϵǾ� �ִ� �ü����Դϴ�.\n");
					break;
				}
				facilDAO.insert(code, facility[sel]);
				System.out.println(facility[sel] + "��(��) ��ϵǾ����ϴ�.\n");
				
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
				farray = facilDAO.list(code);
				check = new ArrayList<>();
				
				
				for(int i=0; i<facility.length; i++) {
					//�ü��� ���� Ȯ��
					
					boolean isFind = false;
					for(String f : farray) {
						if(facility[i].equals(f)) isFind = true;
					}
					if(isFind == true) {
						check.add("O");
					} else {
						check.add("X");
					}
					System.out.printf("[%d] %s \t[ %s ]\n", i, facility[i], check.get(i));
				}
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
				sel = Main.input("�ü����� �������ּ���.");
				if(sel == 0) break;
				if(check.get(sel).equals("X")) {
					System.out.println("��ϵ��� ���� �ü����Դϴ�.\n");
					break;
				}
				facilDAO.delete(code, facility[sel]);
				System.out.println(facility[sel] + "��(��) �����Ǿ����ϴ�.\n");
					
				break;
				
			default:
				System.out.println("0~2�� �� �������ּ���.\n");
				
			}
		}
	}
}
