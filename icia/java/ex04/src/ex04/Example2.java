package ex04;

import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("***** 상품매출 현황 *****");
		
		while(true) {	//무한반복
			System.out.println("");
			System.out.print("상품명 > ");
			String name = s.next();
			
			System.out.print("단가 > ");
			int price = s.nextInt();
			
			System.out.print("수량 > ");
			int count = s.nextInt();
			
			int tot = price * count;
			System.out.println("판매금액 : " + tot);
			
			String remark = "";
			if(tot >= 5000) {
				remark = "최우수";
			} else if(tot >= 3000) {
				remark = "우수";
			} else {
				remark = "보통";
			}
			System.out.println("비고 : " + remark);
			
			System.out.print("계속(1) / 중지(0) > ");
			int sel = s.nextInt();
			if(sel == 0) {
				System.out.println("");
				System.out.println("프로그램이 종료합니다.");
				System.out.println("--------------------");
				break;
			}
		}
	}
}
