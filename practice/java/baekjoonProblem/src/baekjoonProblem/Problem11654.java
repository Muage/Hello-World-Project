package baekjoonProblem;

import java.util.*;

// 문제 ( 문자열 단계 )
// 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.

// 입력
// 알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.

// 출력
// 입력으로 주어진 글자의 아스키 코드 값을 출력한다.

// 예제 입력
// (1) A
// (2) C
// (3) 0
// (4) 9
// (5) a
// (6) z

// 예제 출력
// (1) 65
// (2) 67
// (3) 48
// (4) 57
// (5) 97
// (6) 122

public class Problem11654 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String x = scanner.next();
		int ascii = Integer.valueOf(x.charAt(0));
		System.out.println(ascii);
		
		scanner.close();
	}
	
}
