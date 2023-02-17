package baekjoonProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// ���� ( ���հ� �� �ܰ� )
// ���� ī��� ���� �ϳ��� ������ �ִ� ī���̴�.
// ����̴� ���� ī�� N���� ������ �ִ�.
// ���� M���� �־����� ��, �� ���� �����ִ� ���� ī�带 ����̰� �� �� ������ �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ����̰� ������ �ִ� ���� ī���� ���� N(1 �� N �� 500,000)�� �־�����.
// ��° �ٿ��� ���� ī�忡 �����ִ� ������ �־�����.
// ���� ī�忡 �����ִ� ���� -10,000,000���� ũ�ų� ����, 10,000,000���� �۰ų� ����.
// ��° �ٿ��� M(1 �� M �� 500,000)�� �־�����.
// ��° �ٿ��� ����̰� �� �� ������ �ִ� ���� ī������ ���ؾ� �� M���� ������ �־�����, �� ���� �������� ���еǾ��� �ִ�.
// �� ���� -10,000,000���� ũ�ų� ����, 10,000,000���� �۰ų� ����.

// ���
// ù° �ٿ� �Է����� �־��� M���� ���� ���ؼ�, �� ���� ���� ���� ī�带 ����̰� �� �� ������ �ִ����� �������� ������ ����Ѵ�.

// ���� �Է�
// 10
// 6 3 2 10 10 10 -10 -10 7 3
// 8
// 10 9 -5 2 3 4 5 -10

// ���� ���
// 3 0 0 1 2 0 0 2

public class Problem10816 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> result = new ArrayList<>();
		
		int n = Integer.valueOf(reader.readLine());
		int[] card = new int[n];
		
		st = new StringTokenizer(reader.readLine());
		
		for(int i = 0; i < n; i++) {
			card[i] = Integer.valueOf(st.nextToken());
		}
		
		int m = Integer.valueOf(reader.readLine());
		
		st = new StringTokenizer(reader.readLine());
		
		for(int i = 0; i < m; i++) {
			int count = 0;
			int num = Integer.valueOf(st.nextToken());
			
			for(int j = 0; j < n; j++) {
				if(card[j] == num) count++;
			}
			result.add(count);
		}
		
		for(Integer value : result) {
			System.out.print(value + " ");
		}
	}

}