package javaChapter14;

public class UsingThis {
	public int outterField = 10;
	class Inner {
		int innerField = 20;
		void method() {
			MyFunctionalInterface4 fi4 = () -> {
				System.out.println("outterField: " + outterField);
				System.out.println("outterField: " + UsingThis.this.outterField + "\n");	// 바깥 객체의 참조를 얻기 위해 클래스명.this 사용
				
				System.out.println("innerField: " + innerField);	// 람다식 내부에서 this는 inner 객체 참조
				System.out.println("innerField: " + this.innerField + "\n");
				return innerField;
			};
			fi4.method();
		}
	}
}
