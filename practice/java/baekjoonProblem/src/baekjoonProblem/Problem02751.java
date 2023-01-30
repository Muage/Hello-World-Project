package baekjoonProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 문제 ( 정렬 단계 )
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 수가 주어진다.
// 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다.
// 수는 중복되지 않는다.

// 출력
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

// 예제 입력
// 5
// 5
// 4
// 3
// 2
// 1

// 예제 출력
// 1
// 2
// 3
// 4
// 5

public class Problem02751 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int n = Integer.valueOf(reader.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(Integer.valueOf(reader.readLine()));
		}
		
		Collections.sort(list);
		
		for(int num : list) {
			builder.append(num).append("\n");
		}
		
		System.out.println(builder);
	}

}
