package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

// ���� ( Lv2. ������ )
// �������׷쿡 �ٴϴ� ����� ������ ���� ������ ���� �ǽð����� �ľ��ϱ� ���� �繫�ǿ� ������ �ǽð����� ǥ���ϴ� �������� ��ġ�Ͽ���.
// �������� �ִ� �ټ� �ڸ��� �ڿ������� ǥ���� �� �ֵ���, �Ʒ��� ���� ������ ����� ���� 7��5=35���� �����Ǿ� �ִ�.
// 8�� ����� ���� ������ 0���� 9������ ���ڸ� ǥ���� �� ������, ǥ�� ����� �Ʒ��� ����.
// �Ʒ� �׸����� ������ �������� ������, �������� ���� ȸ������ ǥ���Ǿ���.
// ���� ���, �������� ���� 9881�� ǥ���ϸ� �Ʒ��� ����.
// ���� �ڸ� ���� ���� ������, ���� �ڸ��� �ش��ϴ� �������� ��� ���� ������ �����϶�.
// ���� ���, �������� ���� 10724�� ǥ���ϸ� �Ʒ��� ����.
// ������ �������� ����ġ�� �޷� �ִ�.
// ������ �޷� �ִ� ����ġ�� ���� ��, �� ������ ���� �־��ٸ� ������, �� ������ ���� �־��ٸ� ������.
// ���� �����ǿ� �ڿ��� A�� ǥ�õǾ� �ִµ�, ������ �����ʿ� ���� �����ǿ� ǥ�õ� �ڿ����� B�� �ٲ�� �Ѵ�.
// �̷��� ��ǥ�� �޼��ϱ� ���� ����ġ�� �ּ� �� �� ������ �ϴ����� ���ϴ� ���α׷��� �ۼ��϶�.

// ��������
// �ϳ��� �Է¿��� 1�� �̻� 1000�� ������ �׽�Ʈ ���̽��� �ذ��ؾ� �Ѵ�.
// A�� B�� �� �ڸ� �̻� �ټ� �ڸ� ������ �ڿ����̴�.
// A�� B�� ���� 0���� �������� �ʴ´�.
// A�� B�� ���� �ٸ���.

// �Է�����
// ù ��° �ٿ� �ذ��� �׽�Ʈ ���̽��� �� T�� �־�����.
// ���� T���� �ٿ��� �� �ٿ� �׽�Ʈ ���̽� �ϳ����� �־�����.
// ������ �ٿ��� �� �ڿ��� A�� B�� ���� �ϳ��� ���̷� �ΰ� �־�����.

// �������
// ������ �׽�Ʈ ���̽����� �������, ����ġ�� ������ �ϴ� �ּ� Ƚ���� �� �ٿ� �ϳ��� ����Ѵ�.

// �Է¿���1
// 2
// 1 2
// 9881 10724

// ��¿���1
// 5
// 11

// �Է¿���2
// 2
// 111 11
// 11 11111

// ��¿���2
// 2
// 6

public class Lv2_billboard {
	
	/*
	 * �ٸ� ��� �ڵ�
	 * ��� 2. ����: 100.0		����ð�: 124ms		�޸�: 12.06Mb
	 */
	private static Map<Integer, int[]> num;
	
	private static int sum(int a) {
		int count = 0;

		int[] number = num.get(a);
		
		for(int i = 0; i < 7; i++) {
			count += number[i];
		}
		
		return count;
	}
	
	private static int compare(int a, int b) {
		int count = 0;
		
		int[] arr_A = num.get(a);
		int[] arr_B = num.get(b);
		
		for(int i = 0; i < 7; i++) {
			if(arr_A[i] != arr_B[i]) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		num = new HashMap<>();
		num.put(0, new int[] {1, 1, 1, 1, 1, 1, 0});
		num.put(1, new int[] {0, 1, 1, 0, 0, 0, 0});
		num.put(2, new int[] {1, 1, 0, 1, 1, 0, 1});
		num.put(3, new int[] {1, 1, 1, 1, 0, 0, 1});
		num.put(4, new int[] {0, 1, 1, 0, 0, 1, 1});
		num.put(5, new int[] {1, 0, 1, 1, 0, 1, 1});
		num.put(6, new int[] {1, 0, 1, 1, 1, 1, 1});
		num.put(7, new int[] {1, 1, 1, 0, 0, 1, 0});
		num.put(8, new int[] {1, 1, 1, 1, 1, 1, 1});
		num.put(9, new int[] {1, 1, 1, 1, 0, 1, 1});
		
		int T = Integer.valueOf(reader.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(reader.readLine());
			
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			
			int[] arr_A = {-1, -1, -1, -1, -1};
			int[] arr_B = {-1, -1, -1, -1, -1};
			
			for(int j = 0; j < 5; j++) {
				arr_A[j] = A % 10;
				A /= 10;
				if(A == 0) break;
			}
			
			for(int j = 0; j < 5; j++) {
				arr_B[j] = B % 10;
				B /= 10;
				if(B == 0) break;
			}
			
			int count = 0;
			
			for(int j = 0; j < 5; j++) {
				if(arr_A[j] != arr_B[j]) {
					if(arr_A[j] == -1) {
						count += sum(arr_B[j]);
					} else if(arr_B[j] == -1) {
						count += sum(arr_A[j]);
					} else {
						count += compare(arr_A[j], arr_B[j]);
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	
	/*
	 * �ٽ� Ǯ���
	 * ��� 1. ����: 0.0		����ð�: 124ms		�޸�: 12.06Mb
	 */
//	private static int compare(int a, int b) {
//		Map<Integer, boolean[]> num = new HashMap<>();
//		num.put(0, new boolean[] {true, true, true, true, true, true, false});
//		num.put(1, new boolean[] {false, true, true, false, false, false, false});
//		num.put(2, new boolean[] {true, true, false, true, true, false, true});
//		num.put(3, new boolean[] {true, true, true, true, false, false, true});
//		num.put(4, new boolean[] {false, true, true, false, false, true, true});
//		num.put(5, new boolean[] {true, false, true, true, false, true, true});
//		num.put(6, new boolean[] {true, false, true, true, true, true, true});
//		num.put(7, new boolean[] {true, true, true, false, false, true, false});
//		num.put(8, new boolean[] {true, true, true, true, true, true, true});
//		num.put(9, new boolean[] {true, true, true, true, false, true, true});
//		num.put(10, new boolean[] {false, false, false, false, false, false, false});
//		
//		int count = 0;
//		
//		if(a == 10 && b != 10) {
//			for(int i = 0; i < 7; i++) {
//				if(num.get(b)[i] == true) {
//					count++;
//				}
//			}
//		}
//		
//		if(a != 10 && b == 10) {
//			for(int i = 0; i < 7; i++) {
//				if(num.get(a)[i] == true) {
//					count++;
//				}
//			}
//		}
//		
//		if(a != 10 && b != 10) {
//			for(int i = 0; i < 7; i++) {
//				if(num.get(a)[i] != num.get(b)[i]) {
//					count++;
//				}
//			}
//		}
//		
//		return count;
//	}
//	
//	public static void main(String[] args) throws Exception{
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		int T = Integer.valueOf(reader.readLine());
//		int a = 0;
//		int b = 0;
//		int count = 0;
//		
//		for(int i = 0; i < T; i++) {
//			st = new StringTokenizer(reader.readLine());
//			
//			String A = st.nextToken();
//			String B = st.nextToken();
//			
//			int[] arr_A = new int[A.length()];
//			int[] arr_B = new int[B.length()];
//			
//			for(int j = 0; j < A.length(); j++) {
//				arr_A[j] = Integer.valueOf(A.charAt(j) - '0');
//			}
//			for(int j = 0; j < B.length(); j++) {
//				arr_B[j] = Integer.valueOf(B.charAt(j) - '0');
//			}
//			
//			Stack<Integer> stack_A = new Stack<>();
//			Stack<Integer> stack_B = new Stack<>();
//			
//			for(int j = 0; j < arr_A.length; j++) {
//				stack_A.add(arr_A[j]);
//			}
//			
//			for(int j = 0; j < arr_B.length; j++) {
//				stack_B.add(arr_B[j]);
//			}
//			
//			if(stack_A.isEmpty()) {
//				a = 10;
//			} else {
//				a = stack_A.pop();
//			}
//			
//			if(stack_B.isEmpty()) {
//				b = 10;
//			} else {
//				b = stack_B.pop();
//			}
//			
//			count += compare(a, b);
//			
//			System.out.println(count);
//		}
//	}

}
