package ex07;

import hankook.SnowTire;

public class Example4 {
	public static void execute() {
		System.out.println("***** ���� ������ *****");
		
		//�ѱ� �Ϲ�Ÿ�̾�
		Tire t1 = new Tire();
		t1.print();
		System.out.println("���� : " + t1.color);
		System.out.println("������ : " + t1.size);
		
		//�ѱ� ����� Ÿ�̾�
		SnowTire t2 = new SnowTire();
		t2.setColor("�Ķ�");
		t2.setSize(18);
		t2.setLife(5);
		System.out.println("���� : " + t2.getColor());
		System.out.println("������ : " + t2.getSize());
		System.out.println("���� : " + t2.getLife());
		t2.print();
		t2.printInfo();
	}
}
