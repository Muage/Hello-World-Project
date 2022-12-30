package javaChapter9;

public class Anonymous {
	// 익명 객체
	Person field = new Person() {	// 필드 선언 초기값 대입
		void work() {
			System.out.println("출근합니다.");
		}
		
		@Override
		void wake() {
			System.out.println("6시에 일어납니다.");
			work();
		}
	};
	
	void method1() {
		Person localVar = new Person() {	// 로컨 변수값 대입
			void walk() {
				System.out.println("산책합니다.");
			}
			
			@Override
			void wake() {
				System.out.println("7시에 일어납니다.");
				walk();
			}
		};
		
		localVar.wake();	// 로컬 변수 사용
	}
	
	void method2(Person person) {
		person.wake();
	}
	
	// RemoteControl
	// 익명 구현 클래스와 객체 생성
	RemoteControl field1 = new RemoteControl() {	// 필드 선언 초기값 대입
		@Override
		public void turnOn() {
			System.out.println("TV를 켭니다.");
		}

		@Override
		public void turnOff() {
			System.out.println("TV를 끕니다.");
		}
	};
	
	void method3() {
		RemoteControl localVar = new RemoteControl() {	// 로컬 변수 선언 초기값 대입
			@Override
			public void turnOn() {
				System.out.println("Audio를 켭니다.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("Audio를 끕니다.");
			}
		};
		
		localVar.turnOn();	// 로컬 변수 사용
	}
	
	void method2(RemoteControl rc) {
		rc.turnOn();
	}
	
	// Calculable
	// 익명 객체 로컬 변수 사용
	private int field2;
	
	public void method(final int arg1, int arg2) {
		final int var1 = 0;
		int var2 = 0;
		field2 = 10;
		
//		arg1 = 20;	// 제한
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
