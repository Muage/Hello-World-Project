package ex04;

import java.util.Scanner;

public class Example3 {
	public static void execute() {
		
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		while(run) {
			System.out.println("----------------------------------------");
			System.out.println("1. �հ� | 2. ¦���հ� | 3. Ȧ���հ� | 0. ����");
			System.out.println("----------------------------------------");
			System.out.print("���� > ");
			int sel = s.nextInt();
			
			int num = 0;
			if(sel>=1 && sel <=3) {
				System.out.print("������ > ");
				num = s.nextInt();
			}
			
			int sum = 0;	//�հ� ���� ����
			switch(sel) {
			case 1:
				for(int i=1; i<=num; i++) {
					sum = sum + i;	//i�� �հ� sum�� ����
				}
				System.out.println("1~" + num + "������ �� : " + sum + "\n");
				break;
			case 2:
				for(int i=2; i<=num; i=i+2) {
					sum = sum + i;
				}
				System.out.println("1~" + num + "������ ¦���� �� : " + sum + "\n");
				break;
			case 3:
				for(int i=1; i<=num; i=i+2) {
					sum = sum + i;
				}
				System.out.println("1~" + num + "������ Ȧ���� �� : " + sum + "\n");
				break;
			case 0:
				run = false;
				System.out.println("");
				System.out.println("���α׷��� ����˴ϴ�!");
				break;
			default:
				System.out.println("�޴��� �ٽ� �����ϼ���!\n");
			}
		} 
	}
}
