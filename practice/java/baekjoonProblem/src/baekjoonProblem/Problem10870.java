package baekjoonProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ���� ( ��� �ܰ� )
// �Ǻ���ġ ���� 0�� 1�� �����Ѵ�.
// 0��° �Ǻ���ġ ���� 0�̰�, 1��° �Ǻ���ġ ���� 1�̴�.
// �� ���� 2��° ���ʹ� �ٷ� �� �� �Ǻ���ġ ���� ���� �ȴ�.
// �̸� ������ �Ẹ�� Fn = Fn-1 + Fn-2 (n �� 2)�� �ȴ�.
// n=17�϶� ���� �Ǻ���ġ ���� �Ẹ�� ������ ����.
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
// n�� �־����� ��, n��° �Ǻ���ġ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� n�� �־�����.
// n�� 20���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.

// ���
// ù° �ٿ� n��° �Ǻ���ġ ���� ����Ѵ�.

// ���� �Է�
// 10

// ���� ���
// 55

public class Problem10870 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(reader.readLine());
		int[] F = new int[n + 1];
		
		if(n == 0 || n == 1) System.out.println(n);
		
		if(n > 1) {
			F[0] = 0;
			F[1] = 1;
			
			for(int i = 2; i <= n; i++) {
				F[i] = F[i - 1] + F[i - 2];
				
				if(i == n) System.out.println(F[i]);
			}
		}
	}

}
