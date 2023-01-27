package baekjoonProblem;

import java.util.*;

// ���� ( �⺻ ���� 2 �ܰ� )
// �ڿ��� M�� N�� �־��� �� M�̻� N������ �ڿ��� �� �Ҽ��� ���� ��� ��� �̵� �Ҽ��� �հ� �ּڰ��� ã�� ���α׷��� �ۼ��Ͻÿ�.
// ���� ��� M=60, N=100�� ��� 60�̻� 100������ �ڿ��� �� �Ҽ��� 61, 67, 71, 73, 79, 83, 89, 97 �� 8���� �����Ƿ�, �̵� �Ҽ��� ���� 620�̰�, �ּڰ��� 61�� �ȴ�.

// �Է�
// �Է��� ù° �ٿ� M��, ��° �ٿ� N�� �־�����.
// M�� N�� 10,000������ �ڿ����̸�, M�� N���� �۰ų� ����.

// ���
// M�̻� N������ �ڿ��� �� �Ҽ��� ���� ��� ã�� ù° �ٿ� �� ����, ��° �ٿ� �� �� �ּڰ��� ����Ѵ�.
// ��, M�̻� N������ �ڿ��� �� �Ҽ��� ���� ���� ù° �ٿ� -1�� ����Ѵ�.

// ���� �Է�
// (1)	60
// 		100
// (2)	64
// 		65

// ���� ���
// (1)	620
// 		61
// (2)	-1


public class Problem02581 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int num = n;
		int sum = 0;
		
		x : for(int i = m; i <= n; i++) {
			if(i == 1) continue;
			for(int j = 2; j < i; j++) {
				if(i % j == 0) continue x;
			}
			sum += i;
			if(num > i) num = i;
		}
		
		if(sum != 0) {
			System.out.println(sum);
			System.out.println(num);
		} else {
			System.out.println(-1);
		}
		
		scanner.close();
	}

}
