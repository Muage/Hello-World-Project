package javaChapter8;

public class Driver {
	public void drive(Vehicle vehicle) {
		// ��ü Ÿ�� Ȯ��(instanceof)
		if(vehicle instanceof Bus) {	// vehicle �Ķ���Ͱ� �����ϴ� ��ü�� Bus���
			Bus bus = (Bus)vehicle;	// �����ϰ� ���� Ÿ�� ��ȯ
			bus.checkFare();
		}
		vehicle.run();
	}
}
