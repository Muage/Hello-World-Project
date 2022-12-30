package javaChapter6;

// import��
import kumho.BigWideTire;
import hankook.SnowTire;
import hyndai.Engine;

public class Car {
	// Car class �ʵ� ����
	String company = "�����ڵ���";
	String model;
	String color;
	int maxSpeed;
	int speed;
	
	// import��
	Engine engine = new Engine();
	SnowTire tire1 = new SnowTire();
	BigWideTire tire2 = new BigWideTire();
	hankook.Tire tire3 = new hankook.Tire();
	kumho.Tire tire4 = new kumho.Tire();
	
//	String company = "�����ڵ���";
//	String model = "�׷���";
//	String color = "����";
//	int maxSpeed = 350;
//	int speed;
	
	// ������ �����ε�
	Car(){
		
	}

	Car(String color, int cc){
		
	}
	
	Car(String model) {
		this(model, "����", 250);
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
	
	// return��
	int gas;
	
	// return�� ���� �޼���� gas �ʵ尪 ����
	void setGas(int gas) {
		this.gas = gas;
	}
	
	// return�� boolean�� �޼���� gas �ʵ尪 0�̸� false, 0�� �ƴϸ� true return 
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("gas�� �����ϴ�.");
			return false;	// false ����
		}
		System.out.println("gas�� �ֽ��ϴ�");
		return true;	// true ����
	}
	
	// return�� ���� �޼���� gas �ʵ尪 0�̸� return������ �޼��� ���� ����
	void run() {
		while(true) {
			if(gas > 0) {
				System.out.println("�޸��ϴ�. (gas�ܷ� : " + gas + ")");
				gas -= 1;
			} else {
				System.out.println("����ϴ�. (gas�ܷ� : " + gas + ")");
				return;	// �޼��� ����
			}
		}
	}
	
	// Ŭ���� �ܺο��� �޼��� ȣ��
	int getSpeed() {
		return speed;
	}
	
	void keyTurnOn() {
		System.out.println("Ű�� �����ϴ�.");
	}
	
	void srun() {
		for(int i = 10; i <= 50; i += 10) {
			speed = i;
			System.out.println("�޸��ϴ�. (�ü� : " + speed + "km/h)");
		}
	}
	
	// �ν��Ͻ� ����� this
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
	void nrun() {
		for(int i = 10; i <= 50; i += 10) {
			this.setSpeed(i);
			System.out.println(this.model + "�� �޸��ϴ�. (�ü� : " + this.speed + "km/h)");
		}
	}
	
	// ���� �ʱ�ȭ ���
	void arun() {
		System.out.println(speed + "���� �޸��ϴ�.");
	}
	

	
}
