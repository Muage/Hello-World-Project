package ex05;

public class Car {
	//�ʵ�(field), �Ӽ�
	String nation = "���ѹα�";
	String company;
	String model;
	String color;
	int maxSpeed;
	
	Car() {	//�⺻������
		
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

	public void carPrint() {	//�޼ҵ�
		System.out.println("���� : " + nation);
		System.out.println("ȸ�� : " + company);
		System.out.println("�� : " + model);
		System.out.println("���� : " + color);
		System.out.println("�ִ�ӵ� : " + maxSpeed);
	}
}
