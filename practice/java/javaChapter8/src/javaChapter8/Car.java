package javaChapter8;

public class Car {
	Tire frontLeftTire = new HankookTire();
	Tire fronRightTire = new HankookTire();
	Tire backLeftTire = new HankookTire();
	Tire backRightTire = new HankookTire();
	
	void run() {
		frontLeftTire.roll();
		fronRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
	}
	
	// �迭 ���� ��ü ����
	Tire[] tires = {
			new HankookTire(),
			new HankookTire(),
			new HankookTire(),
			new HankookTire(),
	};
	
	void arrRun() {
		for(Tire tire : tires) {
			tire.roll();
		}
	}
}
