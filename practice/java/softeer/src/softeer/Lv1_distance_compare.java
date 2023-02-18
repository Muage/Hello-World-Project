package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� ( Lv1. ����Ÿ� ���ϱ� )
// �����ڵ����׷��� �������� ��ȣ�� �ڵ����� ����Ÿ��� ���ϴ� ���α׷��� ����� �ִ�.
// �� ���� A�� B�� ����Ÿ��� �ڿ����� �־����� ��, ����Ÿ��� ���ؼ� ��� ������ ����Ÿ��� �� ū�� �˾ƺ���.

// ��������
// 0 �� A,B �� 100,000

// �Է�����
// ù°�ٿ� ������ A,B�� ����Ÿ��� ��ĭ�� ������ �ΰ� �־�����.

// �������
// ����Ÿ��� ���ؼ� ù°�ٿ� �Ʒ��� ���ڸ� ����Ѵ�.
// - A�� B ���� ū ��� A�� ����Ѵ�.
// - A�� B ���� ���� ��� B�� ����Ѵ�.
// - A�� B�� ����Ÿ��� ���� ��� same�� ����Ѵ�.

// �Է¿���
// (1)	3500 2000
// (2)	1500 1800
// (3)	5000 5000

// ��¿���
// (1)	A
// (2)	B
// (3)	same

public class Lv1_distance_compare {
	
	public static void main(String[] args) throws Exception {
		/*
		 * ��� 5. ����: 100.0		����ð�: 66ms		�޸�: 10.21Mb
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int A = Integer.valueOf(st.nextToken());
		int B = Integer.valueOf(st.nextToken());
		int result = Integer.compare(A, B);
		
		if(result == 1) {
			System.out.println("A");
		} else if(result == 0) {
			System.out.println("same");
		} else if(result == -1) {
			System.out.println("B");
		}
		
		
		/*
		 * ��� 4. ����: 100.0		����ð�: 67ms		�޸�: 10.33Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		
//		int A = Integer.valueOf(st.nextToken());
//		int B = Integer.valueOf(st.nextToken());
//		int result = Integer.compare(A, B);
//		
//		switch(result) {
//			case 1:
//				System.out.println("A");
//				break;
//			case 0:
//				System.out.println("same");
//				break;
//			case -1:
//				System.out.println("B");
//				break;
//		}
		
		
		/*
		 * ��� 3. ����: 100.0		����ð�: 73ms		�޸�: 10.21Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		StringBuffer sb = new StringBuffer();
//		
//		int A = Integer.valueOf(st.nextToken());
//		int B = Integer.valueOf(st.nextToken());
//		
//		if(A > B) {
//			sb.append("A");
//		} else if(B > A) {
//			sb.append("B");
//		} else {
//			sb.append("same");
//		}
//		
//		System.out.println(sb);
		
		
		/*
		 * ��� 2. ����: 100.0		����ð�: 67ms		�޸�: 10.21Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		
//		int A = Integer.valueOf(st.nextToken());
//		int B = Integer.valueOf(st.nextToken());
//		String result;
//		
//		if(A > B) {
//			result = "A";
//		} else if(B > A) {
//			result = "B";
//		} else {
//			result = "same";
//		}
//		
//		System.out.println(result);
		
		
		/*
		 * ��� 1. ����: 100.0		����ð�: 113ms	�޸�: 11.96Mb
		 */
//		Scanner scanner = new Scanner(System.in);
//		
//		int A = scanner.nextInt();
//		int B = scanner.nextInt();
//		String result;
//		
//		if(A > B) {
//			result = "A";
//		} else if(B > A) {
//			result = "B";
//		} else {
//			result = "same";
//		}
//		
//		System.out.println(result);
//		
//		scanner.close();
	}

}