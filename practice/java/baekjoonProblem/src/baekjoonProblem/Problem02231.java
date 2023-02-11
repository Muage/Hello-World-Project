package baekjoonProblem;

import java.util.Scanner;

// ���� ( ���Ʈ ���� �ܰ� )
// � �ڿ��� N�� ���� ��, �� �ڿ��� N�� �������� N�� N�� �̷�� �� �ڸ����� ���� �ǹ��Ѵ�.
// � �ڿ��� M�� �������� N�� ���, M�� N�� �����ڶ� �Ѵ�.
// ���� ���, 245�� �������� 256(=245+2+4+5)�� �ȴ�.
// ���� 245�� 256�� �����ڰ� �ȴ�.
// ����, � �ڿ����� ��쿡�� �����ڰ� ���� ���� �ִ�.
// �ݴ��, �����ڰ� ���� ���� �ڿ����� ���� �� �ִ�.
// �ڿ��� N�� �־����� ��, N�� ���� ���� �����ڸ� ���س��� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� �ڿ��� N(1 �� N �� 1,000,000)�� �־�����.

// ���
// ù° �ٿ� ���� ����Ѵ�.
// �����ڰ� ���� ��쿡�� 0�� ����Ѵ�.

// ���� �Է�
// 216

// ���� ���
// 198

public class Problem02231 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			int num = i;
			int sum = 0;
			
			while(num != 0) {
				sum += num % 10;
				num /= 10;
			}
			
			if(sum + i == n) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
		scanner.close();
	}

}