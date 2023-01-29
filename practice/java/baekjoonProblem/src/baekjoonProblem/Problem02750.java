package baekjoonProblem;

import java.util.Scanner;

// ���� ( ���� �ܰ� )
// N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ���� ���� N(1 �� N �� 1,000)�� �־�����.
// ��° �ٺ��� N���� �ٿ��� ���� �־�����.
// �� ���� ������ 1,000���� �۰ų� ���� �����̴�.
// ���� �ߺ����� �ʴ´�.

// ���
// ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.

// ���� �Է�
// 5
// 5
// 2
// 3
// 4
// 1

// ���� ���
// 1
// 2
// 3
// 4
// 5

public class Problem02750 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int temp = 0;
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}

		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		scanner.close();
	}

}
