package javaChapter9;

public class Sample {
	public static void main(String[] args) {
		// A
		// 중첩 클래스(Nested Class)
		A a = new A();
		
		A.B b = a.new B();	// 인스턴스 멤버 클래스 객체 생성
		b.field1 = 3;
		b.method1();
		
		A.C c = new A.C();	// 정적 멤버 클래스 객체 생성
		c.field1 = 3;
		c.method1();
		A.C.field2 = 3;
		A.C.method2();
		
		a.method();	// 로컬 클래스 객체 생성위해 메서드 호출
		
		// Outter
		// 중첩 클래스에서 바깥 클래스 참조 얻기
		Outter outter = new Outter();
		Outter.Nested nested = outter.new Nested();
		nested.print();
		
		// 중첩 인터페이스
		Button btn = new Button();
		
		btn.setOnClickListener(new CallListener());
		btn.touch();
		
		btn.setOnClickListener(new MessageListener());
		btn.touch();
		
		// Person
		// 익명 객체
		Anonymous anony = new Anonymous();
		
		anony.field.wake();	// 필드 사용
		
		anony.method1();	// 로컬 변수 사용
		
		anony.method2 (	// 파라미터값 사용
			new Person() {	// 파라미터값
				void study() {
					System.out.println("공부합니다.");
				}
				
				@Override
				void wake() {
					System.out.println("8시에 일어납니다.");
					study();
				}
			}
		);
		
		// RemoteControl
		// 익명 구현 클래스와 객체 생성
		anony.field1.turnOn();	// 익명 객체 필드 사용
		
		anony.method3();	// 익명 객체 로컬 변수 사용
		
		anony.method2(new RemoteControl() {	// 익명 객체 파라미터값 사용
			@Override
			public void turnOn() {
				System.out.println("SmartTV를 켭니다.");
			}

			@Override
			public void turnOff() {
				System.out.println("SmartTV를 끕니다.");
			}
		});
		
		// Calculable
		// 익명 객체 로컬 변수 사용
		anony.method(0, 0);
	}
}
