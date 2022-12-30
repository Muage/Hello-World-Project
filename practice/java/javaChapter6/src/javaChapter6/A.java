package javaChapter6;

// 클래스 접근 제한
//class A {	// default 접근 제한
//	
//}

//public class A {
//	// 필드
//	A a1 = new A(true);
//	A a2 = new A(1);
//	A a3 = new A("문자열");
//	
//	// 생성자
//	public A(boolean b) {}
//	A(int b) {}
//	private A(String s) {}
//}

public class A {
	public int field1;
	int field2;
	private int field3;
	
	// 생성자
	public A() {
		// 클래스 내부의 경우 접근 제한자 영향 받지 않음
		field1 = 1;
		field2 = 1;
		field3 = 1;
		method1();
		method2();
		method3();
	}
	public void method1() {}
	void method2() {}
	private void method3() {}
}
