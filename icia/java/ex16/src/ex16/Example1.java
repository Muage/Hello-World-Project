package ex16;

import java.util.*;

public class Example1 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		DeptDAO deptDAO = new DeptDAO();
		DeptVO deptVO = null;
		String maxCode;
		String newCode;
		String dname;
		String dcode;
		String sel;
		boolean run = true;
		boolean success = false;
		int code;
		
		System.out.println("********************* �� �� �� �� �� �� *********************");
		while(run) {
			System.out.println("������������������������������������������������������������������������������������������������������������������");
			System.out.println("1.�а���� �� 2.�а���� �� 3.�а����� �� 4.�а����� �� 5.�а���ȸ �� 0.����");
			System.out.println("������������������������������������������������������������������������������������������������������������������");
			
			int menu = Main.input("����");
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���θ޴��� �̵��մϴ�.\n");
				
				break;
				
			case 1:
				maxCode = deptDAO.getMaxCode();
				code = Integer.parseInt(maxCode.substring(1)) + 10;
				newCode = "D" + code;
				System.out.println("�а��ڵ� : " + newCode);
				System.out.print("�а��̸� : ");
				dname = scanner.nextLine();				
				
				System.out.print("�а��� ����Ͻðڽ��ϱ�?");
				sel = scanner.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
					deptVO = new DeptVO();
					deptVO.setDcode(newCode);
					deptVO.setDname(dname);
					deptDAO.insert(deptVO);
					System.out.println("���ο� �а��� ��ϵǾ����ϴ�.");
				} else {
					System.out.println("����� ��ҵǾ����ϴ�.");
				}
				System.out.println("");
				
				break;
				
			case 2:
				ArrayList<DeptVO> array = deptDAO.list();
				for(DeptVO v : array) {
					System.out.printf("%s\t%s\n", v.getDcode(), v.getDname());
				}
				System.out.println("");
				
				break;
				
			case 3:
				System.out.print("������ �а��ڵ带 �Է����ּ���. : ");
				dcode = scanner.nextLine();
				deptVO = deptDAO.read(dcode);
				if(deptVO.getDname() == null) {
					System.out.println("�ش� �а��� �������� �ʽ��ϴ�.");
				} else {
					System.out.print("�а��� : " + deptVO.getDname() + ", ������ �а��� : ");
					dname = scanner.nextLine();
//					if(dname.equals("")) deptVO.setDname(dname);
					if(dname.equals("")) {
						System.out.println("������ ��ҵǾ����ϴ�.");
					} else {
						System.out.print("�����Ͻðڽ��ϱ�?");
						sel = scanner.nextLine();
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							deptVO.setDcode(dcode);
							deptVO.setDname(dname);
							deptDAO.update(deptVO);
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						} else {
							System.out.println("������ ��ҵǾ����ϴ�.");
						}
					}
				}
				System.out.println("");
				
				break;
			
			case 4:
				System.out.print("������ �а��ڵ带 �Է����ּ���. : ");
				dcode = scanner.nextLine();
				deptVO = deptDAO.read(dcode);
				if(deptVO.getDname() == null) {
					System.out.println("�ش� �а��� �������� �ʽ��ϴ�.");
				} else {	//�ش��а��� �����ϴ� ���
					System.out.println("�а��̸� : " + deptVO.getDname());
					System.out.print(deptVO.getDname() + "���� �����Ͻðڽ��ϱ�?");
					sel = scanner.nextLine();
					if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
						success = deptDAO.delete(dcode);
						if(success == true) {
							System.out.println(deptVO.getDname() + "���� �����Ǿ����ϴ�.");
						} else {
							System.out.println("�ش� �а��� �л��� �־� ������ �� �����ϴ�.");
						}
					} else {
						System.out.println("������ ��ҵǾ����ϴ�.");
					}
				}
				System.out.println("");
				
				break;
				
			case 5:
				System.out.print("�а��ڵ� : ");
				dcode = scanner.nextLine();
				deptVO = deptDAO.read(dcode);
				if(deptVO.getDname() == null) {
					System.out.println("�ش� �а��� �������� �ʽ��ϴ�.");
				} else {
					System.out.println("�а��̸� : " + deptVO.getDname());
				}
				System.out.println("");
				
				break;
				
			default:
				System.out.println("0~5�� �޴� �� �������ּ���.\n");
			}
		}
	}
}
