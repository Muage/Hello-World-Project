package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 문제 ( Lv2. 금고털이 )
// 루팡은 배낭을 하나 메고 은행금고에 들어왔다.
// 금고 안에는 값비싼 금, 은, 백금 등의 귀금속 덩어리가 잔뜩 들어있다.
// 배낭은 W ㎏까지 담을 수 있다.
// 각 금속의 무게와 무게당 가격이 주어졌을 때 배낭을 채울 수 있는 가장 값비싼 가격은 얼마인가?
// 루팡은 전동톱을 가지고 있으며 귀금속은 톱으로 자르면 잘려진 부분의 무게만큼 가치를 가진다.

// 제약조건
// 1 ≤ N ≤ 10^6인 정수
// 1 ≤ W ≤ 10^4인 정수
// 1 ≤ M_i, P_i ≤ 10^4인 정수

// 입력형식
// 첫 번째 줄에 배낭의 무게 W와 귀금속의 종류 N이 주어진다.
// i + 1 (1 ≤ i ≤ N)번째 줄에는 i번째 금속의 무게 M_i와 무게당 가격 P_i가 주어진다.

// 출력형식
// 첫 번째 줄에 배낭에 담을 수 있는 가장 비싼 가격을 출력하라.

// 입력예제
// 100 2
// 90 1
// 70 2

// 출력예제
// 170

public class Lv2_safebreaking {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(reader.readLine());
		
		int w = Integer.valueOf(st.nextToken());
		int n = Integer.valueOf(st.nextToken());
		int price = 0;
		int[][] arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			
			arr[i][0] = Integer.valueOf(st.nextToken());
			arr[i][1] = Integer.valueOf(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
		for(int[] item : arr) {
			if(w > item[0]) {
				price += item[0] * item[1];
				 w -= item[0];
			} else {
				price += w * item[1];
				break;
			}
		}
		
		System.out.println(price);
	}

}
