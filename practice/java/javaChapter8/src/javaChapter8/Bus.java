package javaChapter8;

public class Bus implements Vehicle {
	@Override
	public void run() {
		System.out.println("������ �޸��ϴ�.");
	}

	// ���� Ÿ�� ��ȯ(Casting)
	public void checkFare() {
		System.out.println("��������� üũ�մϴ�.");
	}
}
