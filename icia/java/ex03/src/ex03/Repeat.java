package ex03;

public class Repeat {
	public static void execute() {
		//반복문(for)
		System.out.println("반복문 (for)");
		
		int tot = 0;
		for(int i=1; i<=1000; i++) {
			tot = tot + i;									//i의 값을 누적해서 tot에 저장
		}
		System.out.println("1~1000까지의 합 = " + tot);
		
		int sum = 0;
		for(int i=2; i<=100; i=i+2) {
			sum = sum + i;
		}
		System.out.println("1~100까지의 짝수의 합 = " + sum);
		
		sum = 0;
		for(int i=1; i<=100; i=i+2) {
			sum = sum + i;
		}
		System.out.println("1~100까지의 홀수의 합 = " + sum);
		
		System.out.println("-------------------------");
		
		//반복문(while)
		System.out.println("반복문 (while)");
		int i = 1;
		sum = 0;
		while(i <= 100) {
			sum = sum + i;
			i = i + 1;
		}
		System.out.println("1~100까지의 합 = " + sum);
		
		int a = 2;
		sum = 0;
		while(a <= 100) {
			sum = sum + a;
			a = a + 2;
		}
		System.out.println("1~100까지의 짝수의 합 = " + sum);
		
		int b = 1;
		sum = 0;
		while(b < 100) {
			sum = sum + b;
			b = b + 2;
		}
		System.out.println("1~100까지의 홀수의 합 = " + sum);
	}
}
