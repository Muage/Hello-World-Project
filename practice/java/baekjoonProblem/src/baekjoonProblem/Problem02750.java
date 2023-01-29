package baekjoonProblem;

import java.util.Scanner;

// 문제 ( 정렬 단계 )
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 수가 주어진다.
// 이 수는 절댓값이 1,000보다 작거나 같은 정수이다.
// 수는 중복되지 않는다.

// 출력
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

// 예제 입력
// 5
// 5
// 2
// 3
// 4
// 1

// 예제 출력
// 1
// 2
// 3
// 4
// 5

public class Problem02750 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int temp = 0;
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}

		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		scanner.close();
	}

}
