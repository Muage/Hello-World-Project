package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� ( Lv1. A + B )
// �� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// ��������
// �� ���� A�� B�� 1�̻� 9������ �����̴�.

// �Է�����
// ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����.
// �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, �� �ٿ� A�� B�� �־�����.

// �������
// �� �׽�Ʈ ���̽����� "Case #(�׽�Ʈ ���̽� ��ȣ): "�� ����� ����, A+B�� ����Ѵ�.
// �׽�Ʈ ���̽� ��ȣ�� 1���� �����Ѵ�.

// �Է¿���
// 5
// 1 1
// 2 3
// 3 4
// 9 8
// 5 2

// ��¿���
// Case #1: 2
// Case #2: 5
// Case #3: 7
// Case #4: 17
// Case #5: 7

public class Lv1_A_plus_B {
	
	public static void main(String[] args) throws Exception {
		/*
		 * ��� 2. ����: 100.0		����ð�: 130ms		�޸�: 13.82Mb
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.valueOf(reader.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(reader.readLine());
			
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			
			System.out.println("Case #" + (i + 1) + ": " + (A + B));
		}
		
		
		/*
		 * ��� 1. ����: 100.0		����ð�: 167ms		�޸�: 15.2Mb
		 */
//		Scanner scanner = new Scanner(System.in);
//		
//		int T = scanner.nextInt();
//		
//		for(int i = 0; i < T; i++) {
//			int A = scanner.nextInt();
//			int B = scanner.nextInt();
//		
//			System.out.println("Case #" + (i + 1) + ": " + (A + B));
//		}
//		
//		scanner.close();
	}

}
