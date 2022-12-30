package ex06;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("");
			System.out.println("---------------------------------------------------");
			System.out.println("1. 생성자 오버로딩");
			System.out.println("2. ArrayList");
			System.out.println("3. 성적 관리");
			System.out.println("4. 상품 관리");
			System.out.println("0. 프로그램 종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택 > ");
			int menu = s.nextInt();
			System.out.println("");
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.\n");
				break;
			
			case 1:
				Example1.execute();
				break;
			
			case 2:
				Example2.execute();
				break;
			
			case 3:
				Example3.execute();
				break;
				
			case 4:
				Example4.execute();
				break;
				
			default:
				System.out.println("");
			}
		}
	}
}