package ex06;

public class Car {
	//�ʵ�
	String company;
	String model;
	int maxSpeed = 100;	//ī��ǥ���
	
	//������
	Car() {
		
	}
	
	//������1
	Car(String company) {
		this.company = company;
	}
	
	//������2
	Car(String company, String model, int maxSpeed) {
		this.company = company;
		this.model = model;
		this.maxSpeed = maxSpeed;
	}
	
	//�޼ҵ�
	public void infoPrint() {
		System.out.println("ȸ�� : " + company);
		System.out.println("�� : " + model);
		System.out.println("�ִ�ӵ� : " + maxSpeed);
		
	}
}