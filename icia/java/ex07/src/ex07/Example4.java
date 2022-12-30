package ex07;

import hankook.SnowTire;

public class Example4 {
	public static void execute() {
		System.out.println("***** 접근 제한자 *****");
		
		//한국 일반타이어
		Tire t1 = new Tire();
		t1.print();
		System.out.println("색상 : " + t1.color);
		System.out.println("사이즈 : " + t1.size);
		
		//한국 스노우 타이어
		SnowTire t2 = new SnowTire();
		t2.setColor("파랑");
		t2.setSize(18);
		t2.setLife(5);
		System.out.println("색상 : " + t2.getColor());
		System.out.println("사이즈 : " + t2.getSize());
		System.out.println("수명 : " + t2.getLife());
		t2.print();
		t2.printInfo();
	}
}
