package baekjoonProblem;

import java.util.*;

// ����
// �׷� �ܾ�� �ܾ �����ϴ� ��� ���ڿ� ���ؼ�, �� ���ڰ� �����ؼ� ��Ÿ���� ��츸�� ���Ѵ�.
// ���� ���, ccazzzzbb�� c, a, z, b�� ��� �����ؼ� ��Ÿ����, kin�� k, i, n�� �����ؼ� ��Ÿ���� ������ �׷� �ܾ�������, aabbbccb�� b�� �������� ��Ÿ���� ������ �׷� �ܾ �ƴϴ�.
// �ܾ� N���� �Է����� �޾� �׷� �ܾ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� �ܾ��� ���� N�� ���´�.
// N�� 100���� �۰ų� ���� �ڿ����̴�.
// ��° �ٺ��� N���� �ٿ� �ܾ ���´�.
// �ܾ�� ���ĺ� �ҹ��ڷθ� �Ǿ��ְ� �ߺ����� ������, ���̴� �ִ� 100�̴�.

// ���
// ù° �ٿ� �׷� �ܾ��� ������ ����Ѵ�.

// ���� �Է�
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

// ���� ���
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