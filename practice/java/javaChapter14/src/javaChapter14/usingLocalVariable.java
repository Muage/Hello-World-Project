package javaChapter14;

public class usingLocalVariable {
	void method(int arg) {	// arg�� final Ư���� ����
		int localVar = 40;	// localVar final Ư��
		
//		arg = 31;	// final Ư�� ������ ���� �Ұ�
//		localVar = 41;
		
		MyFunctionalInterface4 fi4 = () -> {	// ���ٽ�
			System.out.println("arg: " + arg);	// ���� ���� �б�
			System.out.println("localVar: " + localVar + "\n");
			return localVar;
		};
		fi4.method();
	}
}
