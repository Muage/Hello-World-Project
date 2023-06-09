package baekjoonProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 문제 ( 정렬 단계 )
// 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
// 1. 길이가 짧은 것부터
// 2. 길이가 같으면 사전 순으로

// 입력
// 첫째 줄에 단어의 개수 N이 주어진다.
// (1 ≤ N ≤ 20,000)
// 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
// 주어지는 문자열의 길이는 50을 넘지 않는다.

// 출력
// 조건에 따라 정렬하여 단어들을 출력한다.
// 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.

// 예제 입력
// 13
// but
// i
// wont
// hesitate
// no
// more
// no
// more
// it
// cannot
// wait
// im
// yours

// 예제 출력
// i
// im
// it
// no
// but
// more
// wait
// wont
// yours
// cannot
// hesitate

public class Problem01181 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		String[] arr = new String[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = scanner.next();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		});
		
		System.out.println(arr[0]);
		
		for(int i = 1; i < n; i++) {
			if(!arr[i].equals(arr[i - 1])) {
				System.out.println(arr[i]);
			}
		}
		
		scanner.close();
	}

}
