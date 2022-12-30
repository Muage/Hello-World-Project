package javaChapter9;

public class Button {
	// ��ø �������̽�
	OnClickListener listener;	// �������̽� Ÿ�� �ʵ�
	
	void setOnClickListener(OnClickListener listener) {	// �Ķ���� ������
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();	// ���� ��ü�� onClick() ȣ��
	}
	
	interface OnClickListener {	// ��ø �������̽�
		void onClick();
	}
}
