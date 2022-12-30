package javaChapter9;

// �ٱ� Ŭ����
public class A {
	// ��ø Ŭ����
	A() {
		System.out.println("A ��ü�� ������");
	}
	
	class B {	// �ν��Ͻ� ��� Ŭ����
		B() {
			System.out.println("B ��ü�� ������");
		}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	static class C {	// ���� ��� Ŭ����
		C() {
			System.out.println("C ��ü�� ������");
		}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	void method() {
		class D {	// ���� Ŭ����
			D() {
				System.out.println("D ��ü�� ������");
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
	
	// �ٱ� �ʵ�� �޼��忡�� ��� ����
	B field1 = new B();	// �ν��Ͻ� �ʵ�
	C field2 = new C();
	
//	static B field3 = new B();	// ����
	static C field4 = new C();	// ���� �ʵ� �ʱ�ȭ
	
	static void method2() {
//		B var1 = new B();	// ����
		C var2 = new C();	// ���� �޼���
	}
	
	// ��� Ŭ�������� ��� ����
	int mField1;
	void mMethod1() {}
	static int mField2;
	static void mMethod2() {}
	class mB {
		void method() {	// ��� �ʵ�, �޼��� ���� ����
			mField1 = 10;
			mMethod1();
			mField2 = 10;
			mMethod2();
		}
	}
	
	static class mC {
		void method() {
//			mField1 = 10;	// �ν��Ͻ� �ʵ�, �޼��� ���� �Ұ���
//			mMethod1();
			mField2 = 10;
			mMethod2();
		}
	}
}
