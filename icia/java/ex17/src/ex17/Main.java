package ex17;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CampDAO campDAO = new CampDAO();
		CampVO campVO;
		FacilityDAO facilityDAO = new FacilityDAO();
		FacilityVO facilityVO;
		TypeDAO typeDAO = new TypeDAO();
		TypeVO typeVO;
		ArrayList<CampVO> array;
		ArrayList<FacilityVO> farray;
		ArrayList<TypeVO> tarray;
		String newCode;
		String cname;
		String address;
		String code;
		boolean run = true;
		int menu;
		
		while(run) {
			System.out.println("��������������������������������������������������");
			System.out.println("��\t1.ķ������\t��");
			System.out.println("��������������������������������������������������");
			System.out.println("��\t2.ķ������\t��");
			System.out.println("��������������������������������������������������");
			System.out.println("��\t3.ķ������ȸ\t��");
			System.out.println("��������������������������������������������������");
			System.out.println("��\t4.�ü�������\t��");
			System.out.println("��������������������������������������������������");
			System.out.println("��\t5.��������\t\t��");
			System.out.println("��������������������������������������������������");
			System.out.println("��\t0.���α׷�����\t��");
			System.out.println("��������������������������������������������������");
			
			System.out.print("�޴��� �������ּ���. : ");
			menu = scanner.nextInt(); scanner.nextLine();
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				
				break;
				
			case 1:
				newCode = campDAO.getNewCode();
				System.out.println("ķ�����ڵ� : " + newCode);
				System.out.print("ķ�����̸� : ");
				cname = scanner.nextLine();
				if(cname.equals("")) {
					System.out.println("ķ�����̸��� �Է��� ���� ķ���� ����� ��ҵǾ����ϴ�.\n");
					break;
				}
				System.out.print("ķ�����ּ� : ");
				address = scanner.nextLine();
				if(address.equals("")) {
					System.out.println("ķ�����ּ��� �Է��� ���� ķ���� ����� ��ҵǾ����ϴ�.\n");
					break;
				}
				campVO = new CampVO();
				campVO.setCode(newCode);
				campVO.setCname(cname);
				campVO.setAddress(address);
				
				campDAO.insert(campVO);
				System.out.println("ķ���� ����� �Ϸ�Ǿ����ϴ�.\n");
				
				break;
				
			case 2:
				array = campDAO.list();
				System.out.println("\nķ�����ڵ�\t\tķ�����̸�\t\tķ�����ּ�");
				System.out.println("����������������������������������������������������������������������������������������������������");
				for(CampVO v : array) {
					System.out.printf("%s\t\t%s\t\t%s\n", v.getCode(), v.getCname(), v.getAddress());
					System.out.println("");
					//�� ķ������ �ü��� ���
					farray = facilityDAO.list(v.getCode());
					System.out.println("[�ü���]");
					for(FacilityVO f : farray) {
						System.out.printf("�� %s(%s)     ", f.getFname(), f.getFcode());
					}
					System.out.println("\n");
					
					//�� ķ������ ���� ���
					tarray = typeDAO.list(v.getCode());
					System.out.println("[ķ������]");
					for(TypeVO t : tarray) {
						System.out.printf("�� %s(%d��)     ", t.getTname(), t.getQnt());
					}
					System.out.println("");
					System.out.println("����������������������������������������������������������������������������������������������������");
				}
				System.out.println("");
				
				break;
				
			case 3:
				System.out.print("ķ�����ڵ� : ");
				code = scanner.nextLine();
				if(code.equals("")) {
					System.out.println("�Էµ� ķ�����ڵ尡 ���� ��ȸ�� ��ҵǾ����ϴ�.\n");
					break;
				}
				campVO = campDAO.read(code);
				if(campVO.getCname() == null) {
					System.out.println("�ش� ķ������ �����ϴ�.\n");
					break;
				}
				//ķ���� ���� ���
				System.out.println("\nķ�����̸�\t\tķ�����ּ�");
				System.out.printf("%s\t\t%s\n\n", campVO.getCname(), campVO.getAddress());
				//�ü��� ��� ���
				farray = facilityDAO.list(code);
				System.out.println("[�ü���]");
				for(FacilityVO f : farray) {
					System.out.printf("�� %s(%s)     ", f.getFname(), f.getFcode());
				}
				System.out.println("\n");
				//���� ��� ���
				tarray = typeDAO.list(code);
				System.out.println("[ķ������]");
				for(TypeVO t : tarray) {
					System.out.printf("�� %s(%d��)     ", t.getTname(), t.getQnt());
				}
				System.out.println("\n");
				
				break;
				
			case 4:
				Example1.execute();
				break;
		
			case 5:
				Example2.execute();
				break;
		
			default:
				System.out.println("0~5�� �޴� �� �������ּ���.\n");
			}
		}
	}
}
