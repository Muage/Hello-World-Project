package ex16;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("��������������������������������������������������������������������������������������������������");
			System.out.println("1.�а����� �� 2.����Ÿ�԰��� �� 3.�л����� �� 4.�������� �� 0.����");
			System.out.println("��������������������������������������������������������������������������������������������������");
			
			int menu = Main.input("����");
			switch(menu) {
			case 0:
				run = false;
				System.out.println("������������ �̵��մϴ�.\n");
				break;
				
			case 1:
				Example1.execute();
				break;
				
			case 2:
				Example2.execute();
				break;
				
			case 3:
				Example3.execute();
				break;
				
			case 4:
				Example4.execute();
				break;
				
			default:
				System.out.println("0~4�� �޴� �� �������ּ���.");
			}
		}
		
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
