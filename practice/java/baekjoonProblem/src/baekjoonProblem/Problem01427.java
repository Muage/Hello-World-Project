package baekjoonProblem;

import java.util.Arrays;
import java.util.Scanner;

// ���� ( ���� �ܰ� )
// �迭�� �����ϴ� ���� ����.
// ���� �־�����, �� ���� �� �ڸ����� ������������ �����غ���.

// �Է�
// ù° �ٿ� �����Ϸ��� �ϴ� �� N�� �־�����.
// N�� 1,000,000,000���� �۰ų� ���� �ڿ����̴�.

// ���
// ù° �ٿ� �ڸ����� ������������ ������ ���� ����Ѵ�.

// ���� �Է�
// (1)	2143
// (2)	999998999
// (3)	61423
// (4)	500613009

// ���� ���
// (1)	4321
// (2)	999999998
// (3)	64321
// (4)	965310000

public class Problem01427 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int temp = 0;
		String n = scanner.next();
		int[] arr = new int[n.length()];
		
		for(int i = 0; i < n.length(); i++) {
			arr[i] = n.charAt(i) - '0';
		}
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		
		scanner.close();
	}

}