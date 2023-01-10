package javaProblem100;

// 변수
// 자바 메인 메서드에서 static 키워드의 역할에 대해 설명
// 작성한 자바 코드 실행시 static을 안쓰면 에러가 나는 이유 설명

// static: 정적
// static으로 선언된 함수(메서드)나 변수는 자바가상머신에서 인스턴스 객체의 생성 없이 호출 가능
// 객체 생성없이 해당 함수(메서드)를 호출해서 사용 가능
// 자바 프로그램을 실행하면 static으로 지정된 메서드를 찾아서 먼저 메모리에 할당
// static으로 지정된 메서드가 여러개인 경우, 객체를 생성하는 것과 상관없이 모두 메모리에 할당
// 이후 main 메서드를 찾아 실행

public class Problem003 {
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

}
