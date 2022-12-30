package javaChapter2;

public class Sample2 {
	public static void main(String[] args) {
		float a = 3.14f;
		int b = 5;
		float c = b * b * a;
		System.out.println("반지름이 " + b + ", 원의 넓이는 " + c + "입니다.");
		
		int d = 5;
		int e = 7;
		float f = (float)d * e * 1/2;
		
		System.out.println("밑변: " + d);
		System.out.println("높이: " + e);
		System.out.println("넓이: " + f);
	}
}
