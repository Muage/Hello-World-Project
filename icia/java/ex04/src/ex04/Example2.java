package ex04;

import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("***** ��ǰ���� ��Ȳ *****");
		
		while(true) {	//���ѹݺ�
			System.out.println("");
			System.out.print("��ǰ�� > ");
			String name = s.next();
			
			System.out.print("�ܰ� > ");
			int price = s.nextInt();
			
			System.out.print("���� > ");
			int count = s.nextInt();
			
			int tot = price * count;
			System.out.println("�Ǹűݾ� : " + tot);
			
			String remark = "";
			if(tot >= 5000) {
				remark = "�ֿ��";
			} else if(tot >= 3000) {
				remark = "���";
			} else {
				remark = "����";
			}
			System.out.println("��� : " + remark);
			
			System.out.print("���(1) / ����(0) > ");
			int sel = s.nextInt();
			if(sel == 0) {
				System.out.println("");
				System.out.println("���α׷��� �����մϴ�.");
				System.out.println("--------------------");
				break;
			}
		}
	}
}
