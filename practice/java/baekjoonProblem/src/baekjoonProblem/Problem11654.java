package baekjoonProblem;

import java.util.*;

// ���� ( ���ڿ� �ܰ� )
// ���ĺ� �ҹ���, �빮��, ���� 0-9�� �ϳ��� �־����� ��, �־��� ������ �ƽ�Ű �ڵ尪�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ���ĺ� �ҹ���, �빮��, ���� 0-9 �� �ϳ��� ù° �ٿ� �־�����.

// ���
// �Է����� �־��� ������ �ƽ�Ű �ڵ� ���� ����Ѵ�.

// ���� �Է�
// (1) A
// (2) C
// (3) 0
// (4) 9
// (5) a
// (6) z

// ���� ���
// (1) 65
// (2) 67
// (3) 48
// (4) 57
// (5) 97
// (6) 122

public class Problem11654 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String x = scanner.next();
		int ascii = Integer.valueOf(x.charAt(0));
		System.out.println(ascii);
		
		scanner.close();
	}
	
}
