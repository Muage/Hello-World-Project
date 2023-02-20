package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// ���� ( Lv2. �ݰ����� )
// ������ �賶�� �ϳ� �ް� ����ݰ� ���Դ�.
// �ݰ� �ȿ��� ����� ��, ��, ��� ���� �ͱݼ� ����� �ܶ� ����ִ�.
// �賶�� W ������ ���� �� �ִ�.
// �� �ݼ��� ���Կ� ���Դ� ������ �־����� �� �賶�� ä�� �� �ִ� ���� ����� ������ ���ΰ�?
// ������ �������� ������ ������ �ͱݼ��� ������ �ڸ��� �߷��� �κ��� ���Ը�ŭ ��ġ�� ������.

// ��������
// 1 �� N �� 10^6�� ����
// 1 �� W �� 10^4�� ����
// 1 �� M_i, P_i �� 10^4�� ����

// �Է�����
// ù ��° �ٿ� �賶�� ���� W�� �ͱݼ��� ���� N�� �־�����.
// i + 1 (1 �� i �� N)��° �ٿ��� i��° �ݼ��� ���� M_i�� ���Դ� ���� P_i�� �־�����.

// �������
// ù ��° �ٿ� �賶�� ���� �� �ִ� ���� ��� ������ ����϶�.

// �Է¿���
// 100 2
// 90 1
// 70 2

// ��¿���
// 170

public class Lv2_safebreaking {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(reader.readLine());
		
		int w = Integer.valueOf(st.nextToken());
		int n = Integer.valueOf(st.nextToken());
		int price = 0;
		int[][] arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			
			arr[i][0] = Integer.valueOf(st.nextToken());
			arr[i][1] = Integer.valueOf(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
		for(int[] item : arr) {
			if(w > item[0]) {
				price += item[0] * item[1];
				 w -= item[0];
			} else {
				price += w * item[1];
				break;
			}
		}
		
		System.out.println(price);
	}

}
