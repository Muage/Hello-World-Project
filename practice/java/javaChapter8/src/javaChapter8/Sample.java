package javaChapter8;

public class Sample {
	public static void main(String[] args) {
		// RemoteControl
		// �͸� ����
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
		
		// �߻�޼���
		rc = null;
		
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		
		// ����Ʈ�޼���
		rc = null;
		
		rc = new Television();
		rc.turnOn();
		rc.setMute(true);
		
		rc = new Audio();
		rc.turnOn();
		rc.setMute(true);
		
		// �����޼���
		RemoteControl.changeBattery();
		
		// �ʵ� ������
		Car myCar = new Car();
		myCar.run();
		myCar.frontLeftTire = new KumhoTire();
		myCar.fronRightTire = new KumhoTire();
		myCar.run();
		
		// �迭 ���� ��ü ����
		Car myArrCar = new Car();
		myArrCar.arrRun();
		
		myArrCar.tires[0] = new KumhoTire();
		myArrCar.tires[1] = new KumhoTire();
		
		myArrCar.arrRun();
		
		// Driver
		// �Ű����� ������
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);
		
		// ���� Ÿ�� ��ȯ(Casting)
		Vehicle vehicle = new Bus();
		
		vehicle.run();
//		vehicle.checkFare();	// Vehicle �������̽����� checkFare()�� ����
		
		Bus castingBus = (Bus)vehicle;
		castingBus.run();
		castingBus.checkFare();
		
		Bus test = new Bus();	// ** �ٷ� Bus Ÿ������ ������ �� �ִ��� �׽�Ʈ **
		test.run();
		test.checkFare();
		
		// InterfaceA-B-C
		// �������̽� ���
		ImplementationC impl = new ImplementationC();
		
		InterfaceA ia = impl;	// InterfaceA�� methodA()�� ȣ�� ����
		ia.methodA();
		System.out.println();
		
		InterfaceB ib = impl;	// InterfaceB�� methodB�� ȣ�� ����
		ib.methodB();
		System.out.println();
		
		InterfaceC ic = impl;	// InterfaceC�� methodA(), methodAB(), methodAC() ��� ȣ�� ����
		ic.methodA();
		ic.methodB();
		ic.methodC();
		
		// MyInterface
		// ����Ʈ �޼���
		MyInterface mi1 = new MyClassA();
		mi1.method1();
		mi1.method2();
		
		MyInterface mi2 = new MyClassB();
		mi2.method1();
		mi2.method2();
		
		// ParentInterface
		// ����Ʈ �޼��� �������̽� ���
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