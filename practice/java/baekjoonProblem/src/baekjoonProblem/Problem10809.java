package baekjoonProblem;

import java.util.*;

// ����
// ���ĺ� �ҹ��ڷθ� �̷���� �ܾ� S�� �־�����.
// ������ ���ĺ��� ���ؼ�, �ܾ ���ԵǾ� �ִ� ��쿡�� ó�� �����ϴ� ��ġ��, ���ԵǾ� ���� ���� ��쿡�� -1�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� �ܾ� S�� �־�����.
// �ܾ��� ���̴� 100�� ���� ������, ���ĺ� �ҹ��ڷθ� �̷���� �ִ�.

// ���
// ������ ���ĺ��� ���ؼ�, a�� ó�� �����ϴ� ��ġ, b�� ó�� �����ϴ� ��ġ, ... z�� ó�� �����ϴ� ��ġ�� �������� �����ؼ� ����Ѵ�.
// ����, � ���ĺ��� �ܾ ���ԵǾ� ���� �ʴٸ� -1�� ����Ѵ�.
// �ܾ��� ù ��° ���ڴ� 0��° ��ġ�̰�, �� ��° ���ڴ� 1��° ��ġ�̴�.

// ���� �Է�
// (1) baekjoon

// ���� ���
// (1) 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1

public class Problem10809 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] alphabet = new int[26];
		for(int i = 0; i < 26; i++) {
			alphabet[i] = -1;
		}
		
		String word = scanner.next();
		for(int i = 0; i < word.length(); i++) {
			int ascii = Integer.valueOf(word.charAt(i) - 'a');
			
			if(alphabet[ascii] == -1) {
				alphabet[ascii] = i;
			}
		}
		
		for(int i = 0; i < 26; i++) {
			System.out.print(alphabet[i] + " ");
		}
		
		scanner.close();
	}

}