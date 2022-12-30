package javaChapter5;

public class Sample4 {
	public static void main(String[] args) {
		// main() 메서드 매개변수
		if(args.length != 2) {
			System.out.println("프로그램 사용법");
			System.out.println("java Sample num1 num20");
			System.exit(0);
		}
		
		String strNum1 = args[0];
		String strNum2 = args[1];
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}
}
