package javaChapter9;

// 바깥 클래스
public class A {
	// 중첩 클래스
	A() {
		System.out.println("A 객체가 생성됨");
	}
	
	class B {	// 인스턴스 멤버 클래스
		B() {
			System.out.println("B 객체가 생성됨");
		}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	static class C {	// 정적 멤버 클래스
		C() {
			System.out.println("C 객체가 생성됨");
		}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	void method() {
		class D {	// 로컬 클래스
			D() {
				System.out.println("D 객체가 생성됨");
			}
			int field1;
			static int field2;
			void method1() {}
			static void method2() {}
		}
		
		D d = new D();
		d.field1 = 3;
		d.method1();
	}
	
	// 바깥 필드와 메서드에서 사용 제한
	B field1 = new B();	// 인스턴스 필드
	C field2 = new C();
	
//	static B field3 = new B();	// 제한
	static C field4 = new C();	// 정적 필드 초기화
	
	static void method2() {
//		B var1 = new B();	// 제한
		C var2 = new C();	// 정적 메서드
	}
	
	// 멤버 클래스에서 사용 제한
	int mField1;
	void mMethod1() {}
	static int mField2;
	static void mMethod2() {}
	class mB {
		void method() {	// 모든 필드, 메서드 접근 가능
			mField1 = 10;
			mMethod1();
			mField2 = 10;
			mMethod2();
		}
	}
	
	static class mC {
		void method() {
//			mField1 = 10;	// 인스턴스 필드, 메서드 접근 불가능
//			mMethod1();
			mField2 = 10;
			mMethod2();
		}
	}
}
