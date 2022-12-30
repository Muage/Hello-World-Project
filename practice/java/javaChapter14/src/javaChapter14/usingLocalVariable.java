package javaChapter14;

public class usingLocalVariable {
	void method(int arg) {	// arg는 final 특성을 가짐
		int localVar = 40;	// localVar final 특성
		
//		arg = 31;	// final 특성 때문에 수정 불가
//		localVar = 41;
		
		MyFunctionalInterface4 fi4 = () -> {	// 람다식
			System.out.println("arg: " + arg);	// 로컬 변수 읽기
			System.out.println("localVar: " + localVar + "\n");
			return localVar;
		};
		fi4.method();
	}
}
