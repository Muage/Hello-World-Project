package javaChapter9;

public class Outter {
	// 로컬 클래스에서 사용 제한
	public void method1(final int arg) {	// 자바 7 이전
		final int localVariable = 1;
//		arg = 100;	// 제한
//		localVariable = 100;
		
		class Innter {
			public void method() {
				int result = arg + localVariable;
			}
		}
	}
	
	public void method2(int arg) {	// 자바 8 이후
		int localVariable = 1;
//		arg = 100;	// 제한
//		localVariable = 100;
		
		class Innter {
			public void method() {
				int result = arg + localVariable;
			}
		}
	}
	
	// 중첩 클래스에서 바깥 클래스 참조 얻기
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
			System.out.println(this.field);	// 중첩 객체 참조
			this.method();
			
			System.out.println(Outter.this.field);	// 바깥 객체 참조
			Outter.this.method();
		}
	}
}
