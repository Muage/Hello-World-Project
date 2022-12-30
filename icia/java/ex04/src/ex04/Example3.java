package ex04;

import java.util.Scanner;

public class Example3 {
	public static void execute() {
		
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		while(run) {
			System.out.println("----------------------------------------");
			System.out.println("1. 합계 | 2. 짝수합계 | 3. 홀수합계 | 0. 종료");
			System.out.println("----------------------------------------");
			System.out.print("선택 > ");
			int sel = s.nextInt();
			
			int num = 0;
			if(sel>=1 && sel <=3) {
				System.out.print("최종값 > ");
				num = s.nextInt();
			}
			
			int sum = 0;	//합계 저장 변수
			switch(sel) {
			case 1:
				for(int i=1; i<=num; i++) {
					sum = sum + i;	//i의 합계 sum에 저장
				}
				System.out.println("1~" + num + "까지의 합 : " + sum + "\n");
				break;
			case 2:
				for(int i=2; i<=num; i=i+2) {
					sum = sum + i;
				}
				System.out.println("1~" + num + "까지의 짝수의 합 : " + sum + "\n");
				break;
			case 3:
				for(int i=1; i<=num; i=i+2) {
					sum = sum + i;
				}
				System.out.println("1~" + num + "까지의 홀수의 합 : " + sum + "\n");
				break;
			case 0:
				run = false;
				System.out.println("");
				System.out.println("프로그램이 종료됩니다!");
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요!\n");
			}
		} 
	}
}
