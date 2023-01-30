package baekjoonProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// ���� ( ���� �ܰ� )
// ���� ó���ϴ� ���� ����п��� ����� �߿��� ���̴�.
// ����п��� N���� ���� ��ǥ�ϴ� �⺻ ��谪���� ������ ���� �͵��� �ִ�.
// ��, N�� Ȧ����� ��������.
// 1. ������ : N���� ������ ���� N���� ���� ��
// 2. �߾Ӱ� : N���� ������ �����ϴ� ������ �������� ��� �� �߾ӿ� ��ġ�ϴ� ��
// 3. �ֺ� : N���� ���� �� ���� ���� ��Ÿ���� ��
// 4. ���� : N���� ���� �� �ִ񰪰� �ּڰ��� ����
// N���� ���� �־����� ��, �� ���� �⺻ ��谪�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ���� ���� N(1 �� N �� 500,000)�� �־�����.
// ��, N�� Ȧ���̴�.
// �� ���� N���� �ٿ��� �������� �־�����.
// �ԷµǴ� ������ ������ 4,000�� ���� �ʴ´�.

// ���
// ù° �ٿ��� �������� ����Ѵ�.
// �Ҽ��� ���� ù° �ڸ����� �ݿø��� ���� ����Ѵ�.
// ��° �ٿ��� �߾Ӱ��� ����Ѵ�.
// ��° �ٿ��� �ֺ��� ����Ѵ�.
// ���� �� ���� ������ �ֺ� �� �� ��°�� ���� ���� ����Ѵ�.
// ��° �ٿ��� ������ ����Ѵ�.

// ���� �Է�
// (1)	5
// 		1
// 		3
// 		8
// 		-2
// 		2
// (2)	1
// 		4000
// (3)	5
// 		-1
// 		-2
// 		-3
// 		-1
// 		-2
// (4)	3
// 		0
// 		0
// 		-1

// ���� ���
// (1)	2
// 		2
// 		1
// 		10
// (2)	4000
// 		4000
// 		4000
// 		0
// (3)	-2
// 		-2
// 		-1
// 		2
// (4)	0
// 		0
// 		0
// 		1

public class Problem02108 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int sum = 0;
		int max = 0;
		int[] arr = new int[n];
		int[] plus = new int[4002];
		int[] minus = new int[4001];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		
		// ������
		for(int i = 0; i < n; i++) {
			sum += arr[i];
		}
		System.out.println((int)Math.round((double)sum / n));
		
		// �߾Ӱ�
		Arrays.sort(arr);
		System.out.println(arr[n / 2]);
		
		// �ֺ�
		for(int i = 0; i < n; i++) {
			if(arr[i] < 0) {
				minus[Math.abs(arr[i])]++;
			} else {
				plus[arr[i]]++;
			}
		}
		
		for(int i = 0; i < plus.length; i++) {
			max = Math.max(max, plus[i]);
		}
		
		for(int i = 0; i < minus.length; i++) {
			max = Math.max(max, minus[i]);
		}
		
		for(int i : arr) {
			if(i < 0) {
				if(minus[Math.abs(i)] == max && !(list.contains(i))) {
					list.add(i);
				}
			} else {
				if(plus[i] == max && !(list.contains(i))) {
					list.add(i);
				}
			}
		}
		
		if(list.size() >= 2) {
			System.out.println(list.get(1));
		} else {
			System.out.println(list.get(0));
		}
		
		// ����
		System.out.println(arr[n - 1] - arr[0]);
		
		scanner.close();
	}

}
