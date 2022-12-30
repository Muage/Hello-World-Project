package javaChapter6_1;

import javaChapter6.*;

//public class C {
////	A a;	// A클래스 접근 불가
//	B b;
//}

//public class C {
//	A a1 = new A(true);
////	A a2 = new A(1);		// default 생성자 접근 불가
////	A a3 = new A("문자열");	// private 생성자 접근 불가
//}

public class C {
	public C() {
		A a = new A();
		a.field1 = 1;
//		a.field2 = 1;	// default 필드 접근 불가
//		a.field3 = 1;	// private 필드 접근 불가
		a.method1();
//		a.method2();	// default 메서드 접근 불가
//		a.method3();	// private 메서드 접근 불가
	}
}

