package javaChapter6;

// 클래스 접근 제한
//public class B {	// public 접근 제한
//	A a;	// A클래스 접근 가능(필드 선언 가능)
//}

//public class B {
//	A a1 = new A(true);
//	A a2 = new A(1);
////	A a3 = new A("문자열");	// private 생성자 접근 불가
//}

public class B {
	public B() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
//		a.field3 = 1;	// private 필드 접근 불가
		a.method1();
		a.method2();
//		a.method3();	// private 메서드 접근 불가
	}
}

