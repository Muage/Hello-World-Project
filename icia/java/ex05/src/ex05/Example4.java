package ex05;

import java.util.Scanner;

public class Example4 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		
		String[] name = new String[100];
		String[] address = new String[100];
		String[] tel = new String[100];
		
		int count = 0;
		
		while(run == true) {
			System.out.println("---------------------------------------------");
			System.out.println("1. �ּҵ�� | 2. �ּҰ˻� | 3. �ּҸ�� | 0. ����");
			System.out.println("---------------------------------------------");
			System.out.print("���� > ");
			int menu = s.nextInt();
			
			switch(menu) {
				case 1:
					System.out.print("�̸� > ");
					name[count] = s.next(); s.nextLine();
					
					System.out.print("�ּ� > ");
					address[count] = s.nextLine();
					
					System.out.print("��ȭ > ");
					tel[count] = s.next(); s.nextLine();
					
					count++;	//count = count + 1;
					System.out.println(count + "�� �Է� �Ϸ�\n");
					
					break;
				
				case 2:
					System.out.print("�̸� > ");
					String sname = s.next();
					
					boolean find = false;
					
					for(int i=0; i<count; i++) {
						if(sname.equals(name[i])) {
							find = true;
							
							System.out.println("�ּ� > " + address[i]);
							System.out.println("��ȭ > " + tel[i]);
							System.out.println("");
						}
					}
					
					break;
				
				case 3:
					System.out.println("*************** �ּҸ�� ***************");
					System.out.println("�̸�\t�ּ�\t\t��ȭ");
					for(int i=0; i<count; i++) {
						System.out.println(name[i] + "\t" + address[i] + "\t" + tel[i]);
					}
					System.out.println("");
					
					break;
					
				case 0:
					run = false;
					System.out.println("���α׷��� ����˴ϴ�.\n");
					
					break;
					
				default:
					System.out.println("0~3�� �޴��� �����ϼ���.\n");
			}
		}
	}
}
