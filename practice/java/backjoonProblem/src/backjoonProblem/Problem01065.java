package backjoonProblem;

import java.util.*;

// ����
// � ���� ���� X�� �� �ڸ��� ���������� �̷�ٸ�, �� ���� �Ѽ���� �Ѵ�.
// ���������� ���ӵ� �� ���� ���� ���̰� ������ ������ ���Ѵ�.
// N�� �־����� ��, 1���� ũ�ų� ����, N���� �۰ų� ���� �Ѽ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� 1,000���� �۰ų� ���� �ڿ��� N�� �־�����.

// ���
// ù° �ٿ� 1���� ũ�ų� ����, N���� �۰ų� ���� �Ѽ��� ������ ����Ѵ�.

// ���� �Է�
// (1) 110
// (2) 1
// (3) 210
// (4) 1000
// (5) 500

// ���� ���
// (1) 99
// (2) 1
// (3) 105
// (4) 144
// (5) 119

public class Problem01065 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(x(n));
		scanner.close();
	}
	
	public static int x(int n) {
		int count = 0;
		
		if(n < 100) {
			count = n;
		} else if(n > 100) {
			count = 99;
			for(int i = 100; i < n + 1; i++) {
				String temp = Integer.toString(i);
				int[] tempArr = new int[temp.length()];
				for(int j = 0; j < 3; j++) {
					tempArr[j] = temp.charAt(j) - '0';
				}
				
				if((tempArr[1] * 2) == (tempArr[0] + tempArr[2])) {
					count++;
				}
			}
		}
		
		return count;
	}

}