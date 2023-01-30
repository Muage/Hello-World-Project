package baekjoonProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// ���� ( ���� �ܰ� )
// N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ���� ���� N(1 �� N �� 10,000,000)�� �־�����.
// ��° �ٺ��� N���� �ٿ��� ���� �־�����.
// �� ���� 10,000���� �۰ų� ���� �ڿ����̴�.

// ���
// ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.

// ���� �Է�
// 10
// 5
// 2
// 3
// 1
// 4
// 2
// 3
// 5
// 1
// 7

// ���� ���
// 1
// 1
// 2
// 2
// 3
// 3
// 4
// 5
// 5
// 7

public class Problem10989 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int n = Integer.valueOf(reader.readLine());
		int[] list = new int[n];
		
		for(int i = 0; i < n; i++) {
			list[i] = Integer.valueOf(reader.readLine());
		}
		
		Arrays.sort(list);
		
		for(int i = 0; i < n; i++) {
			builder.append(list[i] + "\n");
		}
		
		System.out.println(builder);
	}

}