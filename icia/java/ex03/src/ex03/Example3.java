package ex03;

import java.util.Scanner;

public class Example3 {
	public static void execute() {
		System.out.println("** 매출 현황 **");
		
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		while(run) {
			System.out.print("단가 > ");
			int price = s.nextInt();
			
			if(price == 0) {
				run = false;
				System.out.println("프로그램을 종료합니다.");
				System.out.println("--------------------");
				// run = false; 대신 break;를 넣어도 된다.
			} else {
				System.out.print("수량 > ");
				int count = s.nextInt();
				
				int tot = price * count;
				System.out.println("금액 : " + tot);
				
				String remark = "";
				
				if(tot >= 100000) {
					remark = "최우수";
				} else if(tot >= 50000) {
					remark = "우수";
				} else {
					remark = "분발";
				}
				
				System.out.println("비고 : " + remark);
				
				System.out.println("--------------------");
			}
		}
	}
}
