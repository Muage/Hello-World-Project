package ex03;

import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("���� > ");
		int kor = s.nextInt();
		
		if(kor > 100) {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
		
		System.out.print("���� > ");
		int eng = s.nextInt();
		
		if(eng > 100) {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
		
		System.out.print("���� > ");
		int mat = s.nextInt();
		
		if(mat > 100) {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
		
		System.out.println("--------------------");
		
		double avg = (double)(kor + eng + mat) / 3;
		System.out.println("��� > " + avg);
		
		String grade = "";
		
		if(avg >= 90) {
			if(avg >= 95) {
				grade = "A+";
			} else {
				grade = "A0";
			}
		} else if(avg >= 80) {
			if(avg >= 85) {
				grade = "B+";
			} else {
				grade = "B0";
			}
		} else if(avg >= 70) {
			if(avg >= 75) {
				grade = "C+";
			} else {
				grade = "C0";
			}
		} else if(avg >= 60) {
			if(avg >= 65) {
				grade = "D+";
			} else {
				grade = "D0";
			}
		} else {
				grade = "F";
		}

		System.out.println("��� > " + grade);

//		if(avg >= 90) {
//			if(avg > 100) {
//				System.out.println("�߸��� ����Դϴ�.");
//			} else if((100 >= avg) && (avg >= 95)) {
//				System.out.println("��� > A+");
//			} else {
//				System.out.println("��� > A0");
//			}
//		} else if(avg >= 80) {
//			if(avg >= 85) {
//				System.out.println("��� > B+");
//			} else {
//				System.out.println("��� > B0");
//			}
//		} else if(avg >= 70) {
//			if(avg >= 75) {
//				System.out.println("��� > C+");
//			} else {
//				System.out.println("��� > C0");
//			}
//		} else if(avg >= 60) {
//			if(avg >= 65) {
//				System.out.println("��� > D+");
//			} else {
//				System.out.println("��� > D0");
//			}
//		} else {
//			System.out.println("��� > F");
//		}
	}
}
