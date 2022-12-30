package ex07;

import java.util.*;

public class Example5 {
	public static void execute() {
	
		Scanner s = new Scanner(System.in);
		ArrayList<Address> array = new ArrayList<>();
		
		boolean run = true;
		
		int no = 10;
		
		Address a = new Address();
		a.setNo(no);
		a.setName("ȫ�浿");
		a.setTel("010-0000-1111");
		a.setJuso("��õ ���� �漭��");
		array.add(a);
		
		no++;
		a = new Address();
		a.setNo(no);
		a.setName("��û��");
		a.setTel("010-2222-3333");
		a.setJuso("���� ������ �б�����");
		array.add(a);
		
		while(run == true) {
			System.out.println("----------------------------------------------------");
			System.out.println("1. ��� | 2. �˻� | 3. ���� | 4. ���� | 5. ��� | 0. ����");
			System.out.println("----------------------------------------------------");
			System.out.print("���� > ");
			int menu = s.nextInt(); s.nextLine();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� �����մϴ�.");
				
				break;
				
			case 1:
				no++;
				a = new Address();	//���ο� �ּ� ��ü ����
				System.out.print("��ȣ : " + no);
				a.setNo(no);
				
				System.out.print("�̸� : ");
				a.setName(s.nextLine());
				
				System.out.print("��ȭ : ");
				a.setTel(s.nextLine());
				
				System.out.print("�ּ� : ");
				a.setJuso(s.nextLine());
				
				array.add(a);	//ArrayList�� �ּ� ��ü ���
				System.out.println("���� ��ϵ� �ο��� �� " + array.size() + "�� �Դϴ�.\n");
				
				break;
				
			case 2:
				boolean find = false;
				
				System.out.print("�˻��� ��ȣ : ");
				int sno = s.nextInt(); s.nextLine();
				
				for(Address ad:array) {
					if(sno == ad.getNo()) {
						
						find = true;
						
						System.out.println("�̸� : " + ad.getName());
						System.out.println("��ȭ : " + ad.getTel());
						System.out.println("�ּ� : " + ad.getJuso());
					}
				}
				if(find == false) {
					System.out.println(sno + "���� �ش��ϴ� �л��� �����ϴ�.\n");
				}
				
				break;
				
			case 3:
				System.out.print("������ ��ȣ : ");
				int uno = s.nextInt(); s.nextLine();
				
				find = false;
				
				for(Address ad:array) {
					if(uno == ad.getNo()) {
						find = true;
						System.out.print("���� �� �̸� : " + ad.getName() + " > ������ �̸� : ");
						String name = s.nextLine();
						
						System.out.print("���� �� ��ȭ : " + ad.getTel() + " > ������ ��ȭ : ");
						String tel = s.nextLine();
						
						System.out.print("���� �� �ּ� : " + ad.getJuso() + " > ������ �ּ� : ");
						String juso = s.nextLine();
						
						System.out.print(uno + "�� " + ad.getName() + " �л��� ������ �����Ͻðڽ��ϱ�? (�� : Y, �ƴϿ� : N)\n");
						String sel = s.nextLine();
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							
							if(!name.equals("")) ad.setName(name);
							if(!tel.equals("")) ad.setName(tel);
							if(!juso.equals("")) ad.setName(juso);
							
							System.out.println(uno + "�� �л��� ������ �����Ǿ����ϴ�.\n");
							break;
						} else {
							System.out.println("�޴��� �ٽ� �������ּ���.\n");
						}
					}
				}
				if(find == false) {
					System.out.println(uno + "���� �ش��ϴ� �л��� �����ϴ�.\n");
				}
				
				break;
				
			case 4:
				System.out.print("������ ��ȣ : ");
				int dno = s.nextInt(); s.nextLine();
				
				find = false;
				
				for(Address ad:array) {
					if(dno == ad.getNo()) {
						find = true;
						System.out.println("�̸� : " + ad.getName());
						System.out.println("��ȭ : " + ad.getTel());
						System.out.println("�ּ� : " + ad.getJuso());
						
						System.out.print(dno + "�� " + ad.getName() + " �л��� ������ �����Ͻðڽ��ϱ�? (�� : Y, �ƴϿ� : N)\n");
						String sel = s.nextLine();
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							array.remove(ad);
							System.out.println(dno + "�� " + ad.getName() + " �л��� ������ �����Ǿ����ϴ�.\n");
							break;
						} else {
							System.out.println("�޴��� �ٽ� �������ּ���.\n");
						}
					}
				}
				if(find == false) {
					System.out.println(dno + "���� �ش��ϴ� �л��� �����ϴ�.\n");
				}
				
				break;
				
			case 5:
				for(Address ad:array) {
					System.out.printf("%d\t%s\t%s\t%s\n", ad.getNo(), ad.getName(), ad.getTel(), ad.getJuso());
				}
				
				break;
				
			default:
				System.out.println("0~3�� �޴��� �����ϼ���.");
			}	
		}
	}
}