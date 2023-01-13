package baekjoonProblem;

import java.util.*;

// 문제
// N개의 숫자가 공백 없이 쓰여있다.
// 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다.
// 둘째 줄에 숫자 N개가 공백없이 주어진다.

// 출력
// 입력으로 주어진 숫자 N개의 합을 출력한다.

// 예제 입력
// (1)	1
// 		1
// (2)	5
// 		54321
// (3)	25
// 		7000000000000000000000000
// (4)	11
// 		10987654321

// 예제 출력
// (1)	1
// (2)	15
// (3)	7
// (4)	46

public class Problem11720 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int sum = 0;
		int n = scanner.nextInt();
		int[] arrNum = new int[n];
		String num = scanner.next();
		
		for(int i = 0; i < n; i++) {
			arrNum[i] = Integer.valueOf(num.charAt(i) - '0');
			sum += arrNum[i];
		}
		
		System.out.println(sum);
		
		scanner.close();
	}

}
