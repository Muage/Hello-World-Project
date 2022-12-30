package ex05;

public class Car {
	//필드(field), 속성
	String nation = "대한민국";
	String company;
	String model;
	String color;
	int maxSpeed;
	
	Car() {	//기본생성자
		
	}
	
	public Car(String model, String color, int maxSpeed) {
		super();
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	public Car(String company, String model, String color, int maxSpeed) {
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	public void carPrint() {	//메소드
		System.out.println("국가 : " + nation);
		System.out.println("회사 : " + company);
		System.out.println("모델 : " + model);
		System.out.println("색상 : " + color);
		System.out.println("최대속도 : " + maxSpeed);
	}
}
