package javaChapter2;

public class Sample5 {
	public static void main(String[] args) {
		char b1 = 'A', b2 = 'A', b3 = 'A';
		String n1 = "홍길동", n2 = "심청이", n3 = "이순신";
		
		int k1 = 90, k2 = 85, k3 = 70;
		int e1 = 95, e2 = 70, e3 = 70;
		int m1 = 87, m2 = 60, m3 = 60;
		
		int t1 = k1 + e1 + m1, t2 = k2 + e2 + m2,  t3 = k3 + e3 + m3;
		float a1 = (float)t1 / 3, a2 = (float)t2 / 3, a3 = (float)t3 / 3;
		
		System.out.println(b1 + " " + n1 + " " + k1 + " " + e1 + " " + m1 + " " + t1 + " " + a1);
		System.out.println(b2 + " " + n2 + " " + k2 + " " + e2 + " " + m2 + " " + t2 + " " + a2);
		System.out.println(b3 + " " + n3 + " " + k3 + " " + e3 + " " + m3 + " " + t3 + " " + a3);
	}
}
