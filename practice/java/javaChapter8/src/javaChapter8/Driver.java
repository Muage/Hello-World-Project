package javaChapter8;

public class Driver {
	public void drive(Vehicle vehicle) {
		// 객체 타입 확인(instanceof)
		if(vehicle instanceof Bus) {	// vehicle 파라미터가 참조하는 객체가 Bus라면
			Bus bus = (Bus)vehicle;	// 안전하게 강제 타입 변환
			bus.checkFare();
		}
		vehicle.run();
	}
}
