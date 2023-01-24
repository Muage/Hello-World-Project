package baekjoonProblem;

import java.util.*;

// ���� ( �⺻ ���� 1 �ܰ� )
// ��� �ݻ�ȸ�� �����ϴ� ���� �����ϴ� ����� �̹� ��ȸ�� �γ�ȸ���� �ǰ� �;� �� ���� ������� �ҷ� ��� �ݻ�ȸ�� �����Ϸ��� �Ѵ�.
// �� ����Ʈ�� ���ָ� �Ϸ��� ������ �ִµ�, ��a���� bȣ�� ����� �ڽ��� �Ʒ�(a-1)���� 1ȣ���� bȣ���� ������� ���� �ո�ŭ ������� ������ ��ƾ� �Ѵ١� �� ��� ������ �� ��Ű�� ���;� �Ѵ�.
// ����Ʈ�� ����ִ� ���� ���� ��� ���ֹε��� �� ��� ������ ��Ű�� �Դٰ� �������� ��, �־����� ���� ���� k�� n�� ���� k���� nȣ���� �� ���� ��� �ִ��� ����϶�. ��, ����Ʈ���� 0������ �ְ� �������� 1ȣ���� ������, 0���� iȣ���� i���� ���.

// �Է�
// ù ��° �ٿ� Test case�� �� T�� �־�����.
// �׸��� ������ ���̽����� �Է����� ù ��° �ٿ� ���� k, �� ��° �ٿ� ���� n�� �־�����.

// ���
// ������ Test case�� ���ؼ� �ش� ���� ���ֹ� ���� ����϶�.

// ����
// 1 �� k, n �� 14

// ���� �Է�
// 2
// 1
// 3
// 2
// 3

// ���� ���
// 6
// 10

public class Problem02775 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[][] apartment = new int[15][15];
		for(int i = 1; i < 15; i++) {
			apartment[0][i] = i;
		}
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 15; j++) {
				apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
			}
		}
		
		int t = scanner.nextInt();
		for(int i = 0; i < t; i++) {
			int k = scanner.nextInt();
			int n = scanner.nextInt();
			
			System.out.println(apartment[k][n]);
		}
		
		scanner.close();
	}

}
