package hankook;

public class SnowTire {	//ī��ǥ�ù� (�ڹ� ��)
	private String color = "����";
	private int size = 20;
	private int life = 3;
	
	
	
//	//�ʵ尪 ���� �޼ҵ�
//	public void setColor(String color) {
//		this.color = color;	//this.color�� color : �ʵ��� color
//							//color�� color : �޼ҵ� (String color)�� color
//	}
//	
//	//�ʵ尪 �������� �޼ҵ�
//	public String getColor() {
//		return color;
//	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void print() {
		System.out.println("�ѱ�Ÿ�̾��� �����Ÿ�̾� �Դϴ�.");
	}
	
	public void printInfo() {
		System.out.println("���� : " + color);
		System.out.println("������ : " + size);
		System.out.println("���� : " + life);
	}
}
