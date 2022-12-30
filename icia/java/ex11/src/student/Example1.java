package student;

import java.util.*;

public class Example1 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		StudentDAO dao = new StudentDAOImpl();
		StudentVO vo = null;
		boolean run = true;
		
		while(run) {
			System.out.println("\n***************** �� �� �� �� *****************");
			System.out.println("---------------------------------------------");
			System.out.println("1.��� | 2.��� | 3.�˻� | 4.���� | 5.���� | 0.����");
			System.out.println("---------------------------------------------");
			
			System.out.print("���Ͻô� ������ �������ּ���. > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				
				break;
				
			case 1:
				int newCode = dao.getCode() + 100;
				System.out.println("��ȣ : " + newCode);
				vo = new StudentVO();
				vo.setNo(newCode);
				System.out.print("�̸� : ");
				vo.setName(s.nextLine());
				
				System.out.print("��ȭ : ");
				vo.setTel(s.nextLine());
				
				System.out.print("�ּ� : ");
				vo.setAddress(s.nextLine());
				
				dao.insert(vo);
				System.out.println(newCode + "�� �л��� ��ϵǾ����ϴ�.\n");
				
				break;
				
			case 2:
				ArrayList<StudentVO> array = dao.list();
				for(StudentVO v : array) {
					System.out.printf("%d\t%s\t%s\t%s\n", v.getNo(), v.getName(), v.getTel(), v.getAddress());
				}
				System.out.printf("\n���� ��ϵ� �л��� %d�� �Դϴ�.\n\n", array.size());
				
				break;
				
			case 3:
				System.out.print("�˻��� ��ȣ�� �Է����ּ���. : ");
				int sno = s.nextInt(); s.nextLine();
				
				vo = dao.read(sno);
				
				if(vo.getName() == null) {
					System.out.println("�Է��Ͻ� ��ȣ�� ��ϵ� �л��� �����ϴ�.\n");
				} else {
					System.out.println(vo.toString());
				}
				
				break;
				
			case 4:
				System.out.print("������ ��ȣ�� �Է����ּ���. : ");
				int uno = s.nextInt(); s.nextLine();

				vo = dao.read(uno);
				String oldName = vo.getName();
				
				if(vo.getName() == null) {
					System.out.println("�Է��Ͻ� ��ȣ�� ��ϵ� �л��� �����ϴ�.\n");
				} else {
					StudentVO v = new StudentVO();
					v.setNo(uno);
					
					System.out.print(vo.getName() + " > ");
					String name = s.nextLine();
					
					System.out.print(vo.getTel() + " > ");
					String tel = s.nextLine();
					
					System.out.print(vo.getAddress() + " > ");
					String address = s.nextLine();
					
					if(!name.equals("")) vo.setName(name);
					if(!tel.equals("")) vo.setTel(tel);
					if(!address.equals("")) vo.setAddress(address);
					
					dao.update(vo);
					System.out.printf("%d�� %s�� ������ �����Ǿ����ϴ�.\n\n", uno, oldName);
				}
				
				break;
				
			case 5:
				System.out.print("������ ��ȣ�� �Է����ּ���. : ");
				int dno = s.nextInt(); s.nextLine();
				
				vo = dao.read(dno);
				
				if(vo.getName() == null) {
					System.out.println("�Է��Ͻ� ��ȣ�� ��ϵ� �л��� �����ϴ�.\n");
				} else {
					dao.delete(dno);
					System.out.printf("%d�� %s �л��� �����Ǿ����ϴ�.\n\n", dno, vo.getName());
				}
				
				break;
				
			default:
				System.out.println("0~5�� �� �������ּ���.\n");
			}
		}
	}
}
