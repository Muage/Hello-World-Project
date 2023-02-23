package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ���� ( Lv2. ���� �ڵ� ���� )
// �����ڵ����׷��� ����3 ���������� ���ȭ ��ǥ�� �߸��� �ѷ��� ���ϰ� �ִ� ���, ���� �ְ� ������ ���� ���� ������� ������ ���뿥������Ʈ�� �������࿡ �ʿ��� ���������� ������ �����ϰ�, ��� ��ȭ�� ���� ������ �����ϰ� �ִ�.
// �ֱٿ��� ���� �����͸� ������� �ڵ����� ���������� �����ϴ� ������ �ڵ� ����(Map Auto Creation, ���� MAC)�� ����� ������ ���� ���� �ð��� �����ϰ� ���е��� ����Ű�� �� �����ߴ�.
// ������������ ���� ������ ���� �ñ������� ���ͳ� �˻��� �غ���, Diamond-Square-Algorithm�̶�� ���� ã�� �Ǿ���.
// �� �˰����� ���簢���� �̷�� �� 4���� ���� �� �Ŀ��� ������ ���� ������ ���� ����� ���������.
// ���簢���� �� ���� �߾ӿ� ���� �ϳ� �߰��Ѵ�.
// ���簢���� �߽ɿ� ���� �ϳ� �߰��Ѵ�.
// [�׸�]�� 0�ܰ�(start)���� 2�ܰ�(2 iterations)���� ������ ����̴�.
// �� �ܰ�(N)�� ����ؼ� Ŀ�������� ���� ���� Ŀ������.

// ��������
// 1 �� N �� 15

// �Է�����
// ù° �ٿ� N�� �־�����.

// �������
// ù° �ٿ� N�ܰ踦 ��ģ ���� ������ ����Ѵ�.

// �Է¿���
// 1

// ��¿���
// 9

public class Lv2_map_auto_creation {
	
	public static void main(String[] args) throws Exception {
		
		/*
		 * ��� 1. ����: 100.0		����ð�: 69ms		�޸�: 10.21Mb
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(reader.readLine());
		int[] arr = new int[n + 1];
		
		arr[0] = 4;
		
		for(int i = 1; i < n + 1; i++) {
			int temp = (int) (Math.sqrt(arr[i - 1]) + Math.pow(2, i - 1));
			arr[i] = temp * temp;
		}
		
		System.out.println(arr[n]);
	}

}
