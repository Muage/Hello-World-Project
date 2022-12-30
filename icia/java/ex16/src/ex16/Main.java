package ex16;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("─────────────────────────────────────────────────");
			System.out.println("1.학과관리 │ 2.시험타입관리 │ 3.학생관리 │ 4.성적관리 │ 0.종료");
			System.out.println("─────────────────────────────────────────────────");
			
			int menu = Main.input("선택");
			switch(menu) {
			case 0:
				run = false;
				System.out.println("메인페이지로 이동합니다.\n");
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
				System.out.println("0~4번 메뉴 중 선택해주세요.");
			}
		}
		
	}
	
	//숫자 입력 받기
	public static int input(String title) {
		Scanner scanner = new Scanner(System.in);
		String value = "";
		boolean isNumber = false;
		do {
			System.out.print(title + " : ");
			value = scanner.nextLine();
			isNumber = value.matches("-?\\d+(\\.\\d+)?");
			if(isNumber == false) System.out.println("숫자로 입력해주세요.");
		} while(isNumber == false);
		
		return Integer.parseInt(value);
	}
}
