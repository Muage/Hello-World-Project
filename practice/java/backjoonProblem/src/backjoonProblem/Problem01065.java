package backjoonProblem;

import java.util.*;

// 문제
// 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
// 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
// N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

// 출력
// 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.

// 예제 입력
// (1) 110
// (2) 1
// (3) 210
// (4) 1000
// (5) 500

// 예제 출력
// (1) 99
// (2) 1
// (3) 105
// (4) 144
// (5) 119

public class Problem01065 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(x(n));
		scanner.close();
	}
	
	public static int x(int n) {
		int count = 0;
		
		if(n < 100) {
			count = n;
		} else if(n > 100) {
			count = 99;
			for(int i = 100; i < n + 1; i++) {
				String temp = Integer.toString(i);
				int[] tempArr = new int[temp.length()];
				for(int j = 0; j < 3; j++) {
					tempArr[j] = temp.charAt(j) - '0';
				}
				
				if((tempArr[1] * 2) == (tempArr[0] + tempArr[2])) {
					count++;
				}
			}
		}
		
		return count;
	}

}