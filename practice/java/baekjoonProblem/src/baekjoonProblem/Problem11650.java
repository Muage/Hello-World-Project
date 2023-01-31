package baekjoonProblem;

import java.util.Arrays;
import java.util.Scanner;

// ���� ( ���� �ܰ� )
// 2���� ��� ���� �� N���� �־�����.
// ��ǥ�� x��ǥ�� �����ϴ� ������, x��ǥ�� ������ y��ǥ�� �����ϴ� ������ ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ���� ���� N (1 �� N �� 100,000)�� �־�����.
// ��° �ٺ��� N���� �ٿ��� i������ ��ġ xi�� yi�� �־�����.
// (-100,000 �� xi, yi �� 100,000) ��ǥ�� �׻� �����̰�, ��ġ�� ���� �� ���� ����.

// ���
// ù° �ٺ��� N���� �ٿ� ���� ������ ����� ����Ѵ�.

// ���� �Է�
// 5
// 3 4
// 1 1
// 1 -1
// 2 2
// 3 3

// ���� ���
// 1 -1
// 1 1
// 2 2
// 3 3
// 3 4

public class Problem11650 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[][] arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
		}
		
		Arrays.sort(arr, (e1, e2) -> {
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
		
		scanner.close();
	}

}
