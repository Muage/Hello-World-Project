package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			String str = st.nextToken();
			
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.valueOf(str.charAt(j) - '0');
			}
		}
	}

}
