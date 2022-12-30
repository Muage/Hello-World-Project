package ex04;

import java.util.Scanner;

public class Example4 {
	public static void execute() {
		
		Scanner s = new Scanner(System.in);
		
		boolean run = true;	//실행유무
		int balance = 1000;
		
		while(run) {
			System.out.println("----------------------------------------");
			System.out.println("1. 잔액확인 | 2. 입금 | 3. 출금 | 0. 종료");
			System.out.println("----------------------------------------");
			
			System.out.print("선택 > ");
			int sel = s.nextInt();
			switch(sel) {
			case 1:
				System.out.println("현재 잔액 : " + balance + "\n");
				break;
			case 2:
				System.out.print("입금할 금액 > ");
				int input = s.nextInt();
				balance = balance + input;
				System.out.println("현재 잔액 : " + balance + "\n");
				break;
			case 3:
				System.out.print("출금할 금액 > ");
				int output = s.nextInt();
				if(balance<output) {
					System.out.println("잔액이 부족합니다.\n");
				} else {
					balance = balance - output;
					System.out.println("현재 잔액 : " + balance + "\n");
				}
				break;
			case 0:
				run = false;
				System.out.println("프로그램이 종료됩니다.\n");
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요!\n");
			}	//switch
		}	//while
	}	//execute
}	//class
