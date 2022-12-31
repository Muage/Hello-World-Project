package baekjoon;

import java.util.Scanner;

public class Task1 {
	public static void execute() {
		Scanner s = new Scanner(System.in);

		System.out.println("Hello World!");
		System.out.println("--------------------");

		System.out.println("강한친구 대한육군");
		System.out.println("강한친구 대한육군");

		String army = "강한친구 대한육군";
		for (int i = 0; i < 2; i++) {
			System.out.println(army);
		}
		System.out.println("--------------------");

		System.out.println("\\    /\\\n )  ( ')\n(  /  )\n \\(__)|");
		System.out.println("--------------------");

		System.out.println("|\\_/|\n|q p|   /}\n( 0 )\"\"\"\\\n|\"^\"`    |\n||_/=\\\\__|");
		System.out.println("--------------------");

		int sumA = s.nextInt();
		int sumB = s.nextInt();
		System.out.println(sumA + sumB);
		System.out.println("--------------------");

		int subA = s.nextInt();
		int subB = s.nextInt();
		System.out.println(subA - subB);
		System.out.println("--------------------");

		int mulA = s.nextInt();
		int mulB = s.nextInt();
		System.out.println(mulA * mulB);
		System.out.println("--------------------");

		int divA = s.nextInt();
		int divB = s.nextInt();
		System.out.println((double) divA / divB);
		System.out.println("--------------------");

		int operA = s.nextInt();
		int operB = s.nextInt();
		System.out.println(operA + operB);
		System.out.println(operA - operB);
		System.out.println(operA * operB);
		System.out.println(operA / operB);
		System.out.println(operA % operB);
		System.out.println("--------------------");

		String nickname = s.next();
		System.out.println(nickname + "??!");
		System.out.println("--------------------");

		int remainA = s.nextInt();
		int remainB = s.nextInt();
		int remainC = s.nextInt();

		System.out.println((remainA + remainB) % remainC);
		System.out.println(((remainA % remainC) + (remainB % remainC)) % remainC);
		System.out.println((remainA * remainB) % remainC);
		System.out.println(((remainA % remainC) * (remainB % remainC)) % remainC);
		System.out.println("--------------------");

		int mul_a = s.nextInt();
		String mul_b = s.next();

		System.out.println(mul_a * (mul_b.charAt(2) - '0'));
		System.out.println(mul_a * (mul_b.charAt(1) - '0'));
		System.out.println(mul_a * (mul_b.charAt(0) - '0'));
		System.out.println(mul_a * Integer.parseInt(mul_b));

		int mul_a2 = s.nextInt();
		int mul_b2 = s.nextInt();

		System.out.println(mul_a2 * (mul_b2 % 10));
		System.out.println(mul_a2 * (mul_b2 % 100 / 10));
		System.out.println(mul_a2 * (mul_b2 / 100));
		System.out.println(mul_a2 * mul_b2);
		System.out.println("--------------------");

		System.out.println("         ,r'\"7\nr`-_   ,'  ,/\n \\. \". L_r'\n   `~\\/\n      |\n      |");
	}
}
