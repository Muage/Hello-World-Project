package javaChapter8;

public class Sample {
	public static void main(String[] args) {
		// RemoteControl
		// 익명 구현
		RemoteControl rc;
		rc = new Television();
		rc = new Audio();
		
		rc = new RemoteControl() {
			public void turnOn() {
				
			}
			
			public void turnOff() {			
			}
			
			public void setVolume(int volume) {
				
			}
		};
		
		// 추상메서드
		rc = null;
		
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		
		// 디폴트메서드
		rc = null;
		
		rc = new Television();
		rc.turnOn();
		rc.setMute(true);
		
		rc = new Audio();
		rc.turnOn();
		rc.setMute(true);
		
		// 정적메서드
		RemoteControl.changeBattery();
		
		// 필드 다형성
		Car myCar = new Car();
		myCar.run();
		myCar.frontLeftTire = new KumhoTire();
		myCar.fronRightTire = new KumhoTire();
		myCar.run();
		
		// 배열 구현 객체 관리
		Car myArrCar = new Car();
		myArrCar.arrRun();
		
		myArrCar.tires[0] = new KumhoTire();
		myArrCar.tires[1] = new KumhoTire();
		
		myArrCar.arrRun();
		
		// Driver
		// 매개변수 다형성
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);
		
		// 강제 타입 변환(Casting)
		Vehicle vehicle = new Bus();
		
		vehicle.run();
//		vehicle.checkFare();	// Vehicle 인터페이스에는 checkFare()가 없음
		
		Bus castingBus = (Bus)vehicle;
		castingBus.run();
		castingBus.checkFare();
		
		Bus test = new Bus();	// ** 바로 Bus 타입으로 선언할 수 있는지 테스트 **
		test.run();
		test.checkFare();
		
		// InterfaceA-B-C
		// 인터페이스 상속
		ImplementationC impl = new ImplementationC();
		
		InterfaceA ia = impl;	// InterfaceA는 methodA()만 호출 가능
		ia.methodA();
		System.out.println();
		
		InterfaceB ib = impl;	// InterfaceB는 methodB만 호출 가능
		ib.methodB();
		System.out.println();
		
		InterfaceC ic = impl;	// InterfaceC는 methodA(), methodAB(), methodAC() 모두 호출 가능
		ic.methodA();
		ic.methodB();
		ic.methodC();
		
		// MyInterface
		// 디폴트 메서드
		MyInterface mi1 = new MyClassA();
		mi1.method1();
		mi1.method2();
		
		MyInterface mi2 = new MyClassB();
		mi2.method1();
		mi2.method2();
		
		// ParentInterface
		// 디폴트 메서드 인터페이스 상속
		ChildInterface1 ci1 = new ChildInterface1() {
			@Override
			public void method1() {}
			
			@Override
			public void method3() {}
		};
		ci1.method1();
		ci1.method2();
		ci1.method3();
		
		ChildInterface2 ci2 = new ChildInterface2() {
			@Override
			public void method1() {}
			
			@Override
			public void method3() {}
		};
		ci2.method1();
		ci2.method2();
		ci2.method3();
		
		ChildInterface3 ci3 = new ChildInterface3() {
			@Override
			public void method1() {}
			
			@Override
			public void method2() {}
			
			@Override
			public void method3() {}
		};
		ci3.method1();
		ci3.method2();
		ci3.method3();
	}
}