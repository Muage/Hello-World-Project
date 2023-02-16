package baekjoonProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

// ���� ( ���հ� �� �ܰ� )
// ���� ī��� ���� �ϳ��� ������ �ִ� ī���̴�.
// ����̴� ���� ī�� N���� ������ �ִ�.
// ���� M���� �־����� ��, �� ���� �����ִ� ���� ī�带 ����̰� ������ �ִ��� �ƴ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ����̰� ������ �ִ� ���� ī���� ���� N(1 �� N �� 500,000)�� �־�����.
// ��° �ٿ��� ���� ī�忡 �����ִ� ������ �־�����.
// ���� ī�忡 �����ִ� ���� -10,000,000���� ũ�ų� ����, 10,000,000���� �۰ų� ����.
// �� ���� ī�忡 ���� ���� �����ִ� ���� ����.
// ��° �ٿ��� M(1 �� M �� 500,000)�� �־�����.
// ��° �ٿ��� ����̰� ������ �ִ� ���� ī������ �ƴ����� ���ؾ� �� M���� ������ �־�����, �� ���� �������� ���еǾ��� �ִ�.
// �� ���� -10,000,000���� ũ�ų� ����, 10,000,000���� �۰ų� ����.

// ���
// ù° �ٿ� �Է����� �־��� M���� ���� ���ؼ�, �� ���� ���� ���� ī�带 ����̰� ������ ������ 1��, �ƴϸ� 0�� �������� ������ ����Ѵ�.

// ���� �Է�
// 5
// 6 3 2 10 -10
// 8
// 10 9 -5 2 3 4 5 -10

// ���� ���
// 1 0 0 1 1 0 0 1

public class Problem10815 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashSet<Integer> card = new HashSet<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		int n = Integer.valueOf(reader.readLine());
		
		st = new StringTokenizer(reader.readLine());
		
		for(int i = 0; i < n; i++) {
			card.add(Integer.valueOf(st.nextToken()));
		}
		
		int m = Integer.valueOf(reader.readLine());
		
		st = new StringTokenizer(reader.readLine());
		
		for(int i = 0; i < m; i++) {
			int num = Integer.valueOf(st.nextToken());
			
			if(card.contains(num))
				result.add(1);
			else
				result.add(0);
		}
		
		for(Integer value : result) {
			System.out.print(value + " ");
		}
	}

}
