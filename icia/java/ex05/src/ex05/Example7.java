package ex05;

import java.util.*;

public class Example7 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		ArrayList<Address> array = new ArrayList<>();
		
		while(run) {
			System.out.println("---------------------------------------------");
			System.out.println("1. �ּҵ�� | 2. �ּҰ˻� | 3. �ּҸ�� | 0. ����");
			System.out.println("---------------------------------------------");
			System.out.print("���� > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 1:
				Address juso = new Address();
				
				System.out.print("�̸� > ");
				juso.name = s.next(); s.nextLine();
				
				System.out.print("�ּ� > ");
				juso.address = s.nextLine();
				
				System.out.print("��ȭ > ");
				juso.tel = s.next(); s.nextLine();
				
				array.add(juso);
				
				break;

			case 2:
				System.out.print("�˻��� �̸� > ");
				String sname = s.nextLine();
				
				boolean find = false;
				
				for(Address a:array) {
					if(sname.equals(a.name)) {
						a.print();
						find = true;
					}
//					�ϳ��� ������ ����� �ȴ�. 
//					else {
//						System.out.println("�Է��� �����Ͱ� �����ϴ�.");
//					}
				}
				if(find == false) {
					System.out.println("�Է��� �����Ͱ� �����ϴ�.");					
				}
				
				
				break;
				
			case 3:
				for(Address a:array) {
					a.print();
				}
				
				break;
				
			case 0:
				run = false;
				System.out.println("���α׷��� �����մϴ�.");
				break;
			
			default:
				System.out.println("0~3�� �޴��� �����ϼ���.");
			}
		}
		
	}
}
