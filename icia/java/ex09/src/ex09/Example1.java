package ex09;

import java.util.Scanner;

public class Example1 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.print("정수 입력 > ");
				int a = s.nextInt();
				if(a == 0) break;
				
				System.out.println("입력한 정수값 : " + a);
			} catch(Exception e) {
				System.out.println("입력된 값이 숫자가 아닙니다.");
				break;
			}
		}
	}
}
