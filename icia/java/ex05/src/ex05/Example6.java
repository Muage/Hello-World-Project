package ex05;

import java.util.Scanner;

public class Example6 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			Calculator c1 = new Calculator();
			System.out.print("����1 > ");
			c1.num1 = s.nextInt();
			if(c1.num1 == 0) {
				System.out.println("���α׷� ����");
				break;
			}
			
			System.out.print("����2 > ");
			c1.num2 = s.nextInt();
			
			c1.execute();
			c1.print();
			System.out.println("");
		}
	}
}
