package baekjoonProblem;

import java.util.*;

// ����
// N���� ���ڰ� ���� ���� �����ִ�.
// �� ���ڸ� ��� ���ؼ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ������ ���� N (1 �� N �� 100)�� �־�����.
// ��° �ٿ� ���� N���� ������� �־�����.

// ���
// �Է����� �־��� ���� N���� ���� ����Ѵ�.

// ���� �Է�
// (1)	1
// 		1
// (2)	5
// 		54321
// (3)	25
// 		7000000000000000000000000
// (4)	11
// 		10987654321

// ���� ���
// (1)	1
// (2)	15
// (3)	7
// (4)	46

public class Problem11720 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int sum = 0;
		int n = scanner.nextInt();
		int[] arrNum = new int[n];
		String num = scanner.next();
		
		for(int i = 0; i < n; i++) {
			arrNum[i] = Integer.valueOf(num.charAt(i) - '0');
			sum += arrNum[i];
		}
		
		System.out.println(sum);
		
		scanner.close();
	}

}
