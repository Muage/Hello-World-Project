package javaChapter6;

// import문
import kumho.BigWideTire;
import hankook.SnowTire;
import hyndai.Engine;

public class Car {
	// Car class 필드 정의
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	int speed;
	
	// import문
	Engine engine = new Engine();
	SnowTire tire1 = new SnowTire();
	BigWideTire tire2 = new BigWideTire();
	hankook.Tire tire3 = new hankook.Tire();
	kumho.Tire tire4 = new kumho.Tire();
	
//	String company = "현대자동차";
//	String model = "그랜저";
//	String color = "검정";
//	int maxSpeed = 350;
//	int speed;
	
	// 생성자 오버로딩
	Car(){
		
	}

	Car(String color, int cc){
		
	}
	
	Car(String model) {
		this(model, "은색", 250);
//		this.model = model;
	}
	
	Car(String model, String color) {
		this(model, color, 250);
//		this.model = model;
//		this.color = color;
	}
	
	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	// return문
	int gas;
	
	// return값 없는 메서드로 gas 필드값 변경
	void setGas(int gas) {
		this.gas = gas;
	}
	
	// return값 boolean인 메서드로 gas 필드값 0이면 false, 0이 아니면 true return 
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;	// false 리턴
		}
		System.out.println("gas가 있습니다");
		return true;	// true 리턴
	}
	
	// return값 없는 메서드로 gas 필드값 0이면 return문으로 메서드 강제 종료
	void run() {
		while(true) {
			if(gas > 0) {
				System.out.println("달립니다. (gas잔량 : " + gas + ")");
				gas -= 1;
			} else {
				System.out.println("멈춥니다. (gas잔량 : " + gas + ")");
				return;	// 메서드 종료
			}
		}
	}
	
	// 클래스 외부에서 메서드 호출
	int getSpeed() {
		return speed;
	}
	
	void keyTurnOn() {
		System.out.println("키를 돌립니다.");
	}
	
	void srun() {
		for(int i = 10; i <= 50; i += 10) {
			speed = i;
			System.out.println("달립니다. (시속 : " + speed + "km/h)");
		}
	}
	
	// 인스턴스 멤버와 this
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
	void nrun() {
		for(int i = 10; i <= 50; i += 10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다. (시속 : " + this.speed + "km/h)");
		}
	}
	
	// 정적 초기화 블록
	void arun() {
		System.out.println(speed + "으로 달립니다.");
	}
	

	
}
