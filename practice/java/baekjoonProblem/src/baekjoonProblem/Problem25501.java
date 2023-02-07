package baekjoonProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ���� ( ��� �ܰ� )
// ���ִ� �Ĺ���� ��� �Լ��� �� �ٷ�� ����� �������� �˾ƺ��� ���� ��� �Լ��� ���õ� ������ �����ϱ�� �ߴ�.
// �Ӹ�����̶�, �տ������� �о��� ���� �ڿ������� �о��� ���� ���� ���ڿ��� ���Ѵ�.
// �Ӹ������ ���÷� AAA, ABBA, ABABA ���� �ְ�, �Ӹ������ �ƴ� ���ڿ��� ���÷� ABCA, PALINDROME ���� �ִ�.
// � ���ڿ��� �Ӹ�������� �Ǻ��ϴ� ������ ��� �Լ��� �̿��� ���� �ذ��� �� �ִ�.
// �Ʒ� �ڵ��� isPalindrome �Լ��� �־��� ���ڿ��� �Ӹ�����̸� 1, �Ӹ������ �ƴϸ� 0�� ��ȯ�ϴ� �Լ���.
// 
// #include <stdio.h>
// #include <string.h>
//
// int recursion(const char *s, int l, int r){
//     if(l >= r) return 1;
//     else if(s[l] != s[r]) return 0;
//     else return recursion(s, l+1, r-1);
// }
//
// int isPalindrome(const char *s){
//     return recursion(s, 0, strlen(s)-1);
// }
// 
// int main(){
//     printf("ABBA: %d\n", isPalindrome("ABBA")); // 1
//     printf("ABC: %d\n", isPalindrome("ABC"));   // 0
// }
// 
// ���ִ� ���� �ۼ��� isPalindrome �Լ��� �̿��Ͽ� � ���ڿ��� �Ӹ�������� ���θ� �Ǵ��Ϸ��� �Ѵ�.
// ��ü�����δ�, ���ڿ� S�� isPalindrome �Լ��� ���ڷ� �����Ͽ� �Ӹ���� ���θ� ��ȯ������ �˾Ƴ� ���̴�.
// ���Ҿ� �Ǻ��ϴ� �������� recursion �Լ��� �� �� ȣ���ϴ��� �� ���̴�.
// ���ָ� ���� �����е� �Լ��� ��ȯ���� recursion �Լ��� ȣ�� Ƚ���� ���غ���.

// �Է�
// ù° �ٿ� �׽�Ʈ���̽��� ���� T�� �־�����. (1 �� T �� 1000)
// ��° �ٺ��� T���� �ٿ� ���ĺ� �빮�ڷ� ������ ���ڿ� S�� �־�����. (1 �� |S| �� 1000)

// ���
// �� �׽�Ʈ���̽�����, isPalindrome �Լ��� ��ȯ���� recursion �Լ��� ȣ�� Ƚ���� �� �ٿ� �������� �����Ͽ� ����Ѵ�.

// ���� �Է�
// 5
// AAA
// ABBA
// ABABA
// ABCA
// PALINDROME

// ���� ���
// 1 2
// 1 3
// 1 3
// 0 2
// 0 1

// ��Ʈ
// public class Main{
//	 public static int recursion(String s, int l, int r){
//	     if(l >= r) return 1;
//	     else if(s.charAt(l) != s.charAt(r)) return 0;
//	     else return recursion(s, l+1, r-1);
//	 }
//	 public static int isPalindrome(String s){
//	     return recursion(s, 0, s.length()-1);
//	 }
//	 public static void main(String[] args){
//	     System.out.println("ABBA: " + isPalindrome("ABBA"));
//	     System.out.println("ABC: " + isPalindrome("ABC"));
//	 }
// }

public class Problem25501 {
	
	static int count = 0;
	
	public static int recursion(String s, int l, int r) {
		count++;
		if(l >= r) return 1;
		else if(s.charAt(l) != s.charAt(r)) return 0;
		else return recursion(s, l+1, r-1);
	}
	
	public static int isPalindrome(String s) {
		return recursion(s, 0, s.length()-1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(reader.readLine());
		
		for(int i = 0; i < t; i++) {
			count = 0;
			String str = reader.readLine();
			System.out.println(isPalindrome(str) + " " + count);
		}
	}

}
