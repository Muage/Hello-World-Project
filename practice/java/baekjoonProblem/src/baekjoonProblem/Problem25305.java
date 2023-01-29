package baekjoonProblem;

import java.util.Scanner;

// 문제 ( 정렬 단계 )
// 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 N명의 학생들이 응시했다.
// 이들 중 점수가 가장 높은 k명은 상을 받을 것이다.
// 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
// 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.

// 입력
// 첫째 줄에는 응시자의 수 N과 상을 받는 사람의 수 k가 공백을 사이에 두고 주어진다.
// 둘째 줄에는 각 학생의 점수 x가 공백을 사이에 두고 주어진다.

// 출력
// 상을 받는 커트라인을 출력하라.

// 제한
// 1 ≤ N ≤ 1000
// 1 ≤ k ≤ N
// 0 ≤ x ≤ 10000

// 예제 입력
// 5 2
// 100 76 85 93 98

// 예제 출력
// 98

public class Problem25305 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int temp = 0;
		int[] score = new int[n];
		
		for(int i = 0; i < n; i++) {
			score[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(score[i] < score[j]) {
					temp = score[j];
					score[j] = score[i];
					score[i] = temp;
				}
			}
		}
		
		System.out.println(score[k - 1]);
		
		scanner.close();
	}

}
