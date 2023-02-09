package baekjoonProblem;

import java.util.Scanner;

// ���� ( ��� �ܰ� )
// �� ���� ��밡 �ְ� ù ��° ��뿡�� �ݰ��� ���� �ٸ� n���� ������ �׿� �ִ�.
// �� ������ �ݰ��� ū ������� �׿��ִ�.
// ���� �����µ��� ���� ��Ģ�� ���� ù ��° ��뿡�� �� ��° ���� �ű�� �Ѵ�.
// 1. �� ���� �� ���� ���Ǹ��� �ٸ� ž���� �ű� �� �ִ�.
// 2. �׾� ���� ������ �׻� ���� ���� �Ʒ��� �ͺ��� �۾ƾ� �Ѵ�.
// �� �۾��� �����ϴµ� �ʿ��� �̵� ������ ����ϴ� ���α׷��� �ۼ��϶�.
// ��, �̵� Ƚ���� �ּҰ� �Ǿ�� �Ѵ�.
// �Ʒ� �׸��� ������ 5���� ����� �����̴�.

// �Է�
// ù° �ٿ� ù ��° ��뿡 ���� ������ ���� N (1 �� N �� 20)�� �־�����.

// ���
// ù° �ٿ� �ű� Ƚ�� K�� ����Ѵ�.
// �� ��° �ٺ��� ���� ������ ����Ѵ�.
// �� ��° �ٺ��� K���� �ٿ� ���� �� ���� A B�� ��ĭ�� ���̿� �ΰ� ����ϴµ�, �̴� A��° ž�� ���� ���� �ִ� ������ B��° ž�� ���� ���� �ű�ٴ� ���̴�.

// ���� �Է�
// 3

// ���� ���
// 7
// 1 3
// 1 2
// 3 2
// 1 3
// 2 1
// 2 3
// 1 3

public class Problem11729 {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		sb.append((int)(Math.pow(2, n) - 1)).append("\n");
		
		Hanoi(n, 1, 2, 3);
		System.out.println(sb);
		
		scanner.close();
	}
	
	public static void Hanoi(int n, int start, int mid, int to) {
		if(n == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		
		Hanoi(n - 1, start, to, mid);
		
		sb.append(start + " " + to + "\n");
		
		Hanoi(n - 1, mid, start, to);
	}

}
