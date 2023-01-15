package baekjoonProblem;

import java.util.*;

// ����
// ���� ��ҹ��ڿ� �������� �̷���� ���ڿ��� �־�����.
// �� ���ڿ����� �� ���� �ܾ ������?
// �̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
// ��, �� �ܾ ���� �� �����ϸ� ������ Ƚ����ŭ ��� ����� �Ѵ�.

// �Է�
// ù �ٿ� ���� ��ҹ��ڿ� �������� �̷���� ���ڿ��� �־�����.
// �� ���ڿ��� ���̴� 1,000,000�� ���� �ʴ´�.
// �ܾ�� ���� �� ���� ���еǸ�, ������ �����ؼ� ������ ���� ����.
// ���� ���ڿ��� �������� �����ϰų� ���� �� �ִ�.

// ���
// ù° �ٿ� �ܾ��� ������ ����Ѵ�.

// ���� �Է�
// (1) The Curious Case of Benjamin Button
// (2)  The first character is a blank
// (3) The last character is a blank 

// ���� ���
// (1) 6
// (2) 6
// (3) 6

public class Problem01152 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = 0;
		String sentence = scanner.next();
		char[] arrSentence = new char[sentence.length()];
		
		for(int i = 0; i < sentence.length(); i++) {
			arrSentence[i] = sentence.charAt(i);
			
			if(arrSentence[i] == ' ') count++;
		}
		
		System.out.println(sentence.length());
		System.out.println(Arrays.toString(arrSentence));
		System.out.println(count);
		
		scanner.close();
	}

}
