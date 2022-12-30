package ex17;

import java.util.*;

public class Example2 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		TypeDAO typeDAO = new TypeDAO();
		TypeVO typeVO;
		CampDAO campDAO = new CampDAO();
		CampVO campVO;
		ArrayList<TypeVO> tarray;
		ArrayList<TypeVO> allArray;
		String menu;
		String newCode;
		String tname;
		String tcode;
		String code;
		boolean run = true;
		boolean find;
		int qnt;
		
//		FacilityDAO facilityDAO = new FacilityDAO();
//		FacilityVO facilityVO;
//		ArrayList<FacilityVO> farray;
//		String sel;
//		boolean success;

		
		while(run) {
			System.out.println("********************** �� �� �� �� **********************");
			System.out.println("��������������������������������������������������������������������������������������������������������������");
			System.out.println("1.��� �� 2.��� �� 3.���� �� 4.���(ķ����) �� 5.����(ķ����) �� 0.����");
			System.out.println("��������������������������������������������������������������������������������������������������������������");
			
			System.out.print("�޴��� �������ּ���. : ");
			menu = scanner.nextLine();
			switch(menu) {
			case "0":
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				
				break;
				
			case "1":
				newCode = typeDAO.getNewCode();
				System.out.println("�����ڵ� : " + newCode);
				System.out.print("�����̸� : ");
				tname = scanner.nextLine();
				if(tname.equals("")) {
					System.out.println("�Էµ� �����̸��� ���� ����� ��ҵǾ����ϴ�.\n");
				}
				typeDAO.insert(newCode, tname);
				System.out.println("���ο� ������ ��ϵǾ����ϴ�.\n");
				
				break;
				
			case "2":
				System.out.println("\n�����ڵ�\t�� �����̸�");
				System.out.println("��������������������������������������������������������������������������������������������������������������");
				for(TypeVO t : typeDAO.list()) {
					System.out.printf("%s\t�� %s\n", t.getTcode(), t.getTname());
				}
				System.out.println("");
				
				break;
				
			case "3":
				System.out.print("������ �����ڵ� : ");
				tcode = scanner.nextLine();
				if(tcode.equals("")) {
					System.out.println("�Էµ� �����ڵ尡 ���� ������ ��ҵǾ����ϴ�.\n");
					break;
				}
				typeVO = typeDAO.read(tcode);
				if(typeVO.getTname() == null) {
					System.out.println("������ �����ڵ尡 �������� �ʽ��ϴ�.\n");
					break;
				}
				//����
				typeDAO.delete(tcode);
//				if(typeDAO.delete(tcode)) {
//					System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.\n");
//				} else {
//					System.out.println("�� ������ ������� ķ������ �־� ������ �� �����ϴ�.\n");
//				}
				
				break;
				
			case "4":
				System.out.print("ķ�����ڵ� : ");
				code = scanner.nextLine();
				if(code.equals("")) {
					System.out.println("�Էµ� ķ�����ڵ尡 ���� ����� ��ҵǾ����ϴ�.\n");
					break;
				}
				campVO = campDAO.read(code);
				if(campVO.getCname() == null) {
					System.out.println("�ش� ķ������ �������� �ʽ��ϴ�.\n");
					break;
				}
				//ķ���� ���� ���
				System.out.println("\nķ�����̸�\t\tķ�����ּ�");
				System.out.printf("%s\t\t%s\n\n", campVO.getCname(), campVO.getAddress());
				
				//���� ���
				System.out.println("[��ϵ� ����]");
				tarray = typeDAO.list(code);
				for(TypeVO t : tarray) {
					System.out.printf("�� %s(%s)     ", t.getTname(), t.getTcode());
				}
				System.out.println("\n");
				
				System.out.println("[��ϵ��� ���� ����]");
				allArray = typeDAO.list();
				for(TypeVO a : allArray) {
					typeVO = typeDAO.read(code, a.getTcode());
					if(typeVO.getTname() == null) System.out.printf("�� %s(%s)     ", a.getTname(), a.getTcode());
				}
				System.out.println("\n");
				
				do {
					System.out.print("�����ڵ� : ");
					tcode = scanner.nextLine();
					if(tcode.equals("")) break;
					typeVO = typeDAO.read(tcode);
					if(typeVO.getTname() == null) {
						System.out.println("���� �����ڵ� �Դϴ�.\n");
					} else {
						typeVO = typeDAO.read(code, tcode);
						if(typeVO.getTname() == null) {
							System.out.print("���� : ");
							qnt = scanner.nextInt(); scanner.nextLine();
							
							typeVO = new TypeVO();
							typeVO.setCode(code);
							typeVO.setTcode(tcode);
							typeVO.setQnt(qnt);
							
							typeDAO.insert(typeVO);
							System.out.println("ķ���忡 ���ο� ������ �ԷµǾ����ϴ�.\n");
						} else {
							System.out.println("�̹� ��ϵ� �����Դϴ�.\n");
						}
					}
				} while(true);
				
				break;
				
			case "5":
				System.out.print("ķ�����ڵ� : ");
				code = scanner.nextLine();
				if(code.equals("")) {
					System.out.println("�Էµ� ķ�����ڵ尡 ���� ������ ��ҵǾ����ϴ�.\n");
				}
				campVO = campDAO.read(code);
				if(campVO.getCname() == null) {
					System.out.println("ķ������ �������� �ʽ��ϴ�.\n");
					break;
				}
				//ķ���� ���� ���
				System.out.println("\nķ�����̸�\t\tķ�����ּ�");
				System.out.printf("%s\t\t%s\n\n", campVO.getCname(), campVO.getAddress());
				//���� ���
				System.out.println("[��ϵ� ����]");
				tarray = typeDAO.list(code);
				for(TypeVO t : tarray) {
					System.out.printf("�� %s(%s)     ", t.getTname(), t.getTcode());
				}
				System.out.println("\n");
				
				do {
					System.out.print("������ �����ڵ� : ");
					tcode = scanner.nextLine();
					if(tcode.equals("")) {
						System.out.println("�Էµ� �����ڵ尡 ���� ������ ��ҵǾ����ϴ�.\n");
						break;
					}
					typeVO = typeDAO.read(code, tcode);
					if(typeVO.getTname() == null) {
						System.out.println("��ϵ��� ���� �����Դϴ�.\n");
					} else {
						typeDAO.delete(code, tcode);
						System.out.println("ķ������ ������ �����Ǿ����ϴ�.\n");
					}	
				} while(true);
				
				break;
				
			default:
				System.out.println("0~5�� �޴� �� �������ּ���.\n");
			}
		}
	}
}
