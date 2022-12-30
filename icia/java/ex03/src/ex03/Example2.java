package ex03;

import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("국어 > ");
		int kor = s.nextInt();
		
		if(kor > 100) {
			System.out.println("잘못된 입력입니다.");
		}
		
		System.out.print("영어 > ");
		int eng = s.nextInt();
		
		if(eng > 100) {
			System.out.println("잘못된 입력입니다.");
		}
		
		System.out.print("수학 > ");
		int mat = s.nextInt();
		
		if(mat > 100) {
			System.out.println("잘못된 입력입니다.");
		}
		
		System.out.println("--------------------");
		
		double avg = (double)(kor + eng + mat) / 3;
		System.out.println("평균 > " + avg);
		
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

		System.out.println("등급 > " + grade);

//		if(avg >= 90) {
//			if(avg > 100) {
//				System.out.println("잘못된 등급입니다.");
//			} else if((100 >= avg) && (avg >= 95)) {
//				System.out.println("등급 > A+");
//			} else {
//				System.out.println("등급 > A0");
//			}
//		} else if(avg >= 80) {
//			if(avg >= 85) {
//				System.out.println("등급 > B+");
//			} else {
//				System.out.println("등급 > B0");
//			}
//		} else if(avg >= 70) {
//			if(avg >= 75) {
//				System.out.println("등급 > C+");
//			} else {
//				System.out.println("등급 > C0");
//			}
//		} else if(avg >= 60) {
//			if(avg >= 65) {
//				System.out.println("등급 > D+");
//			} else {
//				System.out.println("등급 > D0");
//			}
//		} else {
//			System.out.println("등급 > F");
//		}
	}
}
