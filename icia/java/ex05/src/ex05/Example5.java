package ex05;

public class Example5 {
	public static void execute() {
		//����, ���׽ý�, ����, 250 �ڵ��� ��ü ����
				Car car1 = new Car();	//�⺻������
				car1.company = "����";	//�Ӽ�
				car1.model = "���׽ý�";
				car1.color = "����";
				car1.maxSpeed = 250;
				
				car1.carPrint();
				
				System.out.println("--------------------");
				
				//���, K5, ���, 250 �ڵ��� ��ü ����
				Car car2 = new Car();
				car2.company = "���";
				car2.model = "K5";
				car2.color = "���";
				car2.maxSpeed = 250;
				
				car2.carPrint();
				
				System.out.println("--------------------");

				//�ֿ�, Ƽ����, �Ķ�, 200 �ι�° �����ڷ� ��ü ����
				Car car3 = new Car("Ƽ����", "�Ķ�", 200);
				
				car3.carPrint();
				
				System.out.println("--------------------");
				
				//����, GV80, ����, 270 ����° �����ڷ� ��ü ����
				Car car4 = new Car("����", "GV80", "����", 270);
				
				car4.carPrint();
	}
}
