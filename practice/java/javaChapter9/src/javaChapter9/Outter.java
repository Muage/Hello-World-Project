package javaChapter9;

public class Outter {
	// ���� Ŭ�������� ��� ����
	public void method1(final int arg) {	// �ڹ� 7 ����
		final int localVariable = 1;
//		arg = 100;	// ����
//		localVariable = 100;
		
		class Innter {
			public void method() {
				int result = arg + localVariable;
			}
		}
	}
	
	public void method2(int arg) {	// �ڹ� 8 ����
		int localVariable = 1;
//		arg = 100;	// ����
//		localVariable = 100;
		
		class Innter {
			public void method() {
				int result = arg + localVariable;
			}
		}
	}
	
	// ��ø Ŭ�������� �ٱ� Ŭ���� ���� ���
	String field = "Outter-field";
	void method() {
		System.out.println("Outter-method");
	}
	
	class Nested {
		String field = "Nested-field";
		void method() {
			System.out.println("Nested-method");
		}
		
		void print() {
			System.out.println(this.field);	// ��ø ��ü ����
			this.method();
			
			System.out.println(Outter.this.field);	// �ٱ� ��ü ����
			Outter.this.method();
		}
	}
}
