package ex04;

import java.util.Scanner;

public class Example4 {
	public static void execute() {
		
		Scanner s = new Scanner(System.in);
		
		boolean run = true;	//��������
		int balance = 1000;
		
		while(run) {
			System.out.println("----------------------------------------");
			System.out.println("1. �ܾ�Ȯ�� | 2. �Ա� | 3. ��� | 0. ����");
			System.out.println("----------------------------------------");
			
			System.out.print("���� > ");
			int sel = s.nextInt();
			switch(sel) {
			case 1:
				System.out.println("���� �ܾ� : " + balance + "\n");
				break;
			case 2:
				System.out.print("�Ա��� �ݾ� > ");
				int input = s.nextInt();
				balance = balance + input;
				System.out.println("���� �ܾ� : " + balance + "\n");
				break;
			case 3:
				System.out.print("����� �ݾ� > ");
				int output = s.nextInt();
				if(balance<output) {
					System.out.println("�ܾ��� �����մϴ�.\n");
				} else {
					balance = balance - output;
					System.out.println("���� �ܾ� : " + balance + "\n");
				}
				break;
			case 0:
				run = false;
				System.out.println("���α׷��� ����˴ϴ�.\n");
				break;
			default:
				System.out.println("�޴��� �ٽ� �����ϼ���!\n");
			}	//switch
		}	//while
	}	//execute
}	//class
