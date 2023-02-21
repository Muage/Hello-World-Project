package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// ���� ( Lv2. 8�� ���ӱ� )
// �����ڵ��������� �ε巴�� ���� ������ ������ 8�� ���� DCT ���ӱ⸦ �����Ͽ� N���� �������� �����Ͽ���.
// �����Ͽ� SW �����Ͼ��� ��ſ��� ���������� ������ �������� ������ �� �ִ� ���α׷��� ������ �ӹ��� �����Դ�.
// ����� ���ӱⰡ 1�ܿ��� 8������ ���������� ������ �Ѵٸ� ascending, 8�ܿ��� 1������ ���������� �����Ѵٸ� descending, �Ѵ� �ƴ϶�� mixed ��� �����ߴ�.
// ������ ������ �־����� �� �̰��� ascending����, descending����, �ƴϸ� mixed���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// ��������
// �־����� ���ڴ� ���� ������ ������ ���� �����̸�, 1���� 8���� ���ڰ� �ѹ��� �����Ѵ�.

// �Է�����
// ù° �ٿ� 8�� ���ڰ� �־�����.

// �������
// ù° �ٿ� ascending, descending, mixed �� �ϳ��� ����Ѵ�.

// �Է¿���
// 1 2 3 4 5 6 7 8

// ��¿���
// ascending

public class Lv2_8_Transmission {
	
	public static void main(String[] args) throws Exception {
		/*
		 * ��� 3. ����: 100.0		����ð�: 70ms		�޸�: 10.22Mb
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		String result = "";
		int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};
		int[] arr = new int[8];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		for(int i = 0; i < 8; i++) {
			if(Arrays.equals(arr, ascending)) {
				result = "ascending";
			} else if(Arrays.equals(arr, descending)) {
				result = "descending";
			} else {
				result = "mixed";
			}
		}
		
		System.out.println(result);
		
		
		/*
		 * ��� 2. ����: 100.0		����ð�: 75ms		�޸�: 10.25Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		Integer[] arr = new Integer[8];
//		Integer[] sort = new Integer[8];
//		String result = "";
//		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = Integer.valueOf(st.nextToken());
//			sort[i] = arr[i];
//		}
//		
//		for(int i = 0; i < 8; i++) {
//			Arrays.sort(sort);
//			if(Arrays.equals(arr, sort)) {
//				result = "ascending";
//			} else {
//				Arrays.sort(sort, Collections.reverseOrder());
//				if(Arrays.equals(arr, sort))
//					result = "descending";
//				else
//					result = "mixed";
//			}
//		}
//		
//		System.out.println(result);
		
		
		/*
		 * ��� 1. ����: 0.0		����ð�: 72ms		�޸�: 10.21Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		Integer[] sort = new Integer[8];
//		int[] arr = new int[8];
//		String result = "";
//		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = Integer.valueOf(st.nextToken());
//			sort[i] = arr[i];
//		}
//		
//		for(int i = 0; i < 8; i++) {
//			Arrays.sort(sort);
//			if(arr[i] == sort[i]) {
//				result = "ascending";
//			} else {
//				Arrays.sort(sort, Collections.reverseOrder());
//				if(arr[i] == sort[i])
//					result = "descending";
//				else
//					result = "mixed";
//			}
//		}
//		
//		System.out.println(result);
	}

}
