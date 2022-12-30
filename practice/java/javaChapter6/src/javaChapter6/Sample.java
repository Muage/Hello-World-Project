package javaChapter6;

public class Sample {
	public static void main(String[] args) {
		// Student
		Student s1 = new Student();
		System.out.println("s1 ������ Student ��ü�� �����մϴ�.");
		
		Student s2 = new Student();
		System.out.println("s2 ������ �� �ٸ� Student ��ü�� �����մϴ�.");
		
		// Car
		// ��ü ����
		Car myCar = new Car();	// �⺻ ������
		
		// �ʵ尪 �б�
		System.out.println("����ȸ�� : " + myCar.company);
		System.out.println("�𵨸� : " + myCar.model);
		System.out.println("���� : " + myCar.color);
		System.out.println("�ְ�ӵ� : " + myCar.maxSpeed);
		System.out.println("����ӵ� : " + myCar.speed);
		
		// �ʵ尪 ����
		myCar.speed = 60;
		System.out.println("������ �ӵ� : " + myCar.speed);
		
		// ������ ȣ�� ��ü ����
		Car myCar2 = new Car("����", 3000);
		
		// ��ü ���� �� ������ ����
		Car car1 = new Car();
		System.out.println("car1.company : " + car1.company);
		System.out.println();
		
		Car car2 = new Car("�ڰ���");
		System.out.println("car2.company : " + car2.company);
		System.out.println("car2.model : " + car2.model);
		System.out.println();
		
		Car car3 = new Car("�ڰ���", "����");
		System.out.println("car3.company : " + car3.company);
		System.out.println("car3.model : " + car3.model);
		System.out.println("car3.color : " + car3.color);
		System.out.println();
		
		Car car4 = new Car("�ý�", "����", 200);
		System.out.println("car4.company : " + car4.company);
		System.out.println("car4.model : " + car4.model);
		System.out.println("car4.color : " + car4.color);
		System.out.println("car4.maxSpeed : " + car4.maxSpeed);
		System.out.println();
		
		// return��
		Car c = new Car();
		myCar.setGas(5);	// setGas() �޼��� ȣ��
		
		boolean gasState = myCar.isLeftGas();	// isLeftGas() �޼��� ȣ��
		if(gasState) {
			System.out.println("����մϴ�.");
			myCar.run();	// run() �޼��� ȣ��
		}
		
		if(myCar.isLeftGas()) {
			System.out.println("gas�� ������ �ʿ䰡 �����ϴ�.");
		} else {
			System.out.println("gas�� �����ϼ���.");
		}
		
		// Ŭ���� �ܺο��� �޼��� ȣ��
		myCar.keyTurnOn();
		myCar.srun();
		
		int speed = myCar.getSpeed();
		System.out.println("���� �ӵ� : " + speed + "km/h");
		
		// �ν��Ͻ� ����� this
		Car mCar = new Car("������");
		Car yCar = new Car("����");
		mCar.nrun();
		yCar.nrun();
		
		// ���� �ʱ�ȭ ���
		Car aCar = new Car();
		aCar.speed = 60;
		aCar.arun();
		
		// FieldValue
		FieldValue fv = new FieldValue();
		System.out.println("intField : " + fv.intField);
		System.out.println("booleanField : " + fv.booleanField);
		System.out.println("charField : " + fv.charField);
		System.out.println("floatField : " + fv.floatField);
		System.out.println("doubleField : " + fv.doubleField);
		System.out.println("arrField : " + fv.arrField);
		System.out.println("stringField : " + fv.stringField);
		
		// Korean
		Korean k1 = new Korean("���ڹ�", "011225-1234567");
		System.out.println("k1.name : " + k1.name);
		System.out.println("k1.ssn : " + k1.ssn);
		Korean k2 = new Korean("���ڹ�", "930525-0654321");
		System.out.println("k2.name : " + k2.name);
		System.out.println("k2.ssn : " + k2.ssn);
		
		// Calculator
		// �޼��� ȣ��
		Calculator myCalc = new Calculator();
		myCalc.powerOn();
		
		int result1 = myCalc.plus(5, 6);
		System.out.println("result1 : " + result1);
		
		int x = 10;
		int y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("result2 : " + result2);
		
		myCalc.powerOff();
		
		// Ŭ���� ���ο��� �޼��� ȣ��
		myCalc.execute();	// execute() �޼��� ȣ��
		
		// �޼��� �����ε�
		Calculator myCalcu = new Calculator();
		double cresult1 = myCalcu.areaRectangle(10);
		double cresult2 = myCalcu.areaRectangle(10, 20);
		
		System.out.println("���簢�� ���� : " + cresult1);
		System.out.println("���簢�� ���� : " + cresult2);
		
		// ���� ��� ���
		double presult1 = 10 * 10 * Calculator.pi;
		
		int presult2 = Calculator.pPlus(10, 5);
		int presult3 = Calculator.pMinus(10, 5);
		
		System.out.println("presult1 : " + presult1);
		System.out.println("presult2 : " + presult2);
		System.out.println("presult3 : " + presult3);
		
		// Computer
		// �Ķ���� ���� �� ���
		Computer myCom = new Computer();
		int[] values1 = {1, 2, 3};
		int aresult1 = myCom.sum1(values1);
		System.out.println("aresult1 : " + aresult1);
		
		int aresult2 = myCom.sum1(new int[] {1, 2, 3, 4, 5});
		System.out.println("aresult2 : " + aresult2);
		
		int aresult3 = myCom.sum2(1, 2, 3);
		System.out.println("aresult3 : " + aresult3);
		
		int aresult4 = myCom.sum2(1, 2, 3, 4, 5);
		System.out.println("aresult4 : " + aresult4);
		
		// Television
		// ���� �ʱ�ȭ ���
		System.out.println(Television.info);
		
		// Singleton
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		if(obj1 == obj2) {
			System.out.println("���� Singleton ��ü �Դϴ�.");
		} else {
			System.out.println("�ٸ� Singleton ��ü �Դϴ�.");
		}
		
		// Person
		// �̱��� ��ü
		Person p1 = new Person("123456-1234567", "���");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		p1.name = "��������";
		System.out.println(p1.name);
		
		// Earth
		// ���
		System.out.println("������ ������ : " + Earth.EARTH_RADIUS + "km");
		System.out.println("������ ǥ���� : " + Earth.EARTH_SURFACE_AREA + "km^2");
		
		// Car2
		// Getter & Setter
		Car2 tCar = new Car2();
		
		// �߸��� �ӵ� ����
		tCar.setSpeed(-50);
		System.out.println("���� �ӵ� : " + tCar.getSpeed());
		
		// �ùٸ� �ӵ� ����
		tCar.setSpeed(60);
		
		// ����
		if(!tCar.isStop()) {
			tCar.setStop(true);
		}
		System.out.println("���� �ӵ� : " + tCar.getSpeed());
	}
}
