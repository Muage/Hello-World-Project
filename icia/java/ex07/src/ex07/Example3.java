package ex07;

import hankook.SnowTire;
import kumho.BigWideTire;
import kumho.Tire;

public class Example3 {
	public static void execute() {
		System.out.println("***** ��Ű�� ���� *****");
		
		//��ȣŸ�̾� �Ϲ�Ÿ�̾�
		Tire t1 = new Tire();
		t1.print();
		
		//�ѱ� �����
		SnowTire t2 = new SnowTire();
		t2.print();
		
		//�ѱ� �Ϲ�Ÿ�̾�
		hankook.Tire t3 = new hankook.Tire();
		t3.print();
		
		//��ȣ ����̵�Ÿ�̾�
		BigWideTire t4 = new BigWideTire();
		t4.print();
	}
}
