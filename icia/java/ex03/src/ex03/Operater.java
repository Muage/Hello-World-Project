package ex03;

public class Operater {										//
	public static void execute() {
		System.out.println("----- ������ -----");
		System.out.println("1. ��� ������");
		int a =11;
		int b = 4;
		int c = a + b;
		int d = a - b;
		int e = a * b;
		double f = (double)a / b;
		int g = a % b;
		
		System.out.println(a + "���ϱ�" + b + "=" + c);
		System.out.println(a + "����" + b + "=" + d);
		System.out.println(a + "���ϱ�" + b + "=" + e);
		System.out.println(a + "������" + b + "=" + f);
		System.out.println(a + "������" + b + "�� ������=" + g);
		System.out.println("");
		
		System.out.println("2. �� ������");
		boolean result = (a >= b);
		System.out.println(a + ">=" + b + " ���:" + result);
		result = (a == b);
		System.out.println(a + "==" + b + " ���:" + result);
		result = (a != b);
		System.out.println(a + "!=" + b + " ���:" + result);
		System.out.println("");
		
		System.out.println("3. �� ������");
		//a�� 5���� ũ�� b�� 5���� Ů�ϱ�?
		result = (a > 5) && (b > 5);
		System.out.println("a�� 5���� ũ�� b�� 5���� Ů�ϱ�? ���:" + result);
		//a�� 5���� ũ�ų� b�� 5���� Ů�ϱ�?
		result = (a > 5) || (b > 5);
		System.out.println("a�� 5���� ũ�ų� b�� 5���� Ů�ϱ�? ���:" + result);
		//a�� 10�̻��̰� b�� 10�̻��Դϱ�?
		result = (a >= 10) && (b >= 10);
		System.out.println("a�� 10�̻��̰� b�� 10�̻��Դϱ�? ���:" + result);
		//a�� 10�̻��̰� b�� 5�����Դϱ�?
		result = (a >= 10) && (b <= 5);
		System.out.println("a�� 10�̻��̰� b�� 5�����Դϱ�? ���:" + result);
		//a�� 10�����̰ų� b�� 5�̻��Դϱ�?
		result = (a <= 10) || (b >= 5);
		System.out.println("a�� 10�����̰ų� b�� 5�̻��Դϱ�? ���:" + result);
		
		String gender = "����";
		int age = 22;
		//������ �����̰� ���̰� 20�� �̻��Դϱ�?
		result = (gender == "����") && (age >= 20);
		System.out.println("������ �����̰� ���̰� 20�� �̻��Դϱ�? ���:" + result);
		
		//������ �����̰ų� ���̰� 50�� �̻��Դϱ�?
		result = (gender == "����") || (age >= 50);
		System.out.println("������ �����̰ų� ���̰� 50�� �̻��Դϱ�? ���:" + result);
	}
}
