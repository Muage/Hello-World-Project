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
		
		int[] alphabet = new int[52];
		for(int i = 0; i < 52; i++) {
			alphabet[i] = 0;
		}
		
		String word = scanner.next();
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) > 90) {
				int ascii = Integer.valueOf(word.charAt(i) - 'a' + 26);
				alphabet[ascii] += 1;
			}
			
			if(word.charAt(i) < 90) {
				int ascii = Integer.valueOf(word.charAt(i) - 'A');
				alphabet[ascii] += 1;
			}
		}
		
		for(int i = 0; i < 52; i++) {
			int max = 0;
			if(alphabet[i] > max) {
				max = alphabet[i];
				if(alphabet[i] > 25) {
					System.out.println((char)alphabet[i] + 'a' + 26);
				} else {
					System.out.println((char)alphabet[i] + 'A');
				}
			} else if(alphabet[i] == max) {
				System.out.println("?");
			}
		}
		
		scanner.close();
	}

}
