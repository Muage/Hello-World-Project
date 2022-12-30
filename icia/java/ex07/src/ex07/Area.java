package ex07;

public class Area {	//사각형의 면적
	//필드
//	int x, y;
	static final double PI = 3.141592;	//상수
	
	//생성자
	Area() {
		
	}

	//생성자1 (오버로딩)
//	Area(int x) {	//int x : parameter
//		this.x = x;
//	}
	
	//생성자2 (오버로딩)
//	Area(int x, int y) {	//int x, int y : parameter
//		this.x = x;
//		this.y = y;
//	}
	
	//메소드
	//정사각형의 면적 메소드
	public int area(int x) {
		int area = x * x;
		return area;
	}
	
	//직사각형의 면적 메소드 (오버로딩)
	public int area(int x, int y) {
		int area = x *y;
		return area;
	}
	
	//원의 면적 메소드 (오버로딩)
	public double area(double x) {
		double area = x * x * PI;
		return area;
	}
}
