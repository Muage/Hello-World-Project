package javaChapter6;

public class Sample {
	public static void main(String[] args) {
		// Student
		Student s1 = new Student();
		System.out.println("s1 변수가 Student 객체를 참조합니다.");
		
		Student s2 = new Student();
		System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다.");
		
		// Car
		// 객체 생성
		Car myCar = new Car();	// 기본 생성자
		
		// 필드값 읽기
		System.out.println("제작회사 : " + myCar.company);
		System.out.println("모델명 : " + myCar.model);
		System.out.println("색상 : " + myCar.color);
		System.out.println("최고속도 : " + myCar.maxSpeed);
		System.out.println("현재속도 : " + myCar.speed);
		
		// 필드값 변경
		myCar.speed = 60;
		System.out.println("수정된 속도 : " + myCar.speed);
		
		// 생성자 호출 객체 생성
		Car myCar2 = new Car("검정", 3000);
		
		// 객체 생성 시 생성자 선택
		Car car1 = new Car();
		System.out.println("car1.company : " + car1.company);
		System.out.println();
		
		Car car2 = new Car("자가용");
		System.out.println("car2.company : " + car2.company);
		System.out.println("car2.model : " + car2.model);
		System.out.println();
		
		Car car3 = new Car("자가용", "빨강");
		System.out.println("car3.company : " + car3.company);
		System.out.println("car3.model : " + car3.model);
		System.out.println("car3.color : " + car3.color);
		System.out.println();
		
		Car car4 = new Car("택시", "검정", 200);
		System.out.println("car4.company : " + car4.company);
		System.out.println("car4.model : " + car4.model);
		System.out.println("car4.color : " + car4.color);
		System.out.println("car4.maxSpeed : " + car4.maxSpeed);
		System.out.println();
		
		// return문
		Car c = new Car();
		myCar.setGas(5);	// setGas() 메서드 호출
		
		boolean gasState = myCar.isLeftGas();	// isLeftGas() 메서드 호출
		if(gasState) {
			System.out.println("출발합니다.");
			myCar.run();	// run() 메서드 호출
		}
		
		if(myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요.");
		}
		
		// 클래스 외부에서 메서드 호출
		myCar.keyTurnOn();
		myCar.srun();
		
		int speed = myCar.getSpeed();
		System.out.println("현재 속도 : " + speed + "km/h");
		
		// 인스턴스 멤버와 this
		Car mCar = new Car("포르쉐");
		Car yCar = new Car("벤츠");
		mCar.nrun();
		yCar.nrun();
		
		// 정적 초기화 블록
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
		Korean k1 = new Korean("박자바", "011225-1234567");
		System.out.println("k1.name : " + k1.name);
		System.out.println("k1.ssn : " + k1.ssn);
		Korean k2 = new Korean("김자바", "930525-0654321");
		System.out.println("k2.name : " + k2.name);
		System.out.println("k2.ssn : " + k2.ssn);
		
		// Calculator
		// 메서드 호출
		Calculator myCalc = new Calculator();
		myCalc.powerOn();
		
		int result1 = myCalc.plus(5, 6);
		System.out.println("result1 : " + result1);
		
		int x = 10;
		int y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("result2 : " + result2);
		
		myCalc.powerOff();
		
		// 클래스 내부에서 메서드 호출
		myCalc.execute();	// execute() 메서드 호출
		
		// 메서드 오버로딩
		Calculator myCalcu = new Calculator();
		double cresult1 = myCalcu.areaRectangle(10);
		double cresult2 = myCalcu.areaRectangle(10, 20);
		
		System.out.println("정사각형 넓이 : " + cresult1);
		System.out.println("직사각형 넓이 : " + cresult2);
		
		// 정적 멤버 사용
		double presult1 = 10 * 10 * Calculator.pi;
		
		int presult2 = Calculator.pPlus(10, 5);
		int presult3 = Calculator.pMinus(10, 5);
		
		System.out.println("presult1 : " + presult1);
		System.out.println("presult2 : " + presult2);
		System.out.println("presult3 : " + presult3);
		
		// Computer
		// 파라미터 수를 모를 경우
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
		// 정적 초기화 블록
		System.out.println(Television.info);
		
		// Singleton
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		if(obj1 == obj2) {
			System.out.println("같은 Singleton 객체 입니다.");
		} else {
			System.out.println("다른 Singleton 객체 입니다.");
		}
		
		// Person
		// 싱글톤 객체
		Person p1 = new Person("123456-1234567", "계백");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		p1.name = "을지문덕";
		System.out.println(p1.name);
		
		// Earth
		// 상수
		System.out.println("지구의 반지름 : " + Earth.EARTH_RADIUS + "km");
		System.out.println("지구의 표면적 : " + Earth.EARTH_SURFACE_AREA + "km^2");
		
		// Car2
		// Getter & Setter
		Car2 tCar = new Car2();
		
		// 잘못된 속도 변경
		tCar.setSpeed(-50);
		System.out.println("현재 속도 : " + tCar.getSpeed());
		
		// 올바른 속도 변경
		tCar.setSpeed(60);
		
		// 멈춤
		if(!tCar.isStop()) {
			tCar.setStop(true);
		}
		System.out.println("현재 속도 : " + tCar.getSpeed());
	}
}
