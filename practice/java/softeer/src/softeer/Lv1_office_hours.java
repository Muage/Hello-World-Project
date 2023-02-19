package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� ( Lv1. �ٹ� �ð� )
// ����� �λ��� ��������, �� ������ ���¸� Ȯ���ϰ��� �Ѵ�.
// ����� ȸ��� ������������� �ǽ��ϱ� ������ �� ������ ��Ȯ�� �� �ÿ� ����ϴ� ���� �߿����� �ʰ�, �� �ٷ� �ð��� �� �������� �߿��ϴ�.
// �� �ٷ� �ð��� �����ٷνð��� �ʰ����� �ʾƾ� �ϸ鼭, ȸ��� ���� ���̿� ����� �ð� �̻��̾�� �ϱ� �����̴�.
// ������ �Ϸ� ���� �ٹ��� �ð��� ��� �ð��� ��� �ð� ������ �ð����� �����Ѵ�.
// �� ���������� �Ļ� �ð� �� �ٹ� �� �ð��� �ٹ� �ð����� �������� ������ �����϶�.
// �����Ϻ��� �ݿ��ϱ��� �ް��� ���� ���� ������ �� ���� ���� ����ϰ� ���� ����ߴ����� �־��� ��, �� ������ 5�� ���� �� �� ���� �ٹ��ߴ����� ���ϴ� ���α׷��� �ۼ��϶�.

// ��������
// ������ ���� ���� ������ �ʾҴ�.
// ��, ��� �ð��� ��� �ð��� 00:00 ����, 24:00 ������ �̷������.
// ����� �ð��� HH:MM�� ���� �������� �־�����.
// HH�� 00, 01, 02, .., 22, 23 �� �ϳ��̴�.
// MM�� 00, 01, 02, .., 58, 59 �� �ϳ��̴�.
// ������ ���� 1�� �̻��� ���Ͽ���.

// �Է�����
// ù ��° �ٿ��� �����Ͽ� ����� �ð��� �����Ͽ� ����� �ð��� ���� �ϳ��� ���̷� �ΰ� �־�����.
// �� ��° �ٿ��� ȭ���Ͽ� ����� �ð��� ȭ���Ͽ� ����� �ð��� ���� �ϳ��� ���̷� �ΰ� �־�����.
// �� ��° �ٿ��� �����Ͽ� ����� �ð��� �����Ͽ� ����� �ð��� ���� �ϳ��� ���̷� �ΰ� �־�����.
// �� ��° �ٿ��� ����Ͽ� ����� �ð��� ����Ͽ� ����� �ð��� ���� �ϳ��� ���̷� �ΰ� �־�����.
// �ټ� ��° �ٿ��� �ݿ��Ͽ� ����� �ð��� �ݿ��Ͽ� ����� �ð��� ���� �ϳ��� ���̷� �ΰ� �־�����.

// �������
// ù ��° �ٿ� ������ �� �ٹ� �ð��� �� ������ ����Ѵ�.

// �Է¿���
// (1)
// 10:00 19:00
// 09:00 15:00
// 10:00 11:00
// 11:00 22:00
// 09:00 15:00
// (2)
// 09:17 18:34
// 09:17 18:34
// 09:17 18:34
// 09:17 18:34
// 09:17 18:34
// (3)
// 09:17 19:24
// 10:11 18:45
// 09:34 18:27
// 10:47 15:33
// 08:47 18:32

// ��¿���
// (1)
// 1980
// (2)
// 2785
// (3)
// 2525

public class Lv1_office_hours {
	
	public static void main(String[] args) throws Exception {
		/*
		 * ��� 3. ����: 100.0		����ð�: 69ms		�޸�: 10.3Mb
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int week = 0;
		
		for(int i = 0; i < 5; i++) {
			int start = 0;
			int end = 0;
			int day = 0;
			int[] arr = new int[4];
			
			st = new StringTokenizer(reader.readLine(), ": ");
			
			for(int j = 0; st.hasMoreTokens(); j++) {
				 arr[j] = Integer.valueOf(st.nextToken());
			}
			
			for(int j = 0; j < arr.length; j++) {
				switch(j) {
				case 0:
					start = Integer.valueOf(arr[0]) * 60;
					break;
					
				case 1:
					start += Integer.valueOf(arr[1]);
					break;
					
				case 2:
					end = Integer.valueOf(arr[2]) * 60;
					break;
					
				case 3:
					end += Integer.valueOf(arr[3]);
					break;
				}
			}
			
			day = end - start;
			week += day;
		}
		
		System.out.println(week);
		
		
		/*
		 * ��� 2. ����: 100.0		����ð�: 73ms		�޸�: 10.71Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		int week = 0;
//		
//		for(int i = 0; i < 5; i++) {
//			String[] arr = reader.readLine().split(":| ");
//			int start = 0;
//			int end = 0;
//			int day = 0;
//			
//			for(int j = 0; j < arr.length; j++) {
//				switch(j) {
//				case 0:
//					start = Integer.valueOf(arr[0]) * 60;
//					break;
//					
//				case 1:
//					start += Integer.valueOf(arr[1]);
//					break;
//					
//				case 2:
//					end = Integer.valueOf(arr[2]) * 60;
//					break;
//					
//				case 3:
//					end += Integer.valueOf(arr[3]);
//					break;
//				}
//			}
//			
//			day = end - start;
//			week += day;
//		}
//		
//		System.out.println(week);
		
		/*
		 * ��� 1. ����: 100.0		����ð�: 76ms		�޸�: 10.23Mb
		 */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		int sum_weak = 0;
//		
//		for(int i = 0; i < 5; i++) {
//			st = new StringTokenizer(reader.readLine(), ": ");
//			int[] time = new int[4];
//			int start = 0;
//			int end = 0;
//			int sum_day = 0;
//			
//			for(int j = 0; st.hasMoreTokens(); j++) {
//				if(j % 2 == 0) {
//					time[j] = Integer.valueOf(st.nextToken()) * 60;
//				} else {
//					time[j] = Integer.valueOf(st.nextToken());
//				}
//				
//				if(j < 2) {
//					start += time[j];
//				} else {
//					end += time[j];
//				}
//				
//				sum_day = end - start;
//			}
//			sum_weak += sum_day;
//		}
//		
//		System.out.println(sum_weak);
	}

}