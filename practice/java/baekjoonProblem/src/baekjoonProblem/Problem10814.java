package baekjoonProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// ���� ( ���� �ܰ� )
// �¶��� ������ ������ ������� ���̿� �̸��� ������ ������� �־�����.
// �̶�, ȸ������ ���̰� �����ϴ� ������, ���̰� ������ ���� ������ ����� �տ� ���� ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� �¶��� ���� ȸ���� �� N�� �־�����. (1 �� N �� 100,000)
// ��° �ٺ��� N���� �ٿ��� �� ȸ���� ���̿� �̸��� �������� ���еǾ� �־�����.
// ���̴� 1���� ũ�ų� ������, 200���� �۰ų� ���� �����̰�, �̸��� ���ĺ� ��ҹ��ڷ� �̷���� �ְ�, ���̰� 100���� �۰ų� ���� ���ڿ��̴�.
// �Է��� ������ ������ �־�����.

// ���
// ù° �ٺ��� �� N���� �ٿ� ���� �¶��� ���� ȸ���� ���� ��, ���̰� ������ ������ ������ �� �ٿ� �� �� ���̿� �̸��� �������� ������ ����Ѵ�.

// ���� �Է�
// 3
// 21 Junkyu
// 21 Dohyun
// 20 Sunyoung

// ���� ���
// 20 Sunyoung
// 21 Junkyu
// 21 Dohyun

public class Problem10814 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		String[][] arr = new String[n][2];
		
		for(int i = 0; i < n; i++) {
			arr[i][0] = scanner.next();
			arr[i][1] = scanner.next();
		}
		
		Arrays.sort(arr, new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				return Integer.valueOf(s1[0]) - Integer.valueOf(s2[0]);
			}
		});
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
		
		scanner.close();
	}

}
