package javaChapter4;

public class Sample3 {
	public static void main(String[] args) {
		// 반복문
		// for문
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		
		// 1부터 100까지의 합
		int sum  = 0;
		
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("1~100 합 : " + sum);
		
		// 1부터 100까지의 합 2
		sum = 0;
		int i = 0;
		for(i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("i = " + i);
		System.out.println("sum = " + sum);
	}
}