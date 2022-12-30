package ex16;

import java.util.*;

public class Example2 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<TypeVO> array;
		TypeDAO typeDAO = new TypeDAO();
		TypeVO typeVO = null;
		String tname;
		String tcode;
		String tdate;
		String maxCode;
		String newCode;
		boolean run = true;
		int code;
		
		String sel;
		boolean success = false;
		
		
		System.out.println("********************* Ÿ �� �� �� �� �� *********************");
		while(run) {
			System.out.println("������������������������������������������������������������������������������������������������������������������");
			System.out.println("1.Ÿ�Ե�� �� 2.Ÿ�Ը�� �� 3.Ÿ�Լ��� �� 4.Ÿ�Ի��� �� 5.Ÿ����ȸ �� 0.����");
			System.out.println("������������������������������������������������������������������������������������������������������������������");
			
			int menu = Main.input("����");
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���θ޴��� �̵��մϴ�.\n");
				
				break;
				
			case 1:
				maxCode = typeDAO.getMaxCode();
				code = Integer.parseInt(maxCode.substring(1)) + 10;
				newCode = "T" + code;
				System.out.println("Ÿ���ڵ� : " + newCode);
				System.out.print("Ÿ���̸� : ");
				tname = scanner.nextLine();
				if(tname.equals("")) {
					System.out.println("����� ��ҵǾ����ϴ�.");
					break;
				}
				typeVO = new TypeVO();
				typeVO.setTcode(newCode);
				typeVO.setTname(tname);
				typeDAO.insert(typeVO);
				System.out.println("���ο� Ÿ���� ��ϵǾ����ϴ�.");
				System.out.println("");
				
				break;
				
			case 2:
				array = typeDAO.list();
				System.out.println("�ڵ�\t�ڵ��\t\t������");
				for(TypeVO v : array) {
					System.out.printf("%s\t%s\t\t%s\n", v.getTcode(), v.getTname(), v.getTdate());
				}
				System.out.println("");
				
				break;
				
			case 3:
				System.out.print("������ Ÿ���ڵ� : ");
				tcode = scanner.nextLine();
				typeVO = typeDAO.read(tcode);
				if(typeVO.getTname() == null) {
					System.out.println("�ش� �ڵ尡 �������� �ʽ��ϴ�.\n");
					break;
				}
				System.out.print("Ÿ�� �̸� : " + typeVO.getTname() + ", ������ �̸� : ");
				tname = scanner.nextLine();
				if(!tname.equals("")) typeVO.setTname(tname);
				
				System.out.print("���� ���� : " + typeVO.getTdate() + ", ������ ���� : ");
				tdate = scanner.nextLine();
				if(!tdate.equals("")) typeVO.setTdate(tdate);
				
				typeDAO.update(typeVO);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
				
				break;
			
			case 4:
				System.out.print("������ Ÿ���ڵ� : ");
				tcode = scanner.nextLine();
				typeVO = typeDAO.read(tcode);
				if(typeVO.getTname() == null) {
					System.out.println("�ش� �ڵ尡 �������� �ʽ��ϴ�.\n");
					break;
				}
				System.out.println("Ÿ���̸� : " + typeVO.getTname());
				System.out.print("�����Ͻðڽ��ϱ�?");
				sel = scanner.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
					success = typeDAO.delete(tcode);
					if(success == true) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					} else {
						System.out.println("�������̺��� ������̾ ������ �� �����ϴ�.");
					}
				} else {
					System.out.println("������ ��ҵǾ����ϴ�.");
				}
				System.out.println("");
				
				break;
				
			case 5:
				System.out.print("Ÿ�� �ڵ� : ");
				tcode = scanner.nextLine();
				typeVO = typeDAO.read(tcode);
				if(typeVO.getTname() == null) {
					System.out.println("�ش� �ڵ尡 �������� �ʽ��ϴ�.");
					break;
				}
				System.out.println("Ÿ�� �̸� : " + typeVO.getTname());
				System.out.println("���� ���� : " + typeVO.getTdate());
				System.out.println("");
				
				break;
				
			default:
				System.out.println("0~5�� �޴� �� �������ּ���.\n");
			}
		}
	}
}
