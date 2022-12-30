package javaChapter3;

public class Sample2 {

	public static void main(String[] args) {
		// 연산자
		// 이항 연산자
		// 산술 연산자
		int v1 = 5, v2 = 2;
		
		int result1 = v1 + v2;
		System.out.println("result1 = " + result1);
		
		int result2 = v1 - v2;
		System.out.println("result2 = " + result2);
		
		int result3 = v1 * v2;
		System.out.println("result3 = " + result3);
		
		int result4 = v1 / v2;
		System.out.println("result4 = " + result4);
		
		int result5 = v1 % v2;
		System.out.println("result5 = " + result5);
		
		double result6 = (double)v1 % v2;
		System.out.println("result6 = " + result6);
		
		// 문자열 연결 연산자
		String str1 = "JDK" + 6.0;
		String str2 = str1 + " 특징";
		System.out.println(str2);
		
		String str3 = "JDK" + 3 + 3.0;
		String str4 = 3 + 3.0 + "JDK";
		System.out.println(str3);
		System.out.println(str4);
		
		// 비교 연산자
		int num1 = 10;
		int num2 = 10;
		boolean nresult1 = (num1 == num2);
		boolean nresult2 = (num1 != num2);
		boolean nresult3 = (num1 <= num2);
		System.out.println("nresult1 = " + nresult1);
		System.out.println("nresult2 = " + nresult2);
		System.out.println("nresult3 = " + nresult3);
		
		char char1 = 'A';
		char char2 = 'B';
		boolean nresult4 = (char1 < char2);
		System.out.println("nresult4 = " + nresult4);
		
		int n1 = 1;
		double n2 = 1.0;
		System.out.println(n1 == n2);
		
		double n3 = 0.1;
		float n4 = 0.1f;
		System.out.println(n3 == n4);
		System.out.println((float)n3 == n4);
		System.out.println((int)(n3*10) == (int)(n4*10));
		
		// 논리 연산자
		int a1 = 55;
		int a2 = 65;
		
		System.out.println(a1 >= 50 && a2 <= 60);
		System.out.println(a1 >= 50 || a2 <= 60);
		System.out.println(!(a1 < 50));
		System.out.println(!(a1 >= 50) && !(a2 <= 60));
		System.out.println(!(a1 >= 50) || !(a2 <= 60));
		
		// 대입 연산자
		int aresult = 0;
		
		aresult += 10;
		System.out.println("aresult = " + aresult);
		
		aresult -= 5;
		System.out.println("aresult = " + aresult);
		
		aresult *= 3;
		System.out.println("aresult = " + aresult);
		
		aresult /= 5;
		System.out.println("aresult = " + aresult);
		
		aresult %= 3;
		System.out.println("aresult = " + aresult);
	}

}
