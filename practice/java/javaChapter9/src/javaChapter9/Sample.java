package javaChapter9;

public class Sample {
	public static void main(String[] args) {
		// A
		// ��ø Ŭ����(Nested Class)
		A a = new A();
		
		A.B b = a.new B();	// �ν��Ͻ� ��� Ŭ���� ��ü ����
		b.field1 = 3;
		b.method1();
		
		A.C c = new A.C();	// ���� ��� Ŭ���� ��ü ����
		c.field1 = 3;
		c.method1();
		A.C.field2 = 3;
		A.C.method2();
		
		a.method();	// ���� Ŭ���� ��ü �������� �޼��� ȣ��
		
		// Outter
		// ��ø Ŭ�������� �ٱ� Ŭ���� ���� ���
		Outter outter = new Outter();
		Outter.Nested nested = outter.new Nested();
		nested.print();
		
		// ��ø �������̽�
		Button btn = new Button();
		
		btn.setOnClickListener(new CallListener());
		btn.touch();
		
		btn.setOnClickListener(new MessageListener());
		btn.touch();
		
		// Person
		// �͸� ��ü
		Anonymous anony = new Anonymous();
		
		anony.field.wake();	// �ʵ� ���
		
		anony.method1();	// ���� ���� ���
		
		anony.method2 (	// �Ķ���Ͱ� ���
			new Person() {	// �Ķ���Ͱ�
				void study() {
					System.out.println("�����մϴ�.");
				}
				
				@Override
				void wake() {
					System.out.println("8�ÿ� �Ͼ�ϴ�.");
					study();
				}
			}
		);
		
		// RemoteControl
		// �͸� ���� Ŭ������ ��ü ����
		anony.field1.turnOn();	// �͸� ��ü �ʵ� ���
		
		anony.method3();	// �͸� ��ü ���� ���� ���
		
		anony.method2(new RemoteControl() {	// �͸� ��ü �Ķ���Ͱ� ���
			@Override
			public void turnOn() {
				System.out.println("SmartTV�� �մϴ�.");
			}

			@Override
			public void turnOff() {
				System.out.println("SmartTV�� ���ϴ�.");
			}
		});
		
		// Calculable
		// �͸� ��ü ���� ���� ���
		anony.method(0, 0);
	}
}
