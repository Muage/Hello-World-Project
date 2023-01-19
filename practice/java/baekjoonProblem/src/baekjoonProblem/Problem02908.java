package baekjoonProblem;

import java.util.*;

// ���� ( ���ڿ� �ܰ� )
// ������� ���� ����� ������ ���� ���Ѵ�.
// ����� ���ڸ� �дµ� ������ �ִ�.
// �̷��� ������ ���ϴ� ����� ���ؼ� ����̴� ���� ũ�⸦ ���ϴ� ������ ���־���.
// ����̴� �� �ڸ� �� �� ���� ĥ�ǿ� ���־���.
// �� ������ ũ�Ⱑ ū ���� ���غ���� �ߴ�.
// ����� ���� �ٸ� ����� �ٸ��� �Ųٷ� �д´�.
// ���� ���, 734�� 893�� ĥ�ǿ� �����ٸ�, ����� �� ���� 437�� 398�� �д´�.
// ����, ����� �� �� �� ū ���� 437�� ū ����� ���� ���̴�.
// �� ���� �־����� ��, ����� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ����̰� ĥ�ǿ� ���� �� �� A�� B�� �־�����.
// �� ���� ���� ���� �� �ڸ� ���̸�, 0�� ���ԵǾ� ���� �ʴ�.

// ���
// ù° �ٿ� ����� ����� ����Ѵ�.

// ���� �Է�
// (1)	734 893
// (2)	221 231
// (3)	839 237

// ���� ���
// (1)	437
// (2)	132
// (3)	938

public class Problem02908 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int first = scanner.nextInt();
		int second = scanner.nextInt();
		
		int firstReverse = ((first % 10) * 100) + ((first % 100) - (first % 10)) + (first / 100);
		int secondReverse = ((second % 10) * 100) + ((second % 100) - (second % 10)) + (second / 100);
		
		int compare = 0;
		
		if(firstReverse > secondReverse) compare = firstReverse;
		else compare = secondReverse;
		
		System.out.println(compare);
		
		scanner.close();
	}

}
