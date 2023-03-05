package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

// 문제 ( Lv2. 전광판 )
// 현대차그룹에 다니는 당신은 전세계 유가 변동에 대해 실시간으로 파악하기 위해 사무실에 유가를 실시간으로 표시하는 전광판을 설치하였다.
// 전광판은 최대 다섯 자리의 자연수만을 표시할 수 있도록, 아래와 같이 육각형 모양의 전구 7×5=35개로 구성되어 있다.
// 8자 모양의 전구 묶음은 0부터 9까지의 숫자를 표현할 수 있으며, 표현 방법은 아래와 같다.
// 아래 그림에서 전구가 켜졌으면 검정색, 꺼졌으면 옅은 회색으로 표현되었다.
// 예를 들어, 전광판을 통해 9881를 표현하면 아래와 같다.
// 만의 자리 수가 없기 때문에, 만의 자리에 해당하는 전구들이 모두 꺼져 있음에 유의하라.
// 예를 들어, 전광판을 통해 10724를 표현하면 아래와 같다.
// 각각의 전구에는 스위치가 달려 있다.
// 전구에 달려 있는 스위치를 누를 때, 그 전구가 켜져 있었다면 꺼지고, 그 전구가 꺼져 있었다면 켜진다.
// 지금 전광판에 자연수 A가 표시되어 있는데, 유가가 변동됨에 따라 전광판에 표시된 자연수를 B로 바꿔야 한다.
// 이러한 목표를 달성하기 위해 스위치를 최소 몇 번 눌러야 하는지를 구하는 프로그램을 작성하라.

// 제약조건
// 하나의 입력에서 1개 이상 1000개 이하의 테스트 케이스를 해결해야 한다.
// A와 B는 한 자리 이상 다섯 자리 이하의 자연수이다.
// A와 B는 숫자 0으로 시작하지 않는다.
// A와 B는 서로 다르다.

// 입력형식
// 첫 번째 줄에 해결할 테스트 케이스의 수 T가 주어진다.
// 다음 T개의 줄에는 한 줄에 테스트 케이스 하나씩이 주어진다.
// 각각의 줄에는 두 자연수 A와 B가 공백 하나를 사이로 두고 주어진다.

// 출력형식
// 각각의 테스트 케이스마다 순서대로, 스위치를 눌러야 하는 최소 횟수를 한 줄에 하나씩 출력한다.

// 입력예제1
// 2
// 1 2
// 9881 10724

// 출력예제1
// 5
// 11

// 입력예제2
// 2
// 111 11
// 11 11111

// 출력예제2
// 2
// 6

public class Lv2_billboard {
	
	/*
	 * 다른 사람 코드
	 * 방법 2. 득점: 100.0		실행시간: 124ms		메모리: 12.06Mb
	 */
	private static Map<Integer, int[]> num;
	
	private static int sum(int a) {
		int count = 0;

		int[] number = num.get(a);
		
		for(int i = 0; i < 7; i++) {
			count += number[i];
		}
		
		return count;
	}
	
	private static int compare(int a, int b) {
		int count = 0;
		
		int[] arr_A = num.get(a);
		int[] arr_B = num.get(b);
		
		for(int i = 0; i < 7; i++) {
			if(arr_A[i] != arr_B[i]) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		num = new HashMap<>();
		num.put(0, new int[] {1, 1, 1, 1, 1, 1, 0});
		num.put(1, new int[] {0, 1, 1, 0, 0, 0, 0});
		num.put(2, new int[] {1, 1, 0, 1, 1, 0, 1});
		num.put(3, new int[] {1, 1, 1, 1, 0, 0, 1});
		num.put(4, new int[] {0, 1, 1, 0, 0, 1, 1});
		num.put(5, new int[] {1, 0, 1, 1, 0, 1, 1});
		num.put(6, new int[] {1, 0, 1, 1, 1, 1, 1});
		num.put(7, new int[] {1, 1, 1, 0, 0, 1, 0});
		num.put(8, new int[] {1, 1, 1, 1, 1, 1, 1});
		num.put(9, new int[] {1, 1, 1, 1, 0, 1, 1});
		
		int T = Integer.valueOf(reader.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(reader.readLine());
			
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			
			int[] arr_A = {-1, -1, -1, -1, -1};
			int[] arr_B = {-1, -1, -1, -1, -1};
			
			for(int j = 0; j < 5; j++) {
				arr_A[j] = A % 10;
				A /= 10;
				if(A == 0) break;
			}
			
			for(int j = 0; j < 5; j++) {
				arr_B[j] = B % 10;
				B /= 10;
				if(B == 0) break;
			}
			
			int count = 0;
			
			for(int j = 0; j < 5; j++) {
				if(arr_A[j] != arr_B[j]) {
					if(arr_A[j] == -1) {
						count += sum(arr_B[j]);
					} else if(arr_B[j] == -1) {
						count += sum(arr_A[j]);
					} else {
						count += compare(arr_A[j], arr_B[j]);
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	
	/*
	 * 다시 풀어보기
	 * 방법 1. 득점: 0.0		실행시간: 124ms		메모리: 12.06Mb
	 */
//	private static int compare(int a, int b) {
//		Map<Integer, boolean[]> num = new HashMap<>();
//		num.put(0, new boolean[] {true, true, true, true, true, true, false});
//		num.put(1, new boolean[] {false, true, true, false, false, false, false});
//		num.put(2, new boolean[] {true, true, false, true, true, false, true});
//		num.put(3, new boolean[] {true, true, true, true, false, false, true});
//		num.put(4, new boolean[] {false, true, true, false, false, true, true});
//		num.put(5, new boolean[] {true, false, true, true, false, true, true});
//		num.put(6, new boolean[] {true, false, true, true, true, true, true});
//		num.put(7, new boolean[] {true, true, true, false, false, true, false});
//		num.put(8, new boolean[] {true, true, true, true, true, true, true});
//		num.put(9, new boolean[] {true, true, true, true, false, true, true});
//		num.put(10, new boolean[] {false, false, false, false, false, false, false});
//		
//		int count = 0;
//		
//		if(a == 10 && b != 10) {
//			for(int i = 0; i < 7; i++) {
//				if(num.get(b)[i] == true) {
//					count++;
//				}
//			}
//		}
//		
//		if(a != 10 && b == 10) {
//			for(int i = 0; i < 7; i++) {
//				if(num.get(a)[i] == true) {
//					count++;
//				}
//			}
//		}
//		
//		if(a != 10 && b != 10) {
//			for(int i = 0; i < 7; i++) {
//				if(num.get(a)[i] != num.get(b)[i]) {
//					count++;
//				}
//			}
//		}
//		
//		return count;
//	}
//	
//	public static void main(String[] args) throws Exception{
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		int T = Integer.valueOf(reader.readLine());
//		int a = 0;
//		int b = 0;
//		int count = 0;
//		
//		for(int i = 0; i < T; i++) {
//			st = new StringTokenizer(reader.readLine());
//			
//			String A = st.nextToken();
//			String B = st.nextToken();
//			
//			int[] arr_A = new int[A.length()];
//			int[] arr_B = new int[B.length()];
//			
//			for(int j = 0; j < A.length(); j++) {
//				arr_A[j] = Integer.valueOf(A.charAt(j) - '0');
//			}
//			for(int j = 0; j < B.length(); j++) {
//				arr_B[j] = Integer.valueOf(B.charAt(j) - '0');
//			}
//			
//			Stack<Integer> stack_A = new Stack<>();
//			Stack<Integer> stack_B = new Stack<>();
//			
//			for(int j = 0; j < arr_A.length; j++) {
//				stack_A.add(arr_A[j]);
//			}
//			
//			for(int j = 0; j < arr_B.length; j++) {
//				stack_B.add(arr_B[j]);
//			}
//			
//			if(stack_A.isEmpty()) {
//				a = 10;
//			} else {
//				a = stack_A.pop();
//			}
//			
//			if(stack_B.isEmpty()) {
//				b = 10;
//			} else {
//				b = stack_B.pop();
//			}
//			
//			count += compare(a, b);
//			
//			System.out.println(count);
//		}
//	}

}
