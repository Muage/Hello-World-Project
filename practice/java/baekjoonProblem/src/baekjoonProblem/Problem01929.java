package baekjoonProblem;

import java.util.*;

// ���� ( �⺻ ���� 2 �ܰ� )
// M�̻� N������ �Ҽ��� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� �ڿ��� M�� N�� �� ĭ�� ���̿� �ΰ� �־�����.
// (1 �� M �� N �� 1,000,000) M�̻� N������ �Ҽ��� �ϳ� �̻� �ִ� �Է¸� �־�����.

// ���
// �� �ٿ� �ϳ���, �����ϴ� ������� �Ҽ��� ����Ѵ�.

// ���� �Է�
// 3 16

// ���� ���
// 3
// 5
// 7
// 11
// 13

public class Problem01929 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		boolean[] arr = new boolean[n + 1];
		
		arr[0] = true;
		arr[1] = true;
		
		for(int i = 2; i < Math.sqrt(n + 1); i++) {
			for(int j = i * i; j < n + 1; j += i) {
				arr[j] = true;
			}
		}
		
		for(int i = m; i < n + 1; i++) {
			if(arr[i] == false) System.out.println(i);
		}
		
		scanner.close();
	}

}
