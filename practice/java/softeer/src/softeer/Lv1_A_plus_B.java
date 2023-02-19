package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 ( Lv1. A + B )
// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

// 제약조건
// 두 정수 A와 B는 1이상 9이하의 정수이다.

// 입력형식
// 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
// 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다.

// 출력형식
// 각 테스트 케이스마다 "Case #(테스트 케이스 번호): "를 출력한 다음, A+B를 출력한다.
// 테스트 케이스 번호는 1부터 시작한다.

// 입력예제
// 5
// 1 1
// 2 3
// 3 4
// 9 8
// 5 2

// 출력예제
// Case #1: 2
// Case #2: 5
// Case #3: 7
// Case #4: 17
// Case #5: 7

public class Lv1_A_plus_B {
	
	public static void main(String[] args) throws Exception {
		/*
		 * 방법 2. 득점: 100.0		실행시간: 130ms		메모리: 13.82Mb
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.valueOf(reader.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(reader.readLine());
			
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			
			System.out.println("Case #" + (i + 1) + ": " + (A + B));
		}
		
		
		/*
		 * 방법 1. 득점: 100.0		실행시간: 167ms		메모리: 15.2Mb
		 */
//		Scanner scanner = new Scanner(System.in);
//		
//		int T = scanner.nextInt();
//		
//		for(int i = 0; i < T; i++) {
//			int A = scanner.nextInt();
//			int B = scanner.nextInt();
//		
//			System.out.println("Case #" + (i + 1) + ": " + (A + B));
//		}
//		
//		scanner.close();
	}

}
