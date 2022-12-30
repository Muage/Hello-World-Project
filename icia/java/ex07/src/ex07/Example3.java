package ex07;

import hankook.SnowTire;
import kumho.BigWideTire;
import kumho.Tire;

public class Example3 {
	public static void execute() {
		System.out.println("***** 패키지 연습 *****");
		
		//금호타이어 일반타이어
		Tire t1 = new Tire();
		t1.print();
		
		//한국 스노우
		SnowTire t2 = new SnowTire();
		t2.print();
		
		//한국 일반타이어
		hankook.Tire t3 = new hankook.Tire();
		t3.print();
		
		//금호 빅와이드타이어
		BigWideTire t4 = new BigWideTire();
		t4.print();
	}
}
