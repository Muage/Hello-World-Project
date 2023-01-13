package baekjoonProblem;

import java.util.*;

// 문제
// 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
// 단, 대문자와 소문자를 구분하지 않는다.

// 입력
// 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다.
// 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

// 출력
// 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
// 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

// 예제 입력
// (1) Mississipi
// (2) zZa
// (3) z
// (4) baaa

// 예제 출력
// (1) ?
// (2) Z
// (3) z
// (4) A

public class Problem01157 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] alphabet = new int[26];
		
		String word = scanner.next();
		for(int i = 0; i < word.length(); i++) {
			int ascii = 0;
			if(word.charAt(i) >= 'a') {
				ascii = Integer.valueOf(word.charAt(i) - 'a');
				alphabet[ascii]++;
			} else if(word.charAt(i) >= 'A') {
				ascii = Integer.valueOf(word.charAt(i) - 'A');
				alphabet[ascii]++;
			}
		}
		
		int max = 0;
		char result = 0;
		for(int i = 0; i < 26; i++) {
			if(alphabet[i] > max) {
				max = alphabet[i];
				result = (char)(i + 'A');
			} else if(alphabet[i] == max) {
				result = '?';
			}
		}
		
		System.out.println(result);
		
		scanner.close();
	}

}
