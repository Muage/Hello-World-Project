package baekjoonProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// ���� ( ���� �ܰ� )
// ������ ���� N���� ��ǥ X1, X2, ..., XN�� �ִ�. �� ��ǥ�� ��ǥ ������ �����Ϸ��� �Ѵ�.
// Xi�� ��ǥ ������ ��� X'i�� ���� Xi > Xj�� �����ϴ� ���� �ٸ� ��ǥ�� ������ ���ƾ� �Ѵ�.
// X1, X2, ..., XN�� ��ǥ ������ ������ ��� X'1, X'2, ..., X'N�� ����غ���.

// �Է�
// ù° �ٿ� N�� �־�����.
// ��° �ٿ��� ���� �� ĭ���� ���е� X1, X2, ..., XN�� �־�����.

// ���
// ù° �ٿ� X'1, X'2, ..., X'N�� ���� �� ĭ���� �����ؼ� ����Ѵ�.

// ����
// 1. 1 �� N �� 1,000,000
// 2. -109 �� Xi �� 109

// ���� �Է�
// (1)	5
// 		2 4 -10 4 -9
// (2)	6
// 		1000 999 1000 999 1000 999

// ���� ���
// (1)	2 3 0 3 1
// (2)	1 0 1 0 1 0

public class Problem18870 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int rank = 0;
		int[] origin = new int[n];
		int[] sorted = new int[n];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++) {
			sorted[i] = origin[i] = scanner.nextInt();
		}
		
		Arrays.sort(sorted);
		
		for(int value : sorted) {
			if(!map.containsKey(value)) {
				map.put(value, rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int key : origin) {
			int ranking = map.get(key);
			sb.append(ranking).append(" ");
		}
		
		System.out.println(sb);
		
		scanner.close();
	}

}
