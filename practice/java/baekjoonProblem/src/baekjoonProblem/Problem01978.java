package baekjoonProblem;

import java.util.*;

// ���� ( �⺻ ���� 2 �ܰ� )
// �־��� �� N�� �߿��� �Ҽ��� �� ������ ã�Ƽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù �ٿ� ���� ���� N�� �־�����.
// N�� 100�����̴�.
// �������� N���� ���� �־����µ� ���� 1,000 ������ �ڿ����̴�.

// ���
// �־��� ���� �� �Ҽ��� ������ ����Ѵ�.

// ���� �Է�
// 4
// 1 3 5 7

// ���� ���
// 3

public class Problem01978 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			
			for(int j = 2; j <= num; j++) {
				if(num == j) count++;
				if(num == 1 || num % j == 0) break;
			}
		}
		System.out.println(count);
		
		scanner.close();
	}

}