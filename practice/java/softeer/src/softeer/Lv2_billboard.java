package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	
	private static int count = 0;
	
	private static void compare(int a, int b) {
		Map<Integer, boolean[]> num = new HashMap<>();
		num.put(0, new boolean[] {true, true, true, true, true, true, false});
		num.put(1, new boolean[] {false, true, true, false, false, false, false});
		num.put(2, new boolean[] {true, true, false, true, true, false, true});
		num.put(3, new boolean[] {true, true, true, true, false, false, true});
		num.put(4, new boolean[] {false, true, true, false, false, true, true});
		num.put(5, new boolean[] {true, false, true, true, false, true, true});
		num.put(6, new boolean[] {true, false, true, true, true, true, true});
		num.put(7, new boolean[] {true, true, true, false, false, true, false});
		num.put(8, new boolean[] {true, true, true, true, true, true, true});
		num.put(9, new boolean[] {true, true, true, true, false, true, true});
		num.put(10, new boolean[] {false, false, false, false, false, false, false});
		
		if(a == 10 && b != 10) {
			for(int i = 0; i < 7; i++) {
				if(num.get(b)[i] == true) {
					count++;
				}
			}
		}
		
		if(a != 10 && b == 10) {
			for(int i = 0; i < 7; i++) {
				if(num.get(a)[i] == true) {
					count++;
				}
			}
		}
		
		for(int i = 0; i < 7; i++) {
			if(num.get(a)[i] != num.get(b)[i]) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.valueOf(reader.readLine());
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(reader.readLine());
			
			String A = st.nextToken();
			String B = st.nextToken();
			
			int[] arr_A = new int[A.length()];
			int[] arr_B = new int[B.length()];
			
			for(int j = 0; j < A.length(); j++) {
				arr_A[j] = Integer.valueOf(A.charAt(j) - '0');
			}
			for(int j = 0; j < B.length(); j++) {
				arr_B[j] = Integer.valueOf(B.charAt(j) - '0');
			}
			
			Stack<Integer> stack_A = new Stack<>();
			Stack<Integer> stack_B = new Stack<>();
			
			for(int j = 0; j < arr_A.length; j++) {
				stack_A.add(arr_A[j]);
			}
			
			for(int j = 0; j < arr_B.length; j++) {
				stack_B.add(arr_B[j]);
			}
			
			if(stack_A.isEmpty()) {
				a = 10;
			} else {
				a = stack_A.pop();
			}
			
			if(stack_B.isEmpty()) {
				b = 10;
			} else {
				b = stack_B.pop();
			}
			
			compare(a, b);
		}
	}

}
