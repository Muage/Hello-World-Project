package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� ( Lv2. GBC )
// �۷ι� ����Ͻ� ����(GBC, Global Business Center)�� �����ڵ����׷� ���� ����̴�.
// ���� 7��, ���� 105��, ���� �� 570m�� �Ը�� 2026�� �Ϲݱ⿡ �ϰ��� ��ǥ�� ���� ���� �߿� �ִ�.
// �̷��� �ʰ��� ������ �������� �ʰ��� �°��Ⱑ ���� �Ѵ�.
// ���������� ������� ����� 0m ���� 100m���� ���� �������� ���������� �ӵ��� �˻��ϴ� ������ �ð� �Ǿ���.
// �������� ��Ǵ� ���������� ������ N���� �������� ������ �ش� ������ ���� �ӵ��� �־�����.
// ������ �� ���� 100m �̸� �� ������ ������ ���̿� ���� �ӵ� ��� ���� ������ �־�����.
// ���� ����. ������ 3�̶�� �� ��,
// �� ù ��° ������ ���̴� 50m �̰� ���� �ӵ��� 50m/s
// �� �� ��° ������ ���̴� 40m �̰� ���� �ӵ��� 40m/s
// �� �� ��° ������ ���̴� 10m �̰� ���� �ӵ��� 30m/s
// �� �������� ���� �ӵ��� �����(�� ���Ѽӵ��� �ʰ��ϸ�) ������ �ʰ��Ѹ�ŭ�� �ӵ��� �α׿� ���´�.
// �����ϰԵ� ���� ������ ���°� off ���������� ����� ������ �����͸� �޾ƺ� ���� ����.
// ����� ������ ������ ���̿� �ӵ��� ���Ͽ� �ù����� �� ��, ���� ���� �ӵ��� ũ�� ��� ���� ������ ���ؾ� �Ѵ�.
// M���� ������ �˻��Ѵٰ� �� �� ���� ���,
// �� ù ��° ������ ���� ���̴� 60m �̰� �ӵ��� 76m/s
// �� �� ��° ������ ���� ���̴� 18m �̰� �ӵ��� 28m/s
// �� �� ��° ������ ���� ���̴� 22m �̰� �ӵ��� 50m/s�̶�� ���� ��, ���� �ӵ��� ��� ���� ���̰� ū �ӵ��� ���� ����.
// ù��° ���� 50m �������� ���� �ӵ��� ���� ���� �ӵ��� ������ ��, ���� �ӵ��� 26m/s �ʰ��ߴ�.
// ���� �ι�° ������ �� ������ ù��° ������ 10m ���� ��ġ�µ�, �̶� ���� �ӵ��� 36m/s �ʰ��ϰ� �ȴ�.
// �� ���� �����鿡���� ���̰� �׺��� ũ�� �����Ƿ� ���� ū �ӵ� ���̴� 36m/s���� �� �� �ִ�.
// �־��� ������ ���Ѽӵ��� ���찡 �׽�Ʈ�� ������ �ӵ��� �������� ���� ũ�� ���� �ӵ��� �Ѿ ���� ������ ���غ���.

// ��������
// 1 �� N, M �� 100

// �Է�����
// ù �ٿ� N�� M�� �־�����.
// �� ���� �ٺ��� N���� ���� �� ������ ���� �� �ش� ���������� ���� �ӵ��� �־�����, ���� M���� ���� ���찡 �׽�Ʈ�ϴ� ������ ���̿� �ӵ��� �־�����.

// �������
// ���찡 �ù������� �ϴ� ���� ���� �ӵ��� ���� ũ�� ��� ���� ��� �Ѵ�.
// �� ���� �ӵ��� ����� ���� ���� 0�� ��� �Ѵ�.

// �Է¿���1
// 3 3
// 50 50
// 40 40
// 10 30
// 60 76
// 18 28
// 22 50

// ��¿���1
// 36

// �Է¿���2
// 3 3
// 50 90
// 10 90
// 40 50
// 50 40
// 10 100
// 40 40

// ��¿���2
// 10

public class Lv2_GBC {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		int speed = 0;
		int[][] limit = new int[N][2];
		int[][] race = new int[M][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			
			limit[i][0] = Integer.valueOf(st.nextToken());
			limit[i][1] = Integer.valueOf(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			
			race[i][0] = Integer.valueOf(st.nextToken());
			race[i][1] = Integer.valueOf(st.nextToken());
		}
		
		speed = Math.min(speed, limit[0][1] - race[0][1]);
		
		if(race[0][0] - limit[0][0] > 0) {
			speed = Math.min(speed, limit[1][1] - race[0][1]);
		} else if(race[0][0] - limit[0][0] < 0) {
			speed = Math.min(speed, limit[0][1] - race[1][1]);
		}
		
		if(race[0][0] + race[1][0] > limit[0][0] + limit[1][0]) {
			speed = Math.min(speed, limit[1][1] - race[1][1]);
			speed = Math.min(speed, limit[2][1] - race[1][1]);
		} else if(race[0][0] + race[1][0] == limit[0][0] + limit[1][0]) {
			speed = Math.min(speed, limit[2][1] - race[2][1]);
		} else if(race[0][0] + race[1][0] < limit[0][0] + limit[1][0]) {
			speed = Math.min(speed, limit[1][1] - race[1][1]);
			speed = Math.min(speed, limit[1][1] - race[2][1]);
		}
		
		System.out.println(speed * -1);
		
	}
	
	/*
	 * �ٸ� ��� �ڵ�
	 * ��� 1. ����: 0.0		����ð�: 69ms		�޸�: 10.37Mb
	 * test6_��Ÿ�ӿ���
	 */
//	public static int N, M;
//	
//	public static void main(String[] args) throws Exception {
//		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		
//		N = Integer.valueOf(st.nextToken());
//		M = Integer.valueOf(st.nextToken());
//		int max = 0;
//		int[][] limit = new int[N][2];
//		
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(reader.readLine());
//			limit[i][0] = Integer.valueOf(st.nextToken());
//			limit[i][1] = Integer.valueOf(st.nextToken());
//		}
//		
//		int[][] race = new int[M][2];
//		
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(reader.readLine());
//			race[i][0] = Integer.valueOf(st.nextToken());
//			race[i][1] = Integer.valueOf(st.nextToken());
//		}
//
//		int temp = 0;
//		
//		for(int i = 0; i < N; i++) {
//			for(int j = temp; j < M; j++) {
//				if(limit[i][0] < race[j][0]) {
//					race[j][0] -= limit[i][0];
//					if(race[j][1] - limit[i][1] > 0) {
//						max = Math.max(max, race[j][1] - limit[i][1]);
//					}
//					break;
//				} else if(limit[i][0] > race[j][0]) {
//					limit[i][0] -= race[j][0];
//					if(race[j][1] - limit[i][1] > 0) {
//						max = Math.max(max, race[j][1] - limit[i][1]);
//					}
//					temp++;
//				} else {
//					if(race[j][1] - limit[i][1] > 0) {
//						max = Math.max(max, race[j][1] - limit[i][1]);
//					}
//					temp++;
//					break;
//				}
//			}
//		}
//		
//		System.out.println(max);
//	}

}
