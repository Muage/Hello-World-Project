package ex03;

import java.util.Scanner;

public class Example3 {
	public static void execute() {
		System.out.println("** ���� ��Ȳ **");
		
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		while(run) {
			System.out.print("�ܰ� > ");
			int price = s.nextInt();
			
			if(price == 0) {
				run = false;
				System.out.println("���α׷��� �����մϴ�.");
				System.out.println("--------------------");
				// run = false; ��� break;�� �־ �ȴ�.
			} else {
				System.out.print("���� > ");
				int count = s.nextInt();
				
				int tot = price * count;
				System.out.println("�ݾ� : " + tot);
				
				String remark = "";
				
				if(tot >= 100000) {
					remark = "�ֿ��";
				} else if(tot >= 50000) {
					remark = "���";
				} else {
					remark = "�й�";
				}
				
				System.out.println("��� : " + remark);
				
				System.out.println("--------------------");
			}
		}
	}
}
