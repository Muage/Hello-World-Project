package ex15;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Example1.execute();
	}
	
	//���� �Է� �ޱ�
	public static int input(String title) {
		Scanner scanner = new Scanner(System.in);
		String value = "";
		boolean isNumber = false;
		do {
			System.out.print(title + " : ");
			value = scanner.nextLine();
			isNumber = value.matches("-?\\d+(\\.\\d+)?");
			if(isNumber == false) System.out.println("���ڷ� �Է����ּ���.");
		} while(isNumber == false);
		
		return Integer.parseInt(value);
	}
}
