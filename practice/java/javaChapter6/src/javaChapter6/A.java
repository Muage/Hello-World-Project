package javaChapter6;

// Ŭ���� ���� ����
//class A {	// default ���� ����
//	
//}

//public class A {
//	// �ʵ�
//	A a1 = new A(true);
//	A a2 = new A(1);
//	A a3 = new A("���ڿ�");
//	
//	// ������
//	public A(boolean b) {}
//	A(int b) {}
//	private A(String s) {}
//}

public class A {
	public int field1;
	int field2;
	private int field3;
	
	// ������
	public A() {
		// Ŭ���� ������ ��� ���� ������ ���� ���� ����
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
