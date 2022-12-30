package javaChapter7;

public class Sample {
	public static void main(String[] args) {
		// CellPhone
		// DmbCellPhone ��ü ����
		DmbCellPhone dmbCellPhone = new DmbCellPhone("�ڹ���", "����", 10);
		
		// CellPhone���κ��� ��ӹ��� �ʵ�
		System.out.println("��: " + dmbCellPhone.model);
		System.out.println("����: " + dmbCellPhone.color);
		
		// DmbCellPhone �ʵ�
		System.out.println("ä��: " + dmbCellPhone.channel);
		
		// CellPhone���κ��� ��ӹ��� �޼���
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("��������");
		dmbCellPhone.receiveVoice("�ȳ��ϼ���! ���� ȫ�浿�ε���");
		dmbCellPhone.sendVoice("��~ �� �ݰ����ϴ�.");
		dmbCellPhone.hangup();
		
		// DmbCellPhone �޼���
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeCannelDmb(12);
		dmbCellPhone.turnOffDmb();
		
		// People
		Student student = new Student("ȫ�浿", "123456-1234567", 1);
		
		// �θ𿡼� �������� �ʵ�
		System.out.println("name: " + student.name);
		System.out.println("ssn: " + student.ssn);
		System.out.println("studentNo: " + student.studentNo);
		
		// Calculator
		int r = 10;
		
		Calculator calculator = new Calculator();
		System.out.println("������: " + calculator.areaCircle(r));
		System.out.println();
		
		Computer computer = new Computer();
		
		// �����ǵ� �޼���
		System.out.println("������: " + computer.areaCircle(r));
		
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
		
//		pB b3 = e;	// ���X
//		pC c2 = d;	// ���X
		
		// Parent
		Child child = new Child();
		Parent parent = child;
		
		parent.method1();
		parent.method2();
//		parent.method3();	// ȣ�� �Ұ���
		
		// ����Ÿ�Ժ�ȯ(Casting)
		Parent cParent = new Child();	// �ڵ�Ÿ�Ժ�ȯ
		cParent.field1 = "data1";
		
		parent.method1();
		parent.method2();
		
//		parent.field2 = "data2";	// �Ұ���
//		parent.method3();	// �Ұ���
		
		Child cChild = (Child)cParent;	// ����Ÿ�Ժ�ȯ
		cChild.field2 = "yyy";
		cChild.method3();
		
		// ��üŸ��Ȯ��(instanceof)
		Parent parentA = new Child();
		method1(parentA);
		method2(parentA);
		
		Parent parentB = new Parent();
		method1(parentB);
//		method2(parentB);	// ���� �߻�
		
		// Vehicle
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);
		
		// Phone
//		Phone phone = new Phone();
		SmartPhone smartPhone = new SmartPhone("ȫ�浿");
		
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
		animal = new Dog();	// �����ǵ� �޼��� ȣ��
		animal.sound();
		
		animal = new Cat();	// �����ǵ� �޼��� ȣ��
		animal.sound();
		System.out.println("----------");
		
		animalSound(new Dog());	// �޼��� ������
		animalSound(new Cat());
	}
	// Parent
	// ��üŸ��Ȯ��(instanceof)
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child)parent;
			System.out.println("method1-Child�� ��ȯ ����");
		} else {
			System.out.println("method1-Child�� ��ȯ ����");
		}
	}
	
	public static void method2(Parent parent) {
		Child child = (Child)parent;
		System.out.println("method2-Child�� ��ȯ ����");
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