package ex03;

import java.util.Scanner;

public class Condition1 {
	public static void execute() {
		//���ǹ�(switch case)
		Scanner s = new Scanner(System.in);						//Ű����� �����͸� �Է� �ޱ� ���� ��ĳ�� ����
		
		System.out.print("��? ");
		int num = s.nextInt();
		
		switch(num) {
		case 1:
			System.out.println("1���� ���Խ��ϴ�.");
			break;
		case 2:
			System.out.println("2���� ���Խ��ϴ�.");
			break;
		case 3:
			System.out.println("3���� ���Խ��ϴ�.");
			break;
		case 4:
			System.out.println("4���� ���Խ��ϴ�.");
			break;
		case 5:
			System.out.println("5���� ���Խ��ϴ�.");
			break;
		case 6:
			System.out.println("6���� ���Խ��ϴ�.");
			break;
		default:
			System.out.println("�߸��� ���� �ԷµǾ����ϴ�.");
		}
		
		//�ð��� Ű����� �Է¹޾�
		//6���̸� '�Ͼ����'
		//7���̸� 'ȸ��� ����ϼ���'
		//13���̸� '���� �Ļ��ϼ���'
		//18���̸� '����ϼ���'
		System.out.print("����ð�> ");
		int time = s.nextInt();
		switch(time) {
		case 6:
			System.out.println("�Ͼ����!");
			break;
		case 7:
			System.out.println("ȸ��� ����ϼ���!");
			break;
		case 13:
			System.out.println("���� �Ļ��ϼ���!");
			break;
		case 18:
			System.out.println("����ϼ���!");
			break;
		default:
			System.out.println("�߸��� ���� �ԷµǾ����ϴ�.");
		}
	}
}
