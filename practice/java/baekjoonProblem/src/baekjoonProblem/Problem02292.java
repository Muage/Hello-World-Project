package baekjoonProblem;

import java.util.*;

// ����  ( �⺻ ���� 1 �ܰ� )
// ���� �׸��� ���� ���������� �̷���� ������ �ִ�.
// �׸����� ���� �ٿ� ���� �߾��� �� 1���� �����ؼ� �̿��ϴ� �濡 ���ư��鼭 1�� �����ϴ� ��ȣ�� �ּҷ� �ű� �� �ִ�.
// ���� N�� �־����� ��, ������ �߾� 1���� N�� ����� �ּ� ������ ���� ������ �� �� �� ���� ���� ����������(���۰� ���� �����Ͽ�)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
// ���� ���, 13������ 3��, 58������ 5���� ������.

// �Է�
// ù° �ٿ� N(1 �� N �� 1,000,000,000)�� �־�����.

// ���
// �Է����� �־��� ����� �ּ� ������ ���� ������ �� �� �� ���� ���� �������� ����Ѵ�.

// ���� �Է�
// 13

// ���� ���
// 3

public class Problem02292 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int count = 1;
		int range = 2;
		
		if(n == 1) {
			System.out.println(1);
		} else {
			while(range <= n) {
				range = range + (count * 6);
				count++;
			}
			System.out.println(count);
		}
		
		scanner.close();
	}

}
