package ex02;

public class Main {										//Ŭ���� �̸� ù ���� : �빮��
	public static void main(String[] args) {			//�޼ҵ� �̸� ù ���� : �ҹ���
		
		/*												//�ּ� ��� 2����
		System.out.print("Hello~~~");					//print VS println
		print���� console�� ����ϴ� ��ɾ��Դϴ�.
		*/
		
//		System.out.println("���� ȫ�浿�Դϴ�.");
		
//		Integer.integerExample();						//������ ���� Integer Ŭ���� ���
		
//		System.out.println("");
		
//		Float.floatExample();

//		Double.doubleExample();
		
//		StringExample.stringExample();
		
//		Sungjuk.grade();
		
//		TypeChange.change();
		
		//���׿�����
		int x = 10;
		int z = ++x;									//x++;�� x = x + 1;�� ����.
		System.out.println(z);
		System.out.println(x);
		
		int y = 10;
		int k = --y;
		System.out.println(k);
		System.out.println(y);
		
		//���������(+, -, *, /, %)
		int a = 9;
		int b = 7;
		int c = a % b;									//������ ����
		System.out.println(c);
		
		//���ڿ� ����
		String name = "ȫ�浿\n";
		String school = "��õ�Ϻ� ��ī����";
		String info = name + school;
		System.out.println(info);
		
		//�񱳿�����(>, >=, <, <=, ==, !=)
		int num1 = 9;
		int num2 = 10;
		
		boolean result = num1 > num2;
		System.out.println(result);
		
		result = num1 < num2;
		System.out.println(result);
		
		result = num1 == num2;
		System.out.println(result);
		
		result = num1 != num2;
		System.out.println(result);
		
		//��������(&&, ||, !)
		boolean value1 = false;
		boolean value2 = false;
		result = value1 && value2;
		System.out.println(result);
		
		result = value1 || value2;
		System.out.println(result);
		
		int n1 = 9;
		int n2 = 10;
		result = !((n1 < n2) || (n1 == n2));
		
		//20�� �̻��� ���ڸ� ���� ����
		char gender = 'M';
		int age = 49;
		result = (gender == 'M') && (age >= 20);
		System.out.println("���尡��(true), �Ұ���(false) : " + result);
		
		//���׿�����
		String strResult = result == true ? "���尡��" : "����Ұ���";
		System.out.println(strResult);
		
	}
}
