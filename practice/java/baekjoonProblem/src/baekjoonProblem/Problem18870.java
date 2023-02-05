package baekjoonProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 문제 ( 정렬 단계 )
// 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
// Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
// X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

// 입력
// 첫째 줄에 N이 주어진다.
// 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

// 출력
// 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

// 제한
// 1. 1 ≤ N ≤ 1,000,000
// 2. -109 ≤ Xi ≤ 109

// 예제 입력
// (1)	5
// 		2 4 -10 4 -9
// (2)	6
// 		1000 999 1000 999 1000 999

// 예제 출력
// (1)	2 3 0 3 1
// (2)	1 0 1 0 1 0

public class Problem18870 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int rank = 0;
		int[] origin = new int[n];
		int[] sorted = new int[n];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++) {
			sorted[i] = origin[i] = scanner.nextInt();
		}
		
		Arrays.sort(sorted);
		
		for(int value : sorted) {
			if(!map.containsKey(value)) {
				map.put(value, rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int key : origin) {
			int ranking = map.get(key);
			sb.append(ranking).append(" ");
		}
		
		System.out.println(sb);
		
		scanner.close();
	}

}
