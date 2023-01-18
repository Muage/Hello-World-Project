package baekjoonProblem;

import java.util.*;

// 문제
// 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
// 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
// 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 단어의 개수 N이 들어온다.
// N은 100보다 작거나 같은 자연수이다.
// 둘째 줄부터 N개의 줄에 단어가 들어온다.
// 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

// 출력
// 첫째 줄에 그룹 단어의 개수를 출력한다.

// 예제 입력
// (1)	3
// 		happy
// 		new
// 		year
// (2)	4
// 		aba
// 		abab
// 		abcabc
// 		a
// (3)	5
// 		ab
// 		aa
// 		aca
// 		ba
// 		bb
// (4)	2
// 		yzyzy
// 		zyzyz
// (5)	1
// 		z

// 예제 출력
// (1)	3
// (2)	1
// (3)	4
// (4)	0
// (5)	1

public class Problem01316 {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int count = 0;
		int n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			if(check() == true) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean check() {
		int prev = 0;
		boolean[] check = new boolean[26];
		String word = scanner.next();
		
		for(int i = 0; i < word.length(); i++) {
			int now = word.charAt(i);
			
			if(prev != now) {
				if(check[now - 'a'] == false) {
					check[now - 'a'] = true;
					prev = now;
				} else {
					return false;
				}
			} else {
				continue;
			}
		}
		return true;
	}

}