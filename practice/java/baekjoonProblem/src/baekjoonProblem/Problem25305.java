package baekjoonProblem;

import java.util.Scanner;

// ���� ( ���� �ܰ� )
// 2022 �������б� �̷�ķ�۽� ����ο� �ڵ���Ȱ�� N���� �л����� �����ߴ�.
// �̵� �� ������ ���� ���� k���� ���� ���� ���̴�.
// �� ��, ���� �޴� ĿƮ������ �� ������ ���϶�.
// ĿƮ�����̶� ���� �޴� ����� �� ������ ���� ���� ���� ����� ������ ���Ѵ�.

// �Է�
// ù° �ٿ��� �������� �� N�� ���� �޴� ����� �� k�� ������ ���̿� �ΰ� �־�����.
// ��° �ٿ��� �� �л��� ���� x�� ������ ���̿� �ΰ� �־�����.

// ���
// ���� �޴� ĿƮ������ ����϶�.

// ����
// 1 �� N �� 1000
// 1 �� k �� N
// 0 �� x �� 10000

// ���� �Է�
// 5 2
// 100 76 85 93 98

// ���� ���
// 98

public class Problem25305 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int temp = 0;
		int[] score = new int[n];
		
		for(int i = 0; i < n; i++) {
			score[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(score[i] < score[j]) {
					temp = score[j];
					score[j] = score[i];
					score[i] = temp;
				}
			}
		}
		
		System.out.println(score[k - 1]);
		
		scanner.close();
	}

}
