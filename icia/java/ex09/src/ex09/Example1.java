package ex09;

import java.util.Scanner;

public class Example1 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.print("���� �Է� > ");
				int a = s.nextInt();
				if(a == 0) break;
				
				System.out.println("�Է��� ������ : " + a);
			} catch(Exception e) {
				System.out.println("�Էµ� ���� ���ڰ� �ƴմϴ�.");
				break;
			}
		}
	}
}
