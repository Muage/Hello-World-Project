package javaChapter9;

public class Button {
	// 중첩 인터페이스
	OnClickListener listener;	// 인터페이스 타입 필드
	
	void setOnClickListener(OnClickListener listener) {	// 파라미터 다형성
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();	// 구현 객체의 onClick() 호출
	}
	
	interface OnClickListener {	// 중첩 인터페이스
		void onClick();
	}
}
