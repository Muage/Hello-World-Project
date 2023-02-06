package baekjoonProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Scanner;

// 문제 ( 재귀 단계 )
// 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.

// 출력
// 첫째 줄에 N!을 출력한다.

// 예제 입력
// (1) 10
// (2) 0

// 예제 출력
// (1) 3628800
// (2) 1

public class Problem10872 {
	
	public static void main(String[] args) throws Exception {
		/** Scanner VS BufferedReader 메모리, 시간 비교 */
		
		/* Scanner - 17648KB, 208ms */
//		Scanner scanner = new Scanner(System.in);
//		
//		int n = scanner.nextInt();
//		int result = 1;
//		
//		if(n == 0) {
//			System.out.println(result);
//		} else {
//			for(int i = 1; i <= n; i++) {
//				result *= i;
//			}
//			
//			System.out.println(result);
//		}
//		
//		scanner.close();
		
		/* BufferedReader - 14084KB, 124ms */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(reader.readLine());
		int result = 1;
		
		if(n == 0) {
			System.out.println(result);
		} else {
			for(int i = 1; i <= n; i++) {
				result *= i;
			}
			
			System.out.println(result);
		}
	}

}