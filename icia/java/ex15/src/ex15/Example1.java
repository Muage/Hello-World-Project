package ex15;

import java.util.*;

public class Example1 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		DeptDAO deptDAO = new DeptDAO();
		DeptVO deptVO = null;
		boolean run = true;
		
		System.out.println("*************** �� �� �� �� �� �� ***************");
		while(run) {
			System.out.println("��������������������������������������������������������������������������������������������");
			System.out.println("1.�ڵ��� �� 2.�ڵ��� �� 3.�ڵ���� �� 4.�ڵ���� �� 0.����");
			System.out.println("��������������������������������������������������������������������������������������������");
			
			int menu = Main.input("����");
			switch(menu) {
			case 0:
				run = false;
				System.out.println("������������ �̵��մϴ�.\n");
				break;
				
			case 1:
				String mcode = deptDAO.getMaxCode();
				int newCode = Integer.parseInt(mcode) + 10;
				System.out.println("�а��ڵ� : " + newCode);
				System.out.print("�а��� : ");
				String codeName = scanner.nextLine();
				
				deptVO = new DeptVO();
				deptVO.setCode(String.valueOf(newCode));
				deptVO.setDname(codeName);
				deptDAO.insert(deptVO);
				System.out.println("���ο� �а��� ��ϵǾ����ϴ�.\n");
				
				break;
				
			case 2:
				System.out.println("�а��ڵ�\t�а���");
				ArrayList<DeptVO> array = deptDAO.list();
				for(DeptVO v : array) {
					System.out.printf("%s\t%s\n", v.getCode(), v.getDname());
				}
				System.out.println("");
				
				break;
				
			case 3:
				break;
				
			case 4:
				break;
				
			default:
				System.out.println("0~4�� �޴� �� �������ּ���.\n");
			}
		}
	}
}
