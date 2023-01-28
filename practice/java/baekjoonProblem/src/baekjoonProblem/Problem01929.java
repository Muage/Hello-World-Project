package baekjoonProblem;

import java.util.*;

// 문제 ( 기본 수학 2 단계 )
// M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다.
// (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

// 출력
// 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

// 예제 입력
// 3 16

// 예제 출력
// 3
// 5
// 7
// 11
// 13

public class Problem01929 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		boolean[] arr = new boolean[n + 1];
		
		arr[0] = true;
		arr[1] = true;
		
		for(int i = 2; i < Math.sqrt(n + 1); i++) {
			for(int j = i * i; j < n + 1; j += i) {
				arr[j] = true;
			}
		}
		
		for(int i = m; i < n + 1; i++) {
			if(arr[i] == false) System.out.println(i);
		}
		
		scanner.close();
	}

}
