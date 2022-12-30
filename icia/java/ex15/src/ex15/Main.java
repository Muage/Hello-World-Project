package ex15;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Example1.execute();
	}
	
	//숫자 입력 받기
	public static int input(String title) {
		Scanner scanner = new Scanner(System.in);
		String value = "";
		boolean isNumber = false;
		do {
			System.out.print(title + " : ");
			value = scanner.nextLine();
			isNumber = value.matches("-?\\d+(\\.\\d+)?");
			if(isNumber == false) System.out.println("숫자로 입력해주세요.");
		} while(isNumber == false);
		
		return Integer.parseInt(value);
	}
}
