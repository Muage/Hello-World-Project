package javaChapter6_1;

import javaChapter6.*;

//public class C {
////	A a;	// AŬ���� ���� �Ұ�
//	B b;
//}

//public class C {
//	A a1 = new A(true);
////	A a2 = new A(1);		// default ������ ���� �Ұ�
////	A a3 = new A("���ڿ�");	// private ������ ���� �Ұ�
//}

public class C {
	public C() {
		A a = new A();
		a.field1 = 1;
//		a.field2 = 1;	// default �ʵ� ���� �Ұ�
//		a.field3 = 1;	// private �ʵ� ���� �Ұ�
		a.method1();
//		a.method2();	// default �޼��� ���� �Ұ�
//		a.method3();	// private �޼��� ���� �Ұ�
	}
}

