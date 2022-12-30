package ex10;

import java.text.DecimalFormat;
import java.util.*;

public class Example3 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###��");
		AccountVO vo = null;
		AccountDAO dao = new AccountDAO();
		ArrayList<AccountVO> array = dao.list();
		boolean run = true;
		int no = 400;
		
		while(run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1.���»��� | 2.�ܾ���ȸ | 3.�Ա� | 4.��� | 5.��� | 0.����");
			System.out.println("---------------------------------------------------");
			
			System.out.print("���� : ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				
				break;
				
			case 1:
				vo = new AccountVO();
				System.out.println("���¹�ȣ : " + no);
				vo.setNo(no);
				System.out.print("�����ָ� : ");
				vo.setName(s.nextLine());
				System.out.print("�ʱ� �Աݾ� : ");
				vo.setBalance(Integer.parseInt(s.nextLine()));
				
				dao.insert(vo, array);
				System.out.println("���°� �����Ǿ����ϴ�.\n");
				
				break;
				
			case 2:
				System.out.print("��ȸ�� ���¹�ȣ : ");
				String sno = s.nextLine();
				
				vo = dao.read(Integer.parseInt(sno), array);
				if(vo.getName() == null) {
					System.out.println("�ش� ���°� �������� �ʽ��ϴ�.\n");
				} else {
					System.out.println("�����ָ� : " + vo.getName());
					System.out.println("�ܾ� : " + vo.getBalance());
					System.out.println("");
				}
				
				
				break;
				
			case 3:
				System.out.print("�Ա��� ���¹�ȣ : ");
				int ino = s.nextInt(); s.nextLine();
				vo = dao.read(ino, array);
				if(vo.getName() == null) {
					System.out.println("�ش� ���°� �������� �ʽ��ϴ�.\n");
				} else {
					System.out.print("�Աݾ� : ");
					int amount = s.nextInt(); s.nextLine();
					dao.trade(ino, amount, array);
					System.out.println(vo.getName() + "���� (" + ino + ") ���·� " + df.format(amount) + "�� �ԱݵǾ����ϴ�.");
					vo = dao.read(ino, array);
					System.out.println("���� �ܾ��� " + df.format(vo.getBalance()) + " �Դϴ�.\n");
				}
				
				break;
				
			case 4:
				System.out.print("����� ���¹�ȣ : ");
				int ono = s.nextInt(); s.nextLine();
				vo = dao.read(ono, array);
				if(vo.getName() == null) {
					System.out.println("�ش� ���°� �������� �ʽ��ϴ�.\n");
				}else {
					System.out.print("��ݾ� : ");
					int amount = s.nextInt(); s.nextLine();
				
					if (amount <= vo.getBalance() && amount > 0) {
						dao.trade(ono, amount * -1, array);
						System.out.println(vo.getName() + "���� (" + ono + ") ���¿��� " + df.format(amount) + "�� ��ݵǾ����ϴ�.");
						vo = dao.read(ono, array);
						System.out.println("���� �ܾ��� " + df.format(vo.getBalance()) + " �Դϴ�.\n");
					} else if (amount <= 0) {
						System.out.println("�Էµ� ��ݾ��� Ȯ�����ּ���.\n");
					} else {
						System.out.println("�ܾ��� �����մϴ�.\n");
					}
				}
				
				break;
				
			case 5:
				for(AccountVO v : array) {
					System.out.println(v.toString());
				}
				System.out.println("��ü ���¼� : " + array.size());
				System.out.println("");
				
				break;
				
			default:
				System.out.println("0~4�� �޴� �� �����ϼ���.\n");
			}
		}
	}
}
