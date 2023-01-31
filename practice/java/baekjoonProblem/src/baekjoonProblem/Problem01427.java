package baekjoonProblem;

import java.util.Arrays;
import java.util.Scanner;

// 문제 ( 정렬 단계 )
// 배열을 정렬하는 것은 쉽다.
// 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

// 입력
// 첫째 줄에 정렬하려고 하는 수 N이 주어진다.
// N은 1,000,000,000보다 작거나 같은 자연수이다.

// 출력
// 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

// 예제 입력
// (1)	2143
// (2)	999998999
// (3)	61423
// (4)	500613009

// 예제 출력
// (1)	4321
// (2)	999999998
// (3)	64321
// (4)	965310000

public class Problem01427 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int temp = 0;
		String n = scanner.next();
		int[] arr = new int[n.length()];
		
		for(int i = 0; i < n.length(); i++) {
			arr[i] = n.charAt(i) - '0';
		}
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		
		scanner.close();
	}

}