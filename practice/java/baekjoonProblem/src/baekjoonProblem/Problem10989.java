package baekjoonProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 문제 ( 정렬 단계 )
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 수가 주어진다.
// 이 수는 10,000보다 작거나 같은 자연수이다.

// 출력
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

// 예제 입력
// 10
// 5
// 2
// 3
// 1
// 4
// 2
// 3
// 5
// 1
// 7

// 예제 출력
// 1
// 1
// 2
// 2
// 3
// 3
// 4
// 5
// 5
// 7

public class Problem10989 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int n = Integer.valueOf(reader.readLine());
		int[] list = new int[n];
		
		for(int i = 0; i < n; i++) {
			list[i] = Integer.valueOf(reader.readLine());
		}
		
		Arrays.sort(list);
		
		for(int i = 0; i < n; i++) {
			builder.append(list[i] + "\n");
		}
		
		System.out.println(builder);
	}

}