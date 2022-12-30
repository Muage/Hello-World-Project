package javaChapter3;

public class Sample {
	public static void main(String[] args) {
		// 연산자
		// 단항 연산자
		// 부호 연산자
		int x = 100;
		int result1 = +x;
		int result2 = -x;
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		
		// 증감 연산자
		int x1 = 10, y1 = 10, z1;
		
		x1++;	// x1 = 11, y1 = 10, z1  = 0
		++x1;	// x1 = 12, y1 = 10, z1  = 0
		System.out.println("x1 = " + x1);
		System.out.println("--------------------");
		
		y1--;	// x1 = 12, y1 = 9, z1  = 0
		--y1;	// x1 = 12, y1 = 8, z1  = 0
		System.out.println("y1 = " + y1);
		System.out.println("--------------------");
		
		z1 = x1++;	// x1 = 13, y1 = 8, z1  = 12
		System.out.println("z1 = " + z1);
		System.out.println("x1 = " + x1);
		System.out.println("--------------------");
		
		z1 = ++x1;	// x1 = 14, y1 = 8, z1  = 14
		System.out.println("z1 = " + z1);
		System.out.println("x1 = " + x1);
		System.out.println("--------------------");
		
		z1 = ++x1 + y1++;	// x1 = 15, y1 = 9, z1  = 23
		System.out.println("z1 = " + z1);
		System.out.println("x1 = " + x1);
		System.out.println("y1 = " + y1);
		
		// 논리 부정 연산자
		boolean play = true;
		System.out.println(play);
		
		play = !play;
		System.out.println(play);
		
		play = !play;
		System.out.println(play);
	}
}