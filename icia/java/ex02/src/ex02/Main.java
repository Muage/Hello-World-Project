package ex02;

public class Main {										//클래스 이름 첫 글자 : 대문자
	public static void main(String[] args) {			//메소드 이름 첫 글자 : 소문자
		
		/*												//주석 방법 2가지
		System.out.print("Hello~~~");					//print VS println
		print문은 console에 출력하는 명령어입니다.
		*/
		
//		System.out.println("저는 홍길동입니다.");
		
//		Integer.integerExample();						//정수형 변수 Integer 클래스 출력
		
//		System.out.println("");
		
//		Float.floatExample();

//		Double.doubleExample();
		
//		StringExample.stringExample();
		
//		Sungjuk.grade();
		
//		TypeChange.change();
		
		//단항연산자
		int x = 10;
		int z = ++x;									//x++;는 x = x + 1;와 같다.
		System.out.println(z);
		System.out.println(x);
		
		int y = 10;
		int k = --y;
		System.out.println(k);
		System.out.println(y);
		
		//산술연산자(+, -, *, /, %)
		int a = 9;
		int b = 7;
		int c = a % b;									//나머지 연산
		System.out.println(c);
		
		//문자열 연결
		String name = "홍길동\n";
		String school = "인천일보 아카데미";
		String info = name + school;
		System.out.println(info);
		
		//비교연산자(>, >=, <, <=, ==, !=)
		int num1 = 9;
		int num2 = 10;
		
		boolean result = num1 > num2;
		System.out.println(result);
		
		result = num1 < num2;
		System.out.println(result);
		
		result = num1 == num2;
		System.out.println(result);
		
		result = num1 != num2;
		System.out.println(result);
		
		//논리연산자(&&, ||, !)
		boolean value1 = false;
		boolean value2 = false;
		result = value1 && value2;
		System.out.println(result);
		
		result = value1 || value2;
		System.out.println(result);
		
		int n1 = 9;
		int n2 = 10;
		result = !((n1 < n2) || (n1 == n2));
		
		//20세 이상의 남자만 입장 가능
		char gender = 'M';
		int age = 49;
		result = (gender == 'M') && (age >= 20);
		System.out.println("입장가능(true), 불가능(false) : " + result);
		
		//삼항연산자
		String strResult = result == true ? "입장가능" : "입장불가능";
		System.out.println(strResult);
		
	}
}
