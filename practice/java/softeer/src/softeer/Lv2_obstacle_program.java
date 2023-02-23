package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ���� ( Lv2. ��ֹ� �ν� ���α׷� )
// ���������� SW �����Ͼ��� ��ſ��� ��ֹ��� ���θ� �ν��� �� �ִ� ���α׷��� ������ ������ �־�����.
// [�׸� 1] ���� ����
// �켱 [�׸� 1]�� ���� ���簢�� ����� ������ �ִ�.
// 1�� ��ֹ��� �ִ� ����, 0�� ���ΰ� �ִ� ���� ��Ÿ����.
// ����� �� ������ ������ ����� ��ֹ����� ������ ����� �����ϰ�, �ҷϿ� ��ȣ�� ���̷� �Ѵ�.
// ���⼭ ����Ǿ��ٴ� ���� � ��ֹ��� �¿�, Ȥ�� �Ʒ����� �پ� �ִ� ��츦 ���Ѵ�.
// �밢�� �� ��ֹ��� �ִ� ���� ����� ���� �ƴϴ�.
// [�׸� 2] ��� �� ��ȣ �ο�
// [�׸� 2]�� [�׸� 1]�� ��� ���� ��ȣ�� ���� ���̴�.
// ������ �Է��Ͽ� ��ֹ� ��ϼ��� ����ϰ�, �� ��Ͽ� ���ϴ� ��ֹ��� ���� ������������ �����Ͽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// ��������
// N�� ���簢�������� ���ο� ������ ũ��� ������ 5 �� N �� 25

// �Է�����
// �Է� ���� ù ��° �ٿ��� ������ ũ�� N�� �Էµǰ�, �� ���� N�ٿ��� ���� N���� �ڷ�(0Ȥ�� 1)�� �Էµȴ�.

// �������
// ù ��° �ٿ��� �� ��� ���� ��� �Ͻÿ�.
// �׸��� �� ��� �� ��ֹ��� ���� ������������ �����Ͽ� �� �ٿ� �ϳ��� ����Ͻÿ�.

// �Է¿���
// 7
// 1110111
// 0110101
// 0110101
// 0000100
// 0110000
// 0111110
// 0110000

// ��¿���
// 3
// 7
// 8
// 9

public class Lv2_obstacle_program {
	
	/*
	 * ��� 1. ����: 100.0		����ð�: 88ms		�޸�: 10.82Mb
	 */
	private static int n;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, -1, 0, 1};
	private static int[][] arr;
	private static boolean[][] check;
	private static ArrayList<Integer> list = new ArrayList<>(); 
	
	private static void block(int a, int b) {
		int size = 1;
		Queue<int[]> q = new LinkedList<>();
		
		check[a][b] = true;
		q.add(new int[] {a, b});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == 0 || check[nx][ny]) {
					continue;
				} else {
					check[nx][ny] = true;
					q.add(new int[] {nx, ny});
					size++;
				}
			}
		}
		
		list.add(size);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.valueOf(st.nextToken());
		arr = new int[n][n];
		check = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			String str = st.nextToken();
			
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.valueOf(str.charAt(j) - '0');
			}
		}

		int count = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!check[i][j] && arr[i][j] == 1) {
					count++;
					block(i, j);
				}
			}
		}
		
		System.out.println(count);
		Collections.sort(list);
		for(int i : list) {
			System.out.println(i);
		}
	}

}
