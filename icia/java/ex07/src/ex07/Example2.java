package ex07;

import java.util.Scanner;

public class Example2 {
	public static void execute() {
		System.out.println("***** ���� ���� ���ϱ� *****");
		
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		Area a = new Area();
		
		while(run == true) {
			System.out.println("----------------------------------------");
			System.out.println("1. ���簢�� | 2. ���簢�� | 3. �� | 0. ����");
			System.out.println("----------------------------------------");
			System.out.println("���� > ");
			int menu = s.nextInt();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� �����մϴ�.");
				
				break;
				
			case 1:
				System.out.print("�� ���� ���� : ");
				int x = s.nextInt();
				
				System.out.printf("�� ���� ���̰� %d�� ���簢���� ���̴� %d�Դϴ�.\n", x, + a.area(x));
				
				break;
				
			case 2:
				System.out.print("���� ���� : ");
				x = s.nextInt();
				
				System.out.print("���� ���� : ");
				int y = s.nextInt();
				
				System.out.printf("���� ���̰� %d�̰� ���� ���̰� %d�� ���簢���� ���̴� %d�Դϴ�.\n", x, y, a.area(x, y));
				
				break;
				
			case 3:
				System.out.print("���� ������ : ");
				double z = s.nextDouble();

				System.out.printf("�������� %.0f�� ���� ���̴� %.2f�Դϴ�. \n", z, a.area(z));
				
				break;
				
			default:
				System.out.println("0~3�� �޴��� �����ϼ���.");
				
				break;
			}
		}
	}
}