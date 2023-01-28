package baekjoonProblem;

import java.util.*;

// ���� ( 2���� �迭 �ܰ� )
// N*Mũ���� �� ��� A�� B�� �־����� ��, �� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ����� ũ�� N �� M�� �־�����.
// ��° �ٺ��� N���� �ٿ� ��� A�� ���� M���� ���ʴ�� �־�����.
// �̾ N���� �ٿ� ��� B�� ���� M���� ���ʴ�� �־�����.
// N�� M�� 100���� �۰ų� ����, ����� ���Ҵ� ������ 100���� �۰ų� ���� �����̴�.

// ���
// ù° �ٺ��� N���� �ٿ� ��� A�� B�� ���� ����� ����Ѵ�.
// ����� �� ���Ҵ� �������� �����Ѵ�.

// ���� �Է�
// 3 3
// 1 1 1
// 2 2 2
// 0 1 0
// 3 3 3
// 4 4 4
// 5 5 100

// ���� ���
// 4 4 4
// 6 6 6
// 5 6 100

public class Problem02738 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] += scanner.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		scanner.close();
	}

}
