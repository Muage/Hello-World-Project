package baekjoonProblem;

import java.util.*;

// ���� ( �⺻ ���� 2 �ܰ� )
// ���� N�� �־����� ��, ���μ������ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ���� N (1 �� N �� 10,000,000)�� �־�����.

// ���
// N�� ���μ����� ����� �� �ٿ� �ϳ��� ������������ ����Ѵ�.
// N�� 1�� ��� �ƹ��͵� ������� �ʴ´�.

// ���� �Է�
// (1)	72
// (2)	3
// (3)	6
// (4)	2
// (5)	9991

// ���� ���
// (1)	2
// 		2
// 		2
// 		3
// 		3
// (2)	3
// (3)	2
// 		3
// (4)	2
// (5)	97
// 		103

public class Problem11653 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			while(n % i == 0) {
				System.out.println(i);
				n /= i;
			}
		}
		if(n != 1) {
			System.out.println(n);
		}
		
		scanner.close();
	}
	
}
