package ex04;

import java.util.Scanner;

public class Example1 {
	public static void execute() {
		
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("***** ����ǥ *****");
		
		boolean run = true;
		while(run) {	//run true�� ���ȿ� �ݺ�
			System.out.print("�̸� > ");	//�̸� �Է�
			String name = s.next();
			
			System.out.print("���� > ");	//���� ���� �Է�
			int kor = s.nextInt();
			
			System.out.print("���� > ");	//���� ���� �Է�
			int eng = s.nextInt();
			
			System.out.print("���� > ");	//���� ���� �Է�
			int mat = s.nextInt();
			
			System.out.println("--------------------");
			
			int tot = kor + eng + mat;	//���� ���
			double avg = tot / 3.;	//��� ���
			System.out.println("���� : " + tot);
			System.out.println("��� : " + avg);
			
			String grade = "";	//��� ���
			if(avg>=90) {
				if(avg>=95) {
					grade = "A+";
				} else {
					grade = "A0";
				}
			} else if(avg >=80) {
				if(avg>=85) {
					grade = "B+";
				} else {
					grade = "B0";
				}
			} else if(avg >=70) {
				if(avg>=75) {
					grade = "C+";
				} else {
					grade = "C0";
				}
			} else if(avg >=60) {
				if(avg>=65) {
					grade = "D+";
				} else {
					grade = "D0";
				}
			} else {
				grade = "F";
			}
			System.out.println("��� : " + grade);
			System.out.println();
			
			System.out.print("����:0, ���:1 > ");
			
			int sel = s.nextInt();
			if(sel == 0) {	//����
				System.out.println("���α׷��� �����մϴ�!");
				run = false;
			}
		}
	}
}
