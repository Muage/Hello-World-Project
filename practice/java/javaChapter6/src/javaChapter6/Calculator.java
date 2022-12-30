package javaChapter6;

public class Calculator {
	// 메서드
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	double avg(int x, int y) {
		double sum = plus(x, y);
		double result = sum / 2;
		return result;
	}
	
	double divide(int x, int y) {
		double result = (double)x / (double)y;
		return result;
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	// 클래스 내부에서 메서드 호출
	void execute() {
		double result = avg(7, 10);
		println("실행결과 : " + result);
	}
	
	void println(String message) {
		System.out.println(message);
	}
	
	// 메서드 오버로딩
	double areaRectangle(double width) {	// 정사각형 넓이
		return width * width;
	}
	
	double areaRectangle(double width, double height) {	// 직사각형 넓이
		return width * height;
	}
	
	// 정적 멤버 사용
	static double pi = 3.141592;
	
	static int pPlus(int x, int y) {
		return x + y;
	}
	
	static int pMinus(int x, int y) {
		return x - y;
	}
}
