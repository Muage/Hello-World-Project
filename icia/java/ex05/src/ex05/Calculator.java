package ex05;

public class Calculator {
	//필드(속성)
	int num1 = 0;	//전역변수
	int num2 = 0;
	int sum;
	int sub;
	int mul;
	double div;
	
	//생성자
//	Calculator() {	//기본 생성자는 정의하지 않아도 자동으로 생성되기 때문에 생략 가능
//		
//	}
	
	//메소드
	public void execute() {
		sum = num1 + num2;	//지역변수
		sub = num1 - num2;
		mul = num1 * num2;
		div = (double)num1 / num2;
	}
	
	public void print() {
		System.out.println(num1 + "+" + num2 + "=" + sum);
		System.out.println(num1 + "-" + num2 + "=" + sub);
		System.out.println(num1 + "*" + num2 + "=" + mul);
		System.out.println(num1 + "/" + num2 + "=" + div);
	}
}
