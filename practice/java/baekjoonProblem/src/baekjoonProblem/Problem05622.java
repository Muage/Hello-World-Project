package baekjoonProblem;

import java.util.*;

// ����
// ������� �ҸӴϴ� �Ʒ� �׸��� ���� ������ ���̾� ��ȭ�⸦ ����Ѵ�.
// ��ȭ�� �ɰ� ���� ��ȣ�� �ִٸ�, ���ڸ� �ϳ��� ���� ������ �ݼ� ���� �ִ� �� ���� �ð�������� ������ �Ѵ�.
// ���ڸ� �ϳ� ������ ���̾��� ó�� ��ġ�� ���ư���, ���� ���ڸ� �������� ���̾��� ó�� ��ġ���� �ٽ� ������ �Ѵ�.
// ���� 1�� �ɷ��� �� 2�ʰ� �ʿ��ϴ�.
// 1���� ū ���� �Ŵµ� �ɸ��� �ð��� �̺��� �� �ɸ���, �� ĭ ���� �ִ� ���ڸ� �ɱ� ���ؼ� 1�ʾ� �� �ɸ���.
// ������� �ҸӴϴ� ��ȭ ��ȣ�� �� ���ڿ� �ش��ϴ� ���ڷ� �ܿ��.
// ��, � �ܾ �� ��, �� ���ĺ��� �ش��ϴ� ���ڸ� �ɸ� �ȴ�.
// ���� ���, UNUCIC�� 868242�� ����.
// �ҸӴϰ� �ܿ� �ܾ �־����� ��, �� ��ȭ�� �ɱ� ���ؼ� �ʿ��� �ּ� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� ���ĺ� �빮�ڷ� �̷���� �ܾ �־�����.
// �ܾ��� ���̴� 2���� ũ�ų� ����, 15���� �۰ų� ����.

// ���
// ù° �ٿ� ���̾��� �ɱ� ���ؼ� �ʿ��� �ּ� �ð��� ����Ѵ�.

// ���� �Է�
// (1) WA
// (2) UNUCIC

// ���� ���
// (1) 13
// (2) 36

public class Problem05622 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int second = 0;
		String word = scanner.nextLine();
		
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == 'A' || word.charAt(i) == 'B' || word.charAt(i) == 'C') {
				second += 3;
			} else if(word.charAt(i) == 'D' || word.charAt(i) == 'E' || word.charAt(i) == 'F') {
				second += 4;
			} else if(word.charAt(i) == 'G' || word.charAt(i) == 'H' || word.charAt(i) == 'I') {
				second += 5;
			} else if(word.charAt(i) == 'J' || word.charAt(i) == 'K' || word.charAt(i) == 'L') {
				second += 6;
			} else if(word.charAt(i) == 'M' || word.charAt(i) == 'N' || word.charAt(i) == 'O') {
				second += 7;
			} else if(word.charAt(i) == 'P' || word.charAt(i) == 'Q' || word.charAt(i) == 'R' || word.charAt(i) == 'S') {
				second += 8;
			} else if(word.charAt(i) == 'T' || word.charAt(i) == 'U' || word.charAt(i) == 'V') {
				second += 9;
			} else if(word.charAt(i) == 'W' || word.charAt(i) == 'X' || word.charAt(i) == 'Y' || word.charAt(i) == 'Z') {
				second += 10;
			}
		}
		
		System.out.println(second);
		
		scanner.close();
	}

}
