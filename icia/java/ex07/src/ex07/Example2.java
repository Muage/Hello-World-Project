package ex07;

import java.util.Scanner;

public class Example2 {
	public static void execute() {
		System.out.println("***** 도형 넓이 구하기 *****");
		
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		Area a = new Area();
		
		while(run == true) {
			System.out.println("----------------------------------------");
			System.out.println("1. 정사각형 | 2. 직사각형 | 3. 원 | 0. 종료");
			System.out.println("----------------------------------------");
			System.out.println("선택 > ");
			int menu = s.nextInt();
			
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				
				break;
				
			case 1:
				System.out.print("한 변의 길이 : ");
				int x = s.nextInt();
				
				System.out.printf("한 변의 길이가 %d인 정사각형의 넓이는 %d입니다.\n", x, + a.area(x));
				
				break;
				
			case 2:
				System.out.print("가로 길이 : ");
				x = s.nextInt();
				
				System.out.print("세로 길이 : ");
				int y = s.nextInt();
				
				System.out.printf("가로 길이가 %d이고 세로 길이가 %d인 직사각형의 넓이는 %d입니다.\n", x, y, a.area(x, y));
				
				break;
				
			case 3:
				System.out.print("원의 반지름 : ");
				double z = s.nextDouble();

				System.out.printf("반지름이 %.0f인 원의 넓이는 %.2f입니다. \n", z, a.area(z));
				
				break;
				
			default:
				System.out.println("0~3번 메뉴를 선택하세요.");
				
				break;
			}
		}
	}
}