package javaChapter9;

public class Anonymous {
	// �͸� ��ü
	Person field = new Person() {	// �ʵ� ���� �ʱⰪ ����
		void work() {
			System.out.println("����մϴ�.");
		}
		
		@Override
		void wake() {
			System.out.println("6�ÿ� �Ͼ�ϴ�.");
			work();
		}
	};
	
	void method1() {
		Person localVar = new Person() {	// ���� ������ ����
			void walk() {
				System.out.println("��å�մϴ�.");
			}
			
			@Override
			void wake() {
				System.out.println("7�ÿ� �Ͼ�ϴ�.");
				walk();
			}
		};
		
		localVar.wake();	// ���� ���� ���
	}
	
	void method2(Person person) {
		person.wake();
	}
	
	// RemoteControl
	// �͸� ���� Ŭ������ ��ü ����
	RemoteControl field1 = new RemoteControl() {	// �ʵ� ���� �ʱⰪ ����
		@Override
		public void turnOn() {
			System.out.println("TV�� �մϴ�.");
		}

		@Override
		public void turnOff() {
			System.out.println("TV�� ���ϴ�.");
		}
	};
	
	void method3() {
		RemoteControl localVar = new RemoteControl() {	// ���� ���� ���� �ʱⰪ ����
			@Override
			public void turnOn() {
				System.out.println("Audio�� �մϴ�.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("Audio�� ���ϴ�.");
			}
		};
		
		localVar.turnOn();	// ���� ���� ���
	}
	
	void method2(RemoteControl rc) {
		rc.turnOn();
	}
	
	// Calculable
	// �͸� ��ü ���� ���� ���
	private int field2;
	
	public void method(final int arg1, int arg2) {
		final int var1 = 0;
		int var2 = 0;
		field2 = 10;
		
//		arg1 = 20;	// ����
//		arg2 = 20;
//		var1 = 30;
//		var2 = 30;
		
		Calculable calc = new Calculable() {
			@Override
			public int sum() {
				int result = field2 + arg1 + arg2 + var1 + var2;
				return result;
			}
		};
		System.out.println(calc.sum());
	}
}
