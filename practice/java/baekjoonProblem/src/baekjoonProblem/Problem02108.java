package baekjoonProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 문제 ( 정렬 단계 )
// 수를 처리하는 것은 통계학에서 상당히 중요한 일이다.
// 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다.
// 단, N은 홀수라고 가정하자.
// 1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
// 2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
// 3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
// 4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
// N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
// 단, N은 홀수이다.
// 그 다음 N개의 줄에는 정수들이 주어진다.
// 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

// 출력
// 첫째 줄에는 산술평균을 출력한다.
// 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
// 둘째 줄에는 중앙값을 출력한다.
// 셋째 줄에는 최빈값을 출력한다.
// 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
// 넷째 줄에는 범위를 출력한다.

// 예제 입력
// (1)	5
// 		1
// 		3
// 		8
// 		-2
// 		2
// (2)	1
// 		4000
// (3)	5
// 		-1
// 		-2
// 		-3
// 		-1
// 		-2
// (4)	3
// 		0
// 		0
// 		-1

// 예제 출력
// (1)	2
// 		2
// 		1
// 		10
// (2)	4000
// 		4000
// 		4000
// 		0
// (3)	-2
// 		-2
// 		-1
// 		2
// (4)	0
// 		0
// 		0
// 		1

public class Problem02108 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int sum = 0;
		int max = 0;
		int[] arr = new int[n];
		int[] plus = new int[4002];
		int[] minus = new int[4001];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		
		// 산술평균
		for(int i = 0; i < n; i++) {
			sum += arr[i];
		}
		System.out.println((int)Math.round((double)sum / n));
		
		// 중앙값
		Arrays.sort(arr);
		System.out.println(arr[n / 2]);
		
		// 최빈값
		for(int i = 0; i < n; i++) {
			if(arr[i] < 0) {
				minus[Math.abs(arr[i])]++;
			} else {
				plus[arr[i]]++;
			}
		}
		
		for(int i = 0; i < plus.length; i++) {
			max = Math.max(max, plus[i]);
		}
		
		for(int i = 0; i < minus.length; i++) {
			max = Math.max(max, minus[i]);
		}
		
		for(int i : arr) {
			if(i < 0) {
				if(minus[Math.abs(i)] == max && !(list.contains(i))) {
					list.add(i);
				}
			} else {
				if(plus[i] == max && !(list.contains(i))) {
					list.add(i);
				}
			}
		}
		
		if(list.size() >= 2) {
			System.out.println(list.get(1));
		} else {
			System.out.println(list.get(0));
		}
		
		// 범위
		System.out.println(arr[n - 1] - arr[0]);
		
		scanner.close();
	}

}
