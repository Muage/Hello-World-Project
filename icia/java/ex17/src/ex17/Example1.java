package ex17;

import java.util.*;

public class Example1 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		FacilityDAO facilityDAO = new FacilityDAO();
		FacilityVO facilityVO;
		CampDAO campDAO = new CampDAO();
		CampVO campVO;
		ArrayList<FacilityVO> farray;
		ArrayList<FacilityVO> allArray;
		String newCode;
		String fname;
		String fcode;
		String sel;
		String code;
		boolean run = true;
		boolean success;
		boolean find;
		int menu;
		
		while(run) {
			System.out.println("********************* �� �� �� �� �� *********************");
			System.out.println("��������������������������������������������������������������������������������������������������������������");
			System.out.println("1.��� �� 2.��� �� 3.���� �� 4.���(ķ����) �� 5.����(ķ����) �� 0.����");
			System.out.println("��������������������������������������������������������������������������������������������������������������");
			
			System.out.print("�޴��� �������ּ���. : ");
			menu = scanner.nextInt(); scanner.nextLine();
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				
				break;
				
			case 1:
				newCode = facilityDAO.getNewCode();
				System.out.println("�ü����ڵ� : " + newCode);
				System.out.print("�ü����̸� : ");
				fname = scanner.nextLine();
				if(fname.equals("")) {
					System.out.println("�ü��� ����� ��ҵǾ����ϴ�.\n");
					break;
				}
				//���ο� �ü��� ���
				facilityDAO.insert(newCode, fname);
				System.out.println("\n���ο� �ü����� ��ϵǾ����ϴ�.\n");
				
				break;
				
			case 2:
				farray = facilityDAO.list();
				System.out.println("\n�ü����ڵ�\t�� �ü����̸�");
				System.out.println("��������������������������������������������������������������������������������������������������������������");
				for(FacilityVO f : farray) {
					System.out.printf("%s\t�� %s\n", f.getFcode(), f.getFname());
				}
				System.out.println("");
				
				break;
				
			case 3:
				System.out.print("������ �ü��� �ڵ� : ");
				fcode = scanner.nextLine();
				if(fcode.equals("")) {
					System.out.println("�ü��� ������ ��ҵǾ����ϴ�.\n");
					break;
				}
				facilityVO = facilityDAO.read(fcode);
				if(facilityVO.getFname() == null) {
					System.out.println("�ش� �ü����� �������� �ʽ��ϴ�.\n");
					break;
				}
				System.out.println("�ü��� �̸� : " + facilityVO.getFname());
				System.out.print("�ü����� �����Ͻðڽ��ϱ�?");
				sel = scanner.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
					success = facilityDAO.delete(fcode);
					if(success == true) {
						System.out.println("�ü��� ������ �Ϸ�Ǿ����ϴ�.\n");
					} else {
						System.out.println("�� �ü����� ������� ķ������ �ֽ��ϴ�.\n");
					}
				} else {
					System.out.println("�ü��� ������ ��ҵǾ����ϴ�.\n");
				}
				 
				break;
				
			case 4:
				System.out.print("ķ���� �ڵ� : ");
				code = scanner.nextLine();
				if(code.equals("")) {
					System.out.println("ķ���� �ü��� ����� ��ҵǾ����ϴ�.\n");
					break;
				}
				campVO = campDAO.read(code);
				if(campVO.getCname() == null) {
					System.out.println("�ش� ķ������ �������� �ʽ��ϴ�.\n");
					break;
				}
				System.out.println("\nķ�����̸�\t�� ķ�����ּ�");
				System.out.println("��������������������������������������������������������������������������������������������������������������");
				System.out.printf("%s\t�� %s\n\n", campVO.getCname(), campVO.getAddress());
				
				farray = facilityDAO.list(code);
				System.out.println("�ü����ڵ�\t�� �ü����̸�\t[��ġ(��) / �̼�ġ(��)]");
				System.out.println("��������������������������������������������������������������������������������������������������������������");
				for(FacilityVO f : farray) {
					System.out.printf("�� %s\t�� %s\n", f.getFcode(), f.getFname());
				}
				allArray = facilityDAO.list();
				for(FacilityVO a : allArray) {
					find = false;
					for(FacilityVO f : farray) {
						if(a.getFcode().equals(f.getFcode())) find = true;
					}
					if(find == false) {
						System.out.printf("�� %s\t�� %s\n", a.getFcode(), a.getFname());
					}
				}
				System.out.println("");
				
				do {
					System.out.print("�ü����ڵ� : ");
					fcode = scanner.nextLine();
					if(fcode.equals("")) {
						System.out.println("�Էµ� �ڵ尡 ���� ķ���� �ü��� ����� ����Ǿ����ϴ�.\n");
						break;
					}
					facilityVO = facilityDAO.read(fcode);
					if(facilityVO.getFname() == null) {
						System.out.println("��ϵ��� ���� �ü����Դϴ�.\n");
						break;
					}
					facilityVO = facilityDAO.read(code, fcode);
					if(facilityVO.getFname() == null) {
						facilityVO.setCode(code);
						facilityVO.setFcode(fcode);
						facilityDAO.insert(facilityVO);
						System.out.println("ķ���� �ü��� ����� �Ϸ�Ǿ����ϴ�.\n");
					} else {
						System.out.println(facilityVO.getFname() + " �ü����� �̹� ��ϵǾ� �ֽ��ϴ�.\n");
					}
				}while(true);
				
				break;
				
			case 5:
				System.out.print("ķ�����ڵ� : ");
				code = scanner.nextLine();
				if(code.equals("")) {
					System.out.println("ķ���� �ü��� ������ ��ҵǾ����ϴ�.\n");
					break;
				}
				campVO = campDAO.read(code);
				if(campVO.getCname() == null) {
					System.out.println("�ش� ķ������ �������� �ʽ��ϴ�.\n");
					break;
				}
				//ķ���� ���� ���
				System.out.println("\nķ�����̸�\t�� ķ�����ּ�");
				System.out.println("��������������������������������������������������������������������������������������������������������������");
				System.out.printf("%s\t�� %s\n\n", campVO.getCname(), campVO.getAddress());
				
				//ķ���忡 ��ġ�� �ü���
				farray = facilityDAO.list(code);
				System.out.println("�ü����ڵ�\t�� �ü����̸�\t[��ġ(��)]");
				System.out.println("��������������������������������������������������������������������������������������������������������������");
				for(FacilityVO f : farray) {
					System.out.printf("�� %s\t�� %s\n", f.getFcode(), f.getFname());
				}
				System.out.println("");
				
				do {
					System.out.print("�ü����ڵ� : ");
					fcode = scanner.nextLine();
					if(fcode.equals("")) {
						System.out.println("�Էµ� �ڵ尡 ���� ķ���� �ü��� ������ ����Ǿ����ϴ�.\n");
						break;
					}
					facilityVO = facilityDAO.read(code, fcode);
					if(facilityVO.getFname() == null) {
						System.out.println("�ش� �ü����� ��ġ�Ǿ� ���� �ʽ��ϴ�.\n");
					} else {
						facilityDAO.delete(code, fcode);
						System.out.println(facilityVO.getFname() + " �ü����� �����Ǿ����ϴ�.\n");
					}
				} while(true);
				
				break;
				
			default:
				System.out.println("0~5�� �޴� �� �������ּ���.\n");
			}
		}
	}
}
