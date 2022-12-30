package ex04;

import java.util.Scanner;

public class Example1 {
	public static void execute() {
		
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("***** 성적표 *****");
		
		boolean run = true;
		while(run) {	//run true인 동안에 반복
			System.out.print("이름 > ");	//이름 입력
			String name = s.next();
			
			System.out.print("국어 > ");	//국어 점수 입력
			int kor = s.nextInt();
			
			System.out.print("영어 > ");	//영어 점수 입력
			int eng = s.nextInt();
			
			System.out.print("수학 > ");	//수학 점수 입력
			int mat = s.nextInt();
			
			System.out.println("--------------------");
			
			int tot = kor + eng + mat;	//총점 계산
			double avg = tot / 3.;	//평균 계산
			System.out.println("총점 : " + tot);
			System.out.println("평균 : " + avg);
			
			String grade = "";	//등급 계산
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
			System.out.println("등급 : " + grade);
			System.out.println();
			
			System.out.print("종료:0, 계속:1 > ");
			
			int sel = s.nextInt();
			if(sel == 0) {	//종료
				System.out.println("프로그램을 종료합니다!");
				run = false;
			}
		}
	}
}
