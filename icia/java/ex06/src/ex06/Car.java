package ex06;

public class Car {
	//필드
	String company;
	String model;
	int maxSpeed = 100;	//카멜표기법
	
	//생성자
	Car() {
		
	}
	
	//생성자1
	Car(String company) {
		this.company = company;
	}
	
	//생성자2
	Car(String company, String model, int maxSpeed) {
		this.company = company;
		this.model = model;
		this.maxSpeed = maxSpeed;
	}
	
	//메소드
	public void infoPrint() {
		System.out.println("회사 : " + company);
		System.out.println("모델 : " + model);
		System.out.println("최대속도 : " + maxSpeed);
		
	}
}