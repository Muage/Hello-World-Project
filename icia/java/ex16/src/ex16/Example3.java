package ex16;

import java.util.*;

public class Example3 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<StudentVO> array;
		ArrayList<DeptVO> darray;
		StudentDAO studentDAO = new StudentDAO();
		StudentVO studentVO = null;
		DeptDAO deptDAO = new DeptDAO();
		DeptVO deptVO = null;
		String sno;
		String sname;
		String maxNo;
		String dcode;
		String sel;
		int newNo;
		boolean run = true;
		boolean isFind = false;
		boolean success = false;
		
		System.out.println("************************ �� �� �� �� ************************");
		while(run) {
			System.out.println("������������������������������������������������������������������������������������������������������������������");
			System.out.println("1.�л���� �� 2.�л���� �� 3.�л����� �� 4.�л����� �� 5.�л���ȸ �� 0.����");
			System.out.println("������������������������������������������������������������������������������������������������������������������");
			
			int menu = Main.input("����");
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���θ޴��� �̵��մϴ�.\n");
				
				break;
				
			case 1:
				maxNo = studentDAO.maxNo();
				newNo = Integer.parseInt(maxNo) + 100;
				System.out.println("�й� : " + newNo);
				
				System.out.print("�̸� : ");
				sname = scanner.nextLine();
				if(sname.equals("")) {
					System.out.println("�л� ����� ��ҵǾ����ϴ�.\n");
					break;
				}
				
				System.out.println("");
				
				darray = deptDAO.list();
				for(DeptVO v : darray) {
					System.out.printf("%s | %s\n", v.getDcode(), v.getDname());
				}
				
				System.out.println("");
				
				do{
					System.out.print("�а��ڵ� : ");
					dcode = scanner.nextLine();
					if(dcode.equals("")) break;
					deptVO = deptDAO.read(dcode);
					if(deptVO.getDname() != null) isFind = true;
					if(isFind == false) System.out.println("�ùٸ� �а� �ڵ带 �Է����ּ���.\n"); 
				} while(isFind == false);
				
				if(dcode.equals("")) {
					System.out.println("�л� ����� ��ҵǾ����ϴ�.");
					break;
				}
				
				studentVO = new StudentVO();
				studentVO.setSno(String.valueOf(newNo));
				studentVO.setSname(sname);
				studentVO.setDcode(dcode);
				studentDAO.insert(studentVO);
				System.out.println(studentVO.getSname() + " �л��� ��ϵǾ����ϴ�.\n");
				
				break;
				
			case 2:
				array = studentDAO.list();
				for(StudentVO v : array) {
					System.out.printf("%s\t%s\t%s(%s)\n", v.getSno(), v.getSname(), v.getDcode(), v.getDname());
				}
				System.out.println("");
				
				break;
				
			case 3:
				System.out.print("������ �й� : ");
				sno = scanner.nextLine();
				if(sno.equals("")) {
					System.out.println("������ ��ҵǾ����ϴ�.\n");
					break;
				}
				studentVO = studentDAO.read(sno);
				if(studentVO.getSname() == null) {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
					break;
				}
				System.out.print("�̸� : " + studentVO.getSname() + ", ������ �̸� : ");
				sname = scanner.nextLine();
				if(!sname.equals("")) studentVO.setSname(sname);
				
				System.out.println("");
				
				darray = deptDAO.list();
				for(DeptVO v : darray) {
					System.out.printf("%s | %s\n", v.getDcode(), v.getDname());
				}
				
				System.out.println("");
				
				isFind = false;
				do {
					System.out.printf("�а� : %s(%s), ������ �а� : ", studentVO.getDcode(), studentVO.getDname());
					dcode = scanner.nextLine();
					if(dcode.equals("")) break;
					deptVO = deptDAO.read(dcode);
					if(deptVO.getDname() != null) isFind = true;
					if(isFind == false) System.out.println("�ش� �а��� �����ϴ�.");
				} while(isFind == false);
				
				if(!dcode.equals("")) studentVO.setDcode(dcode);
				studentDAO.update(studentVO);
				System.out.println("\n������ �Ϸ�Ǿ����ϴ�.\n");
				
				break;
				
			case 4:
				System.out.print("������ �й� : ");
				sno = scanner.nextLine();
				if(sno.equals("")) {
					System.out.println("������ ��ҵǾ����ϴ�.\n");
					break;
				}
				studentVO = studentDAO.read(sno);
				if(studentVO.getSname() == null) {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.\n");
					break;
				}
				System.out.printf("%s(%s)\n\n", studentVO.getSname(), studentVO.getDname());
				
				System.out.print("�����Ͻðڽ��ϱ�?");
				sel = scanner.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
					success = studentDAO.delete(sno);
					if(success) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
					} else {
						System.out.println("���� �����Ͱ� �����ؼ� ������ �� �����ϴ�.\n");
					}
				}
				
				break;
				
			case 5:
				System.out.print("��ȸ�� �й� : ");
				sno = scanner.nextLine();
				studentVO = studentDAO.read(sno);
				if(studentVO.getSname() == null) {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.\n");
					break;
				}
				System.out.println("�л� �̸� : " + studentVO.getSname());
				System.out.printf("�л� �а� : %s(%s)\n\n", studentVO.getDcode(), studentVO.getDname());				
				
				break;
				
			default:
				System.out.println("0~5�� �޴� �� �������ּ���.\n");
			}
		}
	}
}
