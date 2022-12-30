package javaChapter14;

public class UsingThis {
	public int outterField = 10;
	class Inner {
		int innerField = 20;
		void method() {
			MyFunctionalInterface4 fi4 = () -> {
				System.out.println("outterField: " + outterField);
				System.out.println("outterField: " + UsingThis.this.outterField + "\n");	// �ٱ� ��ü�� ������ ��� ���� Ŭ������.this ���
				
				System.out.println("innerField: " + innerField);	// ���ٽ� ���ο��� this�� inner ��ü ����
				System.out.println("innerField: " + this.innerField + "\n");
				return innerField;
			};
			fi4.method();
		}
	}
}
