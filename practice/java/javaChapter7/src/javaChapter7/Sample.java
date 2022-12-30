package javaChapter7;

public class Sample {
	public static void main(String[] args) {
		// CellPhone
		// DmbCellPhone 객체 생성
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		
		// CellPhone으로부터 상속받은 필드
		System.out.println("모델: " + dmbCellPhone.model);
		System.out.println("색상: " + dmbCellPhone.color);
		
		// DmbCellPhone 필드
		System.out.println("채널: " + dmbCellPhone.channel);
		
		// CellPhone으로부터 상속받은 메서드
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receiveVoice("안녕하세요! 저는 홍길동인데요");
		dmbCellPhone.sendVoice("아~ 예 반갑습니다.");
		dmbCellPhone.hangup();
		
		// DmbCellPhone 메서드
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeCannelDmb(12);
		dmbCellPhone.turnOffDmb();
		
		// People
		Student student = new Student("홍길동", "123456-1234567", 1);
		
		// 부모에서 물려받은 필드
		System.out.println("name: " + student.name);
		System.out.println("ssn: " + student.ssn);
		System.out.println("studentNo: " + student.studentNo);
		
		// Calculator
		int r = 10;
		
		Calculator calculator = new Calculator();
		System.out.println("원면적: " + calculator.areaCircle(r));
		System.out.println();
		
		Computer computer = new Computer();
		
		// 재정의된 메서드
		System.out.println("원면적: " + computer.areaCircle(r));
		
		// Airplane
		SupersonicAirplane sa = new SupersonicAirplane();
		sa.takeOff();
		sa.fly();
		
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();
		
		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly();
		sa.land();
		
		// Promotion
		pB b = new pB();
		pC c = new pC();
		pD d = new pD();
		pE e = new pE();
		
		pA a1 = b;
		pA a2 = c;
		pA a3 = d;
		pA a4 = e;
		
		pB b1 = d;
		pC c1 = e;
		
//		pB b3 = e;	// 상속X
//		pC c2 = d;	// 상속X
		
		// Parent
		Child child = new Child();
		Parent parent = child;
		
		parent.method1();
		parent.method2();
//		parent.method3();	// 호출 불가능
		
		// 강제타입변환(Casting)
		Parent cParent = new Child();	// 자동타입변환
		cParent.field1 = "data1";
		
		parent.method1();
		parent.method2();
		
//		parent.field2 = "data2";	// 불가능
//		parent.method3();	// 불가능
		
		Child cChild = (Child)cParent;	// 강제타입변환
		cChild.field2 = "yyy";
		cChild.method3();
		
		// 객체타입확인(instanceof)
		Parent parentA = new Child();
		method1(parentA);
		method2(parentA);
		
		Parent parentB = new Parent();
		method1(parentB);
//		method2(parentB);	// 예외 발생
		
		// Vehicle
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);
		
		// Phone
//		Phone phone = new Phone();
		SmartPhone smartPhone = new SmartPhone("홍길동");
		
		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
		
		// Animal
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		cat.sound();
		System.out.println("----------");
		
		Animal animal = null;
		animal = new Dog();	// 재정의된 메서드 호출
		animal.sound();
		
		animal = new Cat();	// 재정의된 메서드 호출
		animal.sound();
		System.out.println("----------");
		
		animalSound(new Dog());	// 메서드 다형성
		animalSound(new Cat());
	}
	// Parent
	// 객체타입확인(instanceof)
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child)parent;
			System.out.println("method1-Child로 변환 성공");
		} else {
			System.out.println("method1-Child로 변환 실패");
		}
	}
	
	public static void method2(Parent parent) {
		Child child = (Child)parent;
		System.out.println("method2-Child로 변환 성공");
	}
	
	// Animal
	public static void animalSound(Animal animal) {
		animal.sound();
	}
}

class pA {}

class pB extends pA {}
class pC extends pA {}

class pD extends pB {}
class pE extends pC {}