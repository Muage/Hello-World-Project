package ex04;

public class Example5 {
	public static void execute() {
		//�迭 (�ϳ��� ������ �������� �����͸� ������ �� �ִ�.)
		int[] a = {11, 22, 33, 44, 55, 66, 77, 88};
		System.out.println("3��° : " + a[2]);
		System.out.println("6��° : " + a[5]);
		System.out.println("--------------------");
		
		a[7] = 40;	//8��° ���� 40���� ����
		int sum = 0;
		
		for(int i=0; i<a.length; i++) {	//a.length : �迭�� ũ��
			System.out.println(i+1 + "��° : " + a[i]);
			sum = sum + a[i];
		}
		System.out.println("--------------------");
		System.out.println("���� : " + sum);
		
		double avg = (double)sum / a.length;
		System.out.println("��� : " + avg);
	}
}
