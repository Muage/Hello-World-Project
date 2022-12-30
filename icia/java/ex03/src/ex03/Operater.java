package ex03;

public class Operater {										//
	public static void execute() {
		System.out.println("----- 연산자 -----");
		System.out.println("1. 산술 연산자");
		int a =11;
		int b = 4;
		int c = a + b;
		int d = a - b;
		int e = a * b;
		double f = (double)a / b;
		int g = a % b;
		
		System.out.println(a + "더하기" + b + "=" + c);
		System.out.println(a + "빼기" + b + "=" + d);
		System.out.println(a + "곱하기" + b + "=" + e);
		System.out.println(a + "나누기" + b + "=" + f);
		System.out.println(a + "나누기" + b + "의 나머지=" + g);
		System.out.println("");
		
		System.out.println("2. 비교 연산자");
		boolean result = (a >= b);
		System.out.println(a + ">=" + b + " 결과:" + result);
		result = (a == b);
		System.out.println(a + "==" + b + " 결과:" + result);
		result = (a != b);
		System.out.println(a + "!=" + b + " 결과:" + result);
		System.out.println("");
		
		System.out.println("3. 논리 연산자");
		//a가 5보다 크고 b가 5보다 큽니까?
		result = (a > 5) && (b > 5);
		System.out.println("a가 5보다 크고 b가 5보다 큽니까? 결과:" + result);
		//a가 5보다 크거나 b가 5보다 큽니까?
		result = (a > 5) || (b > 5);
		System.out.println("a가 5보다 크거나 b가 5보다 큽니까? 결과:" + result);
		//a가 10이상이고 b가 10이상입니까?
		result = (a >= 10) && (b >= 10);
		System.out.println("a가 10이상이고 b가 10이상입니까? 결과:" + result);
		//a가 10이상이고 b가 5이하입니까?
		result = (a >= 10) && (b <= 5);
		System.out.println("a가 10이상이고 b가 5이하입니까? 결과:" + result);
		//a가 10이하이거나 b가 5이상입니까?
		result = (a <= 10) || (b >= 5);
		System.out.println("a가 10이하이거나 b가 5이상입니까? 결과:" + result);
		
		String gender = "남자";
		int age = 22;
		//성별이 여자이고 나이가 20세 이상입니까?
		result = (gender == "여자") && (age >= 20);
		System.out.println("성별이 여자이고 나이가 20세 이상입니까? 결과:" + result);
		
		//성별이 남자이거나 나이가 50세 이상입니까?
		result = (gender == "남자") || (age >= 50);
		System.out.println("성별이 남자이거나 나이가 50세 이상입니까? 결과:" + result);
	}
}
