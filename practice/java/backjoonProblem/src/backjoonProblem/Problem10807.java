package backjoonProblem;

import java.util.Scanner;

// ���� ( 1���� �迭 �ܰ� )
// �� N���� ������ �־����� ��, ���� v�� �� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ������ ���� N(1 �� N �� 100)�� �־�����.
// ��° �ٿ��� ������ �������� ���еǾ����ִ�.
// ��° �ٿ��� ã������ �ϴ� ���� v�� �־�����.
// �Է����� �־����� ������ v�� -100���� ũ�ų� ������, 100���� �۰ų� ����.

// ���
// ù° �ٿ� �Է����� �־��� N���� ���� �߿� v�� �� ������ ����Ѵ�.

// ���� �Է�
// (1)	11
//		1 4 1 2 4 2 4 2 3 4 4
//		2
// (2)	11
//		1 4 1 2 4 2 4 2 3 4 4
//		5

// ���� ���
// (1) 3
// (2) 0

public class Problem10807 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int v = scanner.nextInt();
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i] == v) {
				count++;
			}
		}
		System.out.println(count);
		scanner.close();
	}

}
