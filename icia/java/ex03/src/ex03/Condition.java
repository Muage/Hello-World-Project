package ex03;

public class Condition {
	public static void execute() {
		System.out.println("----- ���ǹ�(if) -----");
		System.out.println("");
		
		int score = 64;
		
		//�ܼ� if��
		System.out.println("----- �ܼ� if�� -----");
		boolean result = (score >= 90);
		if(result) {
			System.out.println("������ 90�� �̻��Դϴ�.");
			System.out.println("����� A�Դϴ�.");
		}
		
		if(score < 90) {
			System.out.println("������ 90�� �̸��Դϴ�.");
			System.out.println("����� B�Դϴ�.");
		}
		
		//if ~ else��
		if(score >= 90) {
			System.out.println("������ 90�� �̻��Դϴ�.");
			System.out.println("����� A�Դϴ�.");
		} else {
			System.out.println("������ 90�� �̸��Դϴ�.");
			System.out.println("����� B�Դϴ�.");
		}
		System.out.println("");
		
		//if ~ else if ~ else��
		System.out.println("----- if ~ else if ~ else�� -----");
		if(score >= 90) {
			System.out.println("������ 90�� �̻��Դϴ�.");
			System.out.println("����� A�Դϴ�.");
		} else if(score >= 80) {
			System.out.println("������ 80�� �̻��Դϴ�.");
			System.out.println("����� B�Դϴ�.");
		} else if(score >= 70) {
			System.out.println("������ 70�� �̻��Դϴ�.");
			System.out.println("����� C�Դϴ�.");
		} else if(score >= 60) {
			System.out.println("������ 60�� �̻��Դϴ�.");
			System.out.println("����� D�Դϴ�.");
		} else {
			System.out.println("������ 60�� �̸��Դϴ�.");
			System.out.println("����� F�Դϴ�.");
		}
		System.out.println("");
		
		//��ø if��
		System.out.println("----- ��ø if�� -----");
		if(score >= 90) {
			if(score >= 95) {
				System.out.println("������ 95�� �̻��Դϴ�.");
				System.out.println("����� A+�Դϴ�.");
			} else {
				System.out.println("������ 95�� �̸��Դϴ�.");
				System.out.println("����� A0�Դϴ�.");
			}
			
		} else if(score >= 80) {
			if(score >= 85) {
				System.out.println("������ 85�� �̻��Դϴ�.");
				System.out.println("����� B+�Դϴ�.");
			} else {
				System.out.println("������ 85�� �̸��Դϴ�.");
				System.out.println("����� B0�Դϴ�.");
			}
			
		} else if(score >= 70) {
			if(score >= 75) {
				System.out.println("������ 75�� �̻��Դϴ�.");
				System.out.println("����� C+�Դϴ�.");
			} else {
				System.out.println("������ 75�� �̸��Դϴ�.");
				System.out.println("����� C0�Դϴ�.");
			}
			
		} else if(score >= 60) {
			if(score >= 65) {
				System.out.println("������ 65�� �̻��Դϴ�.");
				System.out.println("����� D+�Դϴ�.");
			} else {
				System.out.println("������ 65�� �̸��Դϴ�.");
				System.out.println("����� D0�Դϴ�.");
			}
		} else {
			System.out.println("������ 60�� �̸��Դϴ�.");
			System.out.println("����� F�Դϴ�.");
		}
	}
}
