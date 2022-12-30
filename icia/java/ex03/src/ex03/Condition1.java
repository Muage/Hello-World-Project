package ex03;

import java.util.Scanner;

public class Condition1 {
	public static void execute() {
		//조건문(switch case)
		Scanner s = new Scanner(System.in);						//키보드로 데이터를 입력 받기 위해 스캐너 생성
		
		System.out.print("값? ");
		int num = s.nextInt();
		
		switch(num) {
		case 1:
			System.out.println("1번이 나왔습니다.");
			break;
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;
		case 6:
			System.out.println("6번이 나왔습니다.");
			break;
		default:
			System.out.println("잘못된 값이 입력되었습니다.");
		}
		
		//시간을 키보드로 입력받아
		//6시이면 '일어나세요'
		//7시이면 '회사로 출발하세요'
		//13시이면 '점심 식사하세요'
		//18시이면 '퇴근하세요'
		System.out.print("현재시간> ");
		int time = s.nextInt();
		switch(time) {
		case 6:
			System.out.println("일어나세요!");
			break;
		case 7:
			System.out.println("회사로 출발하세요!");
			break;
		case 13:
			System.out.println("점심 식사하세요!");
			break;
		case 18:
			System.out.println("퇴근하세요!");
			break;
		default:
			System.out.println("잘못된 값이 입력되었습니다.");
		}
	}
}
