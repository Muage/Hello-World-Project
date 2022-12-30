package ex14;

import java.util.*;

public class Example1 {
	public static void execute() {
		Scanner scanner = new Scanner(System.in);
		CampDAO campDAO = new CampDAO();
		CampVO campVO = null;
		TypeDAO typeDAO = new TypeDAO();
		FacilDAO facilDAO = new FacilDAO();
				
		boolean run = true;
		String switchMenu;
		int newCode;
		int code;
		
		while(run) {
			System.out.println("\n��������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��\t\t            ķ������� ���α׷�            \t\t     ��");
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("�� 1.ķ������ �� 2.ķ������ȸ �� 3.ķ������ �� 4.�ü������� �� 5.�������� �� 0.���� ��");
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
			
			System.out.print("���Ͻô� ������ �������ּ���. > ");
			switchMenu = scanner.nextLine();
			
			switch(switchMenu) {
			case "0":
				run = false;
				System.out.println("���α׷��� �����մϴ�.");
				
				break;
				
			case "1":
				newCode = campDAO.getLastCode() + 100;
				System.out.println("ķ���� �ڵ�: " + newCode);
				campVO = new CampVO();
				campVO.setCode(newCode);
				System.out.print("ķ���� �̸��� �Է����ּ���. : ");
				campVO.setName(scanner.nextLine());
				
				System.out.print("ķ���� �ּҸ� �Է����ּ���. : ");
				campVO.setAddress(scanner.nextLine());
				
				//���Ͽ� ����
				campDAO.insert(campVO);
				System.out.printf("%s ķ������ ��ϵǾ����ϴ�.\n", campVO.getName());

				break;
				
			case "2":
				code = Main.input("��ȸ�� �ڵ带 �Է����ּ���.");
				campVO = campDAO.read(code);
				if(campVO.getName() == null) {
					System.out.println("�ش� ķ������ �����ϴ�.");
				} else {
					System.out.println("ķ���� �̸�: " + campVO.getName());
					System.out.println("ķ���� �ּ�: " + campVO.getAddress());
					System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
					
					//ķ���� Type ���
					ArrayList<String> tarray = typeDAO.list(code);
					System.out.print("ķ���� �ɼ�:");
					if(tarray.size() == 0) System.out.println("����");
					for(String t : tarray) {
						System.out.printf(" %s |", t);
					}
					System.out.println("");
					
					//ķ���� �ü��� ���
					ArrayList<String> farray = facilDAO.list(code);
					System.out.print("ķ���� �ü���:");
					if(farray.size() == 0) System.out.println("����");
					for(String f : farray) {
						System.out.printf(" %s |", f);
					}
					System.out.println("");
				}
					
				break;
				
			case "3":
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
				System.out.println("�ڵ�\t\tķ�����̸�\t\tķ�����ּ�");
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
				ArrayList<CampVO> carray = campDAO.list();
				for(CampVO c : carray) {
					System.out.printf("%d\t\t%s\t\t%s\n", c.getCode(), c.getName(), c.getAddress());
					
					//�� ķ���庰 Type ���
					ArrayList<String> tarray = typeDAO.list(c.getCode());
					System.out.println("[ķ���� �ɼ�]");
					if(tarray.size() == 0) System.out.println("����");
					for(String t : tarray) {
						System.out.printf("�� %s\n", t);
					}
					System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
					
					//�� ķ���庰 �ü��� ���
					ArrayList<String> farray = facilDAO.list(c.getCode());
					System.out.println("[ķ���� �ü���]");
					if(farray.size() == 0) System.out.println("����");
					for(String f : farray) {
						System.out.printf("- %s\n", f);
					}
					System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
				}
				System.out.println("��ϵ� ķ���� �� : " + carray.size());
				
				break;
				
			case "4":
				Example2.execute();
				
				break;
				
			case "5":
				Example3.execute();
				
				break;
				
			default:
				System.out.println("0~5�� �� �������ּ���.");
			}
		}
	}
}
