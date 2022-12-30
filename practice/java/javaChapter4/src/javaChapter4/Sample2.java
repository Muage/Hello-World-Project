package javaChapter4;

public class Sample2 {
	public static void main(String[] args) {
		// 조건문
		// switch문
		int num = 5;
		
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
			
		default:
			System.out.println("6번이 나왔습니다.");
			break;
		}
		
		// break 없는 case
		int time = 9;
		switch(time) {
		case 8:
			System.out.println("출근을 합니다.");
			
		case 9:
			System.out.println("회의를 합니다.");
			
		case 10:
			System.out.println("업무를 봅니다.");
			
		default:
			System.out.println("외근을 나갑니다.");
		}
		
		// char 타입의 switch문
		char grade = 'B';
		
		switch(grade) {
		case 'A':
		case 'a':
			System.out.println("우수 회원입니다.");
			break;
		case 'B':
		case 'b':
			System.out.println("일반 회원입니다.");
			break;
		default:
			System.out.println("손님입니다.");
		}
		
		// String 타입의 switch문
		String position = "과장";
		
		switch(position) {
		case "부장":
			System.out.println("700만원");
			break;
		case "과장":
			System.out.println("500만원");
			break;
		case "대리":
			System.out.println("350만원");
			break;
		default:
			System.out.println("300만원");
		}
	}
}