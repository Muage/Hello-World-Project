package ex07;

public class Area {	//�簢���� ����
	//�ʵ�
//	int x, y;
	static final double PI = 3.141592;	//���
	
	//������
	Area() {
		
	}

	//������1 (�����ε�)
//	Area(int x) {	//int x : parameter
//		this.x = x;
//	}
	
	//������2 (�����ε�)
//	Area(int x, int y) {	//int x, int y : parameter
//		this.x = x;
//		this.y = y;
//	}
	
	//�޼ҵ�
	//���簢���� ���� �޼ҵ�
	public int area(int x) {
		int area = x * x;
		return area;
	}
	
	//���簢���� ���� �޼ҵ� (�����ε�)
	public int area(int x, int y) {
		int area = x *y;
		return area;
	}
	
	//���� ���� �޼ҵ� (�����ε�)
	public double area(double x) {
		double area = x * x * PI;
		return area;
	}
}
