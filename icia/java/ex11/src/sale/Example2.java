package sale;

import java.io.FileWriter;
import java.util.*;

public class Example2 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		SaleDAO dao = new SaleDAO();
		SaleVO vo = null;
		
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
				int newNo = dao.getNo() + 100;
				System.out.println("��ǰ ��ȣ : " + newNo);
				vo = new SaleVO();
				vo.setNo(newNo);
				System.out.print("��ǰ���� �Է����ּ���. : ");
				vo.setName(s.nextLine());
				
				System.out.print("��ǰ �ܰ��� �Է����ּ���. : ");
				vo.setPrice(s.nextInt()); s.nextLine();
				
				System.out.print("�Ǹ� ������ �Է����ּ���. : ");
				vo.setQnt(s.nextInt()); s.nextLine();
				
				dao.insert(vo);
				System.out.printf("%d�� ��ǰ�� ��ϵǾ����ϴ�.\n", newNo);
				
				break;
				
			case 2:
				for(SaleVO v : dao.list()) {
					System.out.println(v.toString());
				}
				
				break;
				
			case 3:
				String no = "";
				boolean isNumber = false;
				do {
					System.out.print("�˻��� ��ȣ�� �Է����ּ���. : ");
					no = s.nextLine();
					isNumber = no.matches("-?\\d+(\\.\\d+)?");	//���Խ�
					if(!isNumber) System.out.println("���ڷ� �Է��ϼ���.");
				} while(isNumber == false);
				
				vo = dao.read(Integer.parseInt(no));
				
				if(vo.getName() == null) {
					System.out.println("�Է��Ͻ� ��ȣ�� ��ϵ� ��ǰ�� �����ϴ�.\n");
				} else {
					System.out.println(vo.toString());
				}
				
				break;
				
			case 4:
				no = "";
				isNumber = false;
				do {
					System.out.print("������ ��ȣ�� �Է����ּ���. : ");
					no = s.nextLine();
					isNumber = no.matches("-?\\d+(\\.\\d+)?");	//���Խ�
					if(!isNumber) System.out.println("���ڷ� �Է��ϼ���.");
				} while(isNumber == false);
				
				vo = dao.read(Integer.parseInt(no));
				
				if(vo.getName() == null) {
					System.out.println("�Է��Ͻ� ��ȣ�� ��ϵ� ��ǰ�� �����ϴ�.\n");
				} else {
					System.out.print("��ǰ�� : " + vo.getName() + " > ");
					String name = s.nextLine();
					
					System.out.print("��ǰ�ܰ� : " + vo.getPrice() + " > ");
					String price = s.nextLine();
					
					System.out.print("�Ǹż��� : " + vo.getQnt() + " > ");
					String qnt = s.nextLine();
					
					System.out.printf("��ǰ��ȣ %s���� ������ �����Ͻðڽ��ϱ�? ( �� : Y , �ƴϿ� : N) > ", no);
					String sel = s.nextLine();
					if (sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
						if(!name.equals("")) vo.setName(name);
						if(!price.equals("")) vo.setPrice(Integer.parseInt(price));
						if(!qnt.equals("")) vo.setQnt(Integer.parseInt(qnt));
						
						dao.update(vo);
						System.out.printf("��ǰ��ȣ %s���� ������ �����Ǿ����ϴ�.\n", no);
					}
					break;
				}
				
				break;
				
			case 5:
				System.out.print("������ ��ȣ�� �Է����ּ���. : ");
				int dno = s.nextInt(); s.nextLine();
				
				vo = dao.read(dno);
				
				if(vo.getName() == null) {
					System.out.println("�Է��Ͻ� ��ȣ�� ��ϵ� ��ǰ�� �����ϴ�.\n");
				} else {
					dao.delete(dno);
					System.out.printf("%d�� %s ��ǰ�� �����Ǿ����ϴ�.\n", dno, vo.getName());
				}
				
				break;
				
			default:
				System.out.println("0~5�� �� �������ּ���.\n");
			}
		}
	}
}
