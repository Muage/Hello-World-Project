package ex03;

import java.util.Scanner;

public class Example1 {
	public static void execute() {
		//����1, ����2 �Է� �޾�
		//����(1), ����(2), ����(3), ������(4) ����
		//��� ��� ���
		Scanner s = new Scanner(System.in);
		
		System.out.print("����1 > ");
		int num1 = s.nextInt();
		
		System.out.print("����2 > ");
		int num2 = s.nextInt();
		
		System.out.println("����(1) / ����(2) / ����(3) / ������(4) > ");
		int sel = s.nextInt();
		double result = 0;
		
		switch(sel) {
			case 1:
				result = num1 + num2;
				break;
			case 2:
				result = num1 - num2;
				break;
			case 3:
				result = num1 * num2;
				break;
			case 4:
				result = num1 / num2;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
		}
		System.out.println("�����:" + result);
	}
}
