package ex03;

public class Repeat {
	public static void execute() {
		//�ݺ���(for)
		System.out.println("�ݺ��� (for)");
		
		int tot = 0;
		for(int i=1; i<=1000; i++) {
			tot = tot + i;									//i�� ���� �����ؼ� tot�� ����
		}
		System.out.println("1~1000������ �� = " + tot);
		
		int sum = 0;
		for(int i=2; i<=100; i=i+2) {
			sum = sum + i;
		}
		System.out.println("1~100������ ¦���� �� = " + sum);
		
		sum = 0;
		for(int i=1; i<=100; i=i+2) {
			sum = sum + i;
		}
		System.out.println("1~100������ Ȧ���� �� = " + sum);
		
		System.out.println("-------------------------");
		
		//�ݺ���(while)
		System.out.println("�ݺ��� (while)");
		int i = 1;
		sum = 0;
		while(i <= 100) {
			sum = sum + i;
			i = i + 1;
		}
		System.out.println("1~100������ �� = " + sum);
		
		int a = 2;
		sum = 0;
		while(a <= 100) {
			sum = sum + a;
			a = a + 2;
		}
		System.out.println("1~100������ ¦���� �� = " + sum);
		
		int b = 1;
		sum = 0;
		while(b < 100) {
			sum = sum + b;
			b = b + 2;
		}
		System.out.println("1~100������ Ȧ���� �� = " + sum);
	}
}
