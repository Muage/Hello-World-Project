package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 ( Lv1. 주행거리 비교하기 )
// 현대자동차그룹의 연구원인 영호는 자동차의 주행거리를 비교하는 프로그램을 만들고 있다.
// 두 차량 A와 B의 주행거리가 자연수로 주어졌을 때, 주행거리를 비교해서 어느 차량의 주행거리가 더 큰지 알아보자.

// 제약조건
// 0 ≤ A,B ≤ 100,000

// 입력형식
// 첫째줄에 두차량 A,B의 주행거리가 한칸의 공백을 두고 주어진다.

// 출력형식
// 주행거리를 비교해서 첫째줄에 아래의 글자를 출력한다.
// - A가 B 보다 큰 경우 A를 출력한다.
// - A가 B 보다 작은 경우 B를 출력한다.
// - A와 B의 주행거리가 같은 경우 same을 출력한다.

// 입력예제
// (1)	3500 2000
// (2)	1500 1800
// (3)	5000 5000

// 출력예제
// (1)	A
// (2)	B
// (3)	same

public class Lv1_distance_compare {
	
	public static void main(String[] args) throws Exception {
		/*
		 * 방법 5. 득점: 100.0		실행시간: 66ms		메모리: 10.21Mb
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int A = Integer.valueOf(st.nextToken());
		int B = Integer.valueOf(st.nextToken());
		int result = Integer.compare(A, B);
		
		if(result == 1) {
			System.out.println("A");
		} else if(result == 0) {
			System.out.println("same");
		} else if(result == -1) {
			System.out.println("B");
		}
		
		
		/*
		 * 방법 4. 득점: 100.0		실행시간: 67ms		메모리: 10.33Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		
//		int A = Integer.valueOf(st.nextToken());
//		int B = Integer.valueOf(st.nextToken());
//		int result = Integer.compare(A, B);
//		
//		switch(result) {
//			case 1:
//				System.out.println("A");
//				break;
//			case 0:
//				System.out.println("same");
//				break;
//			case -1:
//				System.out.println("B");
//				break;
//		}
		
		
		/*
		 * 방법 3. 득점: 100.0		실행시간: 73ms		메모리: 10.21Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		StringBuffer sb = new StringBuffer();
//		
//		int A = Integer.valueOf(st.nextToken());
//		int B = Integer.valueOf(st.nextToken());
//		
//		if(A > B) {
//			sb.append("A");
//		} else if(B > A) {
//			sb.append("B");
//		} else {
//			sb.append("same");
//		}
//		
//		System.out.println(sb);
		
		
		/*
		 * 방법 2. 득점: 100.0		실행시간: 67ms		메모리: 10.21Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		
//		int A = Integer.valueOf(st.nextToken());
//		int B = Integer.valueOf(st.nextToken());
//		String result;
//		
//		if(A > B) {
//			result = "A";
//		} else if(B > A) {
//			result = "B";
//		} else {
//			result = "same";
//		}
//		
//		System.out.println(result);
		
		
		/*
		 * 방법 1. 득점: 100.0		실행시간: 113ms	메모리: 11.96Mb
		 */
//		Scanner scanner = new Scanner(System.in);
//		
//		int A = scanner.nextInt();
//		int B = scanner.nextInt();
//		String result;
//		
//		if(A > B) {
//			result = "A";
//		} else if(B > A) {
//			result = "B";
//		} else {
//			result = "same";
//		}
//		
//		System.out.println(result);
//		
//		scanner.close();
	}

}