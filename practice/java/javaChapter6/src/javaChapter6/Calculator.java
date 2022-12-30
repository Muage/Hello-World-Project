package javaChapter6;

public class Calculator {
	// �޼���
	void powerOn() {
		System.out.println("������ �մϴ�.");
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
		System.out.println("������ ���ϴ�.");
	}
	
	// Ŭ���� ���ο��� �޼��� ȣ��
	void execute() {
		double result = avg(7, 10);
		println("������ : " + result);
	}
	
	void println(String message) {
		System.out.println(message);
	}
	
	// �޼��� �����ε�
	double areaRectangle(double width) {	// ���簢�� ����
		return width * width;
	}
	
	double areaRectangle(double width, double height) {	// ���簢�� ����
		return width * height;
	}
	
	// ���� ��� ���
	static double pi = 3.141592;
	
	static int pPlus(int x, int y) {
		return x + y;
	}
	
	static int pMinus(int x, int y) {
		return x - y;
	}
}
