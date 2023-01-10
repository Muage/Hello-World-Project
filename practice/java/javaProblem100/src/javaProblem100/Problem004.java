package javaProblem100;

// 변수
// 1.변수란 무엇인가?
// : 데이터를 저장하는 메모리 공간, 변하는 수

// 2. 변수 선언이란 무엇인가?
// : 변수를 사용하기 위해 변수의 타입에 맞는 선언을 해줘야 한다.

// 3. 변수의 용도는 무엇이고 왜 필요한가?
// : 저장, 연산 수행 시 값을 활용하기 위해

public class Problem004 {
	
	public static void main(String[] args) {
		System.out.println(3 + 4);
		
		int a;	// 정수가 저장될 변수 이름 a
		int b;
		int sum;
		
		a = 3;
		b = 4;
		
		sum = a + b;
		System.out.println(sum);
		
		sum = a + b + a;
		System.out.println(sum);
	}
	
}
