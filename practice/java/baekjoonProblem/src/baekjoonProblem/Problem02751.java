package baekjoonProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// ���� ( ���� �ܰ� )
// N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ���� ���� N(1 �� N �� 1,000,000)�� �־�����.
// ��° �ٺ��� N���� �ٿ��� ���� �־�����.
// �� ���� ������ 1,000,000���� �۰ų� ���� �����̴�.
// ���� �ߺ����� �ʴ´�.

// ���
// ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.

// ���� �Է�
// 5
// 5
// 4
// 3
// 2
// 1

// ���� ���
// 1
// 2
// 3
// 4
// 5

public class Problem02751 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int n = Integer.valueOf(reader.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(Integer.valueOf(reader.readLine()));
		}
		
		Collections.sort(list);
		
		for(int num : list) {
			builder.append(num).append("\n");
		}
		
		System.out.println(builder);
	}

}
