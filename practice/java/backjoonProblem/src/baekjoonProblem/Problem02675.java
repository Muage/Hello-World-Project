package baekjoonProblem;

import java.util.*;

// ����
// ���ڿ� S�� �Է¹��� �Ŀ�, �� ���ڸ� R�� �ݺ��� �� ���ڿ� P�� ���� �� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
// ��, ù ��° ���ڸ� R�� �ݺ��ϰ�, �� ��° ���ڸ� R�� �ݺ��ϴ� ������ P�� ����� �ȴ�.
// S���� QR Code "alphanumeric" ���ڸ� ����ִ�.
// QR Code "alphanumeric" ���ڴ� 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: �̴�.

// �Է�
// ù° �ٿ� �׽�Ʈ ���̽��� ���� T(1 �� T �� 1,000)�� �־�����.
// �� �׽�Ʈ ���̽��� �ݺ� Ƚ�� R(1 �� R �� 8), ���ڿ� S�� �������� ���еǾ� �־�����.
// S�� ���̴� ��� 1�̸�, 20���ڸ� ���� �ʴ´�. 

// ���
// �� �׽�Ʈ ���̽��� ���� P�� ����Ѵ�.

// ���� �Է�
// 2
// 3 ABC
// 5 /HTP

// ���� ���
// AAABBBCCC
// /////HHHHHTTTTTPPPPP

public class Problem02675 {
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		for(int i = 0; i < t; i++) {
			int r = scanner.nextInt();
			String word = scanner.next();
			
			for(int j = 0; j < word.length(); j++) {
				for(int k = 0; k < r; k++) {
					System.out.print(word.charAt(j));
				}
			}
			System.out.println("");
		}
		
		scanner.close();
		
	}

}
