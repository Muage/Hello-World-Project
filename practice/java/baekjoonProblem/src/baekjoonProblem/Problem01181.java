package baekjoonProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// ���� ( ���� �ܰ� )
// ���ĺ� �ҹ��ڷ� �̷���� N���� �ܾ ������ �Ʒ��� ���� ���ǿ� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
// 1. ���̰� ª�� �ͺ���
// 2. ���̰� ������ ���� ������

// �Է�
// ù° �ٿ� �ܾ��� ���� N�� �־�����.
// (1 �� N �� 20,000)
// ��° �ٺ��� N���� �ٿ� ���� ���ĺ� �ҹ��ڷ� �̷���� �ܾ �� �ٿ� �ϳ��� �־�����.
// �־����� ���ڿ��� ���̴� 50�� ���� �ʴ´�.

// ���
// ���ǿ� ���� �����Ͽ� �ܾ���� ����Ѵ�.
// ��, ���� �ܾ ���� �� �Էµ� ��쿡�� �� ������ ����Ѵ�.

// ���� �Է�
// 13
// but
// i
// wont
// hesitate
// no
// more
// no
// more
// it
// cannot
// wait
// im
// yours

// ���� ���
// i
// im
// it
// no
// but
// more
// wait
// wont
// yours
// cannot
// hesitate

public class Problem01181 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		String[] arr = new String[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = scanner.next();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		});
		
		System.out.println(arr[0]);
		
		for(int i = 1; i < n; i++) {
			if(!arr[i].equals(arr[i - 1])) {
				System.out.println(arr[i]);
			}
		}
		
		scanner.close();
	}

}
