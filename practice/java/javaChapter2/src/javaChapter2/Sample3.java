package javaChapter2;

public class Sample3 {
	public static void main(String[] args) {
		char ban = 'A';
		String name = "홍길동";
		
		int kor = 90;
		int eng = 95;
		int mat = 87;
		int tot = kor + eng + mat;
		float avg = (float)tot / 3;
		
		System.out.println("반: " + ban);
		System.out.println("이름: " + name);
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + mat);
		System.out.println("총점: " + tot);
		System.out.println("평균: " + avg);
	}
}
