package javaChapter4;

import java.util.Scanner;

public class Sample4 {
	public static void main(String[] args) throws Exception {
		// 반복문
		// while문
		boolean run = true;
		int speed = 0;
		int keyCode = 0;
		
		while(run) {
			if(keyCode != 13 && keyCode != 10) {
				System.out.println("--------------------");
				System.out.println("1.증속 | 2.감속 | 3.중지");
				System.out.println("--------------------");
				System.out.println("선택 : ");
			}
			keyCode = System.in.read();	// 키보드 키코드를 읽음
			
			if(keyCode == 49) {
				speed++;
				System.out.println("현재 속도 : " + speed);
			} else if(keyCode == 50) {
				speed--;
				System.out.println("현재 속도 : " + speed);
			} else if(keyCode == 51) {
				run = false;	// while문 종료를 위해 run 변수에 false 저장
			}
		}
		System.out.println("프로그램 종료");
		
		// do-while문
		System.out.println("메시지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");
		
		Scanner scanner = new Scanner(System.in);
		String inputString;
		
		do {
			System.out.println(">");
			inputString = scanner.nextLine();	// '\n'을 포함하는 한 라인을 읽고 '\n'을 제외한 나머지를 리턴해준다.
			System.out.println(inputString);
		} while( !inputString.equals("q"));
		
		System.out.println();
		System.out.println("프로그램 종료");
		
		// break로 while문 종료
		while(true) {
			int num = (int)(Math.random() * 6) + 1;	// Math.random() : 0이상 1미만의 난수 발생
			System.out.println(num);
			
			if(num == 6) {
				break;
			}
		}
		System.out.println("프로그램 종료");
		
		// 바깥쪽 반복문 종료
//		Outter;
//		
//		for(char upper = 'A'; upper <= 'Z'; upper++) {
//			for(char lower = 'a'; lower <= 'z'; lower++) {
//				System.out.println(upper + "-" + lower);
//				if(lower == 'g') {
//					break Outter;
//				}
//			}
//		}
//		System.out.println("프로그램 실행 종료");
		
		// continue를 사용한 while문
		for(int i = 1; i <= 10; i++) {
			if(i%2 != 0) {
				continue;
			}
			System.out.println(i);
		}
	}
}
