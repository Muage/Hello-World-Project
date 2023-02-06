package baekjoonProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Scanner;

// ���� ( ��� �ܰ� )
// 0���� ũ�ų� ���� ���� N�� �־�����. �̶�, N!�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ���� N(0 �� N �� 12)�� �־�����.

// ���
// ù° �ٿ� N!�� ����Ѵ�.

// ���� �Է�
// (1) 10
// (2) 0

// ���� ���
// (1) 3628800
// (2) 1

public class Problem10872 {
	
	public static void main(String[] args) throws Exception {
		/** Scanner VS BufferedReader �޸�, �ð� �� */
		
		/* Scanner - 17648KB, 208ms */
//		Scanner scanner = new Scanner(System.in);
//		
//		int n = scanner.nextInt();
//		int result = 1;
//		
//		if(n == 0) {
//			System.out.println(result);
//		} else {
//			for(int i = 1; i <= n; i++) {
//				result *= i;
//			}
//			
//			System.out.println(result);
//		}
//		
//		scanner.close();
		
		/* BufferedReader - 14084KB, 124ms */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(reader.readLine());
		int result = 1;
		
		if(n == 0) {
			System.out.println(result);
		} else {
			for(int i = 1; i <= n; i++) {
				result *= i;
			}
			
			System.out.println(result);
		}
	}

}