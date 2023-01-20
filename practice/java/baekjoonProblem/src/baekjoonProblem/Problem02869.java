package baekjoonProblem;

import java.util.*;

// ����  ( �⺻ ���� 1 �ܰ� )
// �� ���� �����̰� �ִ�.
// �� �����̴� ���̰� V������ ���� ���븦 �ö� ���̴�.
// �����̴� ���� A���� �ö� �� �ִ�.
// ������, �㿡 ���� �ڴ� ���� B���� �̲�������.
// ��, ���� �ö� �Ŀ��� �̲������� �ʴ´�.
// �����̰� ���� ���븦 ��� �ö󰡷���, ��ĥ�� �ɸ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� �� ���� A, B, V�� �������� ���еǾ �־�����.
// (1 �� B < A �� V �� 1,000,000,000)

// ���
// ù° �ٿ� �����̰� ���� ���븦 ��� �ö󰡴µ� ��ĥ�� �ɸ����� ����Ѵ�.

// ���� �Է�
// (1)	2 1 5
// (2)	5 1 6
// (3)	100 99 1000000000

// ���� ���
// (1)	4
// (2)	2
// (3)	999999901

public class Problem02869 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int v = scanner.nextInt();
		
		int day = (v - b) / (a - b);
		
		if((v - b) % (a - b) != 0) {
			day++;
		}
		
		System.out.println(day);
		
		scanner.close();
	}

}
