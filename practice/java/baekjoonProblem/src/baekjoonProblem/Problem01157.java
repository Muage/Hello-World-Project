package baekjoonProblem;

import java.util.*;

// ����
// ���ĺ� ��ҹ��ڷ� �� �ܾ �־�����, �� �ܾ�� ���� ���� ���� ���ĺ��� �������� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.
// ��, �빮�ڿ� �ҹ��ڸ� �������� �ʴ´�.

// �Է�
// ù° �ٿ� ���ĺ� ��ҹ��ڷ� �̷���� �ܾ �־�����.
// �־����� �ܾ��� ���̴� 1,000,000�� ���� �ʴ´�.

// ���
// ù° �ٿ� �� �ܾ�� ���� ���� ���� ���ĺ��� �빮�ڷ� ����Ѵ�.
// ��, ���� ���� ���� ���ĺ��� ���� �� �����ϴ� ��쿡�� ?�� ����Ѵ�.

// ���� �Է�
// (1) Mississipi
// (2) zZa
// (3) z
// (4) baaa

// ���� ���
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
