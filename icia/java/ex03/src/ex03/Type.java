package ex03;

public class Type {
	public static void execute() {
		System.out.println("----- 변수타입 -----");
		System.out.println("1. 정수형 변수");
		int intValue = 3;
		System.out.println("intValue = " + intValue + "\n");
		
		System.out.println("2. 실수형 변수");
		double dubValue = 3.14;
		System.out.println("dubValue = " + dubValue + "\n");
		
		System.out.println("3. 문자형 변수");
		char charValue = 'A';
		System.out.println("charValue = " + charValue);
		
		String strValue = "홍길동";
		System.out.println("strValue = " + strValue + "\n");
		
		System.out.println("----- 변수타입 자동 변환-----");
		dubValue = 3.14;	//8byte
		intValue = 4;		//4byte
		dubValue = intValue;
		System.out.println("dubValue = " + dubValue + "\n");
		
		System.out.println("----- 변수타입 강제 변환-----");
		dubValue = 3.14;
		intValue = 4;
		intValue = (int)dubValue;
		System.out.println("intValue = " + intValue);
		
//		intValue = 97;
//		charValue = (char)intValue;
//		System.out.println("charValue = " + charValue);
	}
}
