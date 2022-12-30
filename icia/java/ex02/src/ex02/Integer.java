package ex02;

public class Integer {
	public static void integerExample() {
		
		//변수: 값을 저장할 수 있는 메모리 공간
		
		System.out.println("정수형 변수~~~~~~~~~~");
		int a = 3540;	//정수형 변수(int) a에 값 3을 저장한다.
		int b = 5009;	//정수형 변수 b에 값 5을 저장한다.
		int c = a + b;	//변수 a값과 변수 b의 값을 c에 저장한다.
		int d = a - b;
		int e = a * b;
		int f = a / b;
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println(a + "+" + b + "=" + c);
		System.out.println(a + "-" + b + "=" + d);
		System.out.println(a + "*" + b + "=" + e);
		System.out.println(a + "/" + b + "=" + f);
	}
}
