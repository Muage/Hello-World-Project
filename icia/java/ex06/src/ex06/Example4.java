package ex06;

import java.util.*;

public class Example4 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		ArrayList<Product> products = new ArrayList<>();
		
		Product p1 = new Product("�����", 7500, 150);
		products.add(p1);
		
		Product p2 = new Product("��Ź��", 4000, 70);
		products.add(p2);
		
		Product p3 = new Product("������", 5000, 100);
		products.add(p3);
		
		boolean run = true;
		
		System.out.println("******************** �� ǰ �� �� ********************");
		while(run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. ��� | 2. �˻� | 3. ��� | 4. ���� | 5. ���� | 0. ����");
			System.out.println("---------------------------------------------------");
			System.out.print("���� > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				
				break;
				
			case 1:
				
				System.out.print("����� ��ǰ�� �̸� : ");
				String name = s.nextLine();
				
				boolean find = false;
				
				for(Product p:products) {
					if(name.equals(p.name)) {
						find = true;
						System.out.println("���� �̸����� ��ϵ� ��ǰ�� �ֽ��ϴ�.");
						System.out.println("��� ����Ͻðڽ��ϱ�? ( �� : Y, �ƴϿ� : N)");
						String sel = s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��") ) {
							find = false;
						}
					}
				}
				if(find == false) {
				
					System.out.print("��ǰ �ܰ� : ");
					int price = s.nextInt(); s.nextLine();
					
					System.out.print("�Ǹ� ���� : ");
					int qnt = s.nextInt(); s.nextLine();
					
					Product product2 = new Product(name, price, qnt);
					products.add(product2);
					
					System.out.println("���� �� " + products.size() + "���� ��ǰ�� ��ϵǾ� �ֽ��ϴ�.\n");
				}
				
				break;
				
			case 2:
				System.out.print("�˻��� ��ǰ�� �̸� : ");
				String sname = s.nextLine();
				
				find = false;
				
				for(Product p:products) {
					if(sname.equals(p.name)) {
						find = true;
						p.print();
					}
				}
				if(find == false) {
					System.out.println(sname + "�� ���� �˻������ �����ϴ�.\n");
				}
				
				break;
				
			case 3:
				for(Product p:products) {
					p.printList();
					System.out.println("---------------------------------------------------");
				}
				
				break;
				
			case 4:
				System.out.print("������ ��ǰ�� �̸� : ");
				String dname = s.nextLine();
				
				find = false;
				
				for(Product p:products) {
					if(dname.equals(p.name)) {
						find = true;
						p.print();
						
						System.out.println(dname + "�� ������ �����Ͻðڽ��ϱ�? (�� : Y)");
						String sel = s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��") ) {
							products.remove(p);
							System.out.println(dname + "�� ������ �����Ǿ����ϴ�.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println(dname + "�� ���� �˻������ �����ϴ�.\n");
				}
				
				break;
				
			case 5:
				System.out.print("������ ��ǰ�� �̸� : ");
				String uname = s.nextLine();
				
				find = false;
				
				for(Product p:products) {
					if(uname.equals(p.name)) {
						find = true;
						
						System.out.print("���� �� ��ǰ �̸� : " + p.name + " > ���� �� ��ǰ �̸� : ");
						String nname = s.nextLine();
						
						System.out.print("���� �� ��ǰ �ܰ� : " + p.price + " > ���� �� ��ǰ �ܰ� : ");
						String nprice = s.nextLine();
						
						System.out.print("���� �� ��ǰ ���� : " + p.qnt + " > ���� �� ��ǰ ���� : ");
						String nqnt = s.nextLine();
						
						
						System.out.println(uname + "�� ������ �����Ͻðڽ��ϱ�? (�� : Y)");
						String sel = s.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							if(!nname.equals("")) p.name = nname;
							if(!nprice.equals("")) p.price = Integer.parseInt(nprice);
							if(!nqnt.equals("")) p.qnt = Integer.parseInt(nqnt);
							
							p.print();
							System.out.println(nname + "�� ������ �����Ǿ����ϴ�.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println(uname + "�� ���� �˻������ �����ϴ�.\n");
				}
				
				break;
				
			default:
				System.out.println("0~5�� �޴��� �������ּ���.\n");				
			}	
		}
	}
}
