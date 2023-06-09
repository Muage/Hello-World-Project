package ex03;

public class Condition {
	public static void execute() {
		System.out.println("----- 조건문(if) -----");
		System.out.println("");
		
		int score = 64;
		
		//단순 if문
		System.out.println("----- 단순 if문 -----");
		boolean result = (score >= 90);
		if(result) {
			System.out.println("점수가 90점 이상입니다.");
			System.out.println("등급은 A입니다.");
		}
		
		if(score < 90) {
			System.out.println("점수가 90점 미만입니다.");
			System.out.println("등급은 B입니다.");
		}
		
		//if ~ else문
		if(score >= 90) {
			System.out.println("점수가 90점 이상입니다.");
			System.out.println("등급은 A입니다.");
		} else {
			System.out.println("점수가 90점 미만입니다.");
			System.out.println("등급은 B입니다.");
		}
		System.out.println("");
		
		//if ~ else if ~ else문
		System.out.println("----- if ~ else if ~ else문 -----");
		if(score >= 90) {
			System.out.println("점수가 90점 이상입니다.");
			System.out.println("등급은 A입니다.");
		} else if(score >= 80) {
			System.out.println("점수가 80점 이상입니다.");
			System.out.println("등급은 B입니다.");
		} else if(score >= 70) {
			System.out.println("점수가 70점 이상입니다.");
			System.out.println("등급은 C입니다.");
		} else if(score >= 60) {
			System.out.println("점수가 60점 이상입니다.");
			System.out.println("등급은 D입니다.");
		} else {
			System.out.println("점수가 60점 미만입니다.");
			System.out.println("등급은 F입니다.");
		}
		System.out.println("");
		
		//중첩 if문
		System.out.println("----- 중첩 if문 -----");
		if(score >= 90) {
			if(score >= 95) {
				System.out.println("점수가 95점 이상입니다.");
				System.out.println("등급은 A+입니다.");
			} else {
				System.out.println("점수가 95점 미만입니다.");
				System.out.println("등급은 A0입니다.");
			}
			
		} else if(score >= 80) {
			if(score >= 85) {
				System.out.println("점수가 85점 이상입니다.");
				System.out.println("등급은 B+입니다.");
			} else {
				System.out.println("점수가 85점 미만입니다.");
				System.out.println("등급은 B0입니다.");
			}
			
		} else if(score >= 70) {
			if(score >= 75) {
				System.out.println("점수가 75점 이상입니다.");
				System.out.println("등급은 C+입니다.");
			} else {
				System.out.println("점수가 75점 미만입니다.");
				System.out.println("등급은 C0입니다.");
			}
			
		} else if(score >= 60) {
			if(score >= 65) {
				System.out.println("점수가 65점 이상입니다.");
				System.out.println("등급은 D+입니다.");
			} else {
				System.out.println("점수가 65점 미만입니다.");
				System.out.println("등급은 D0입니다.");
			}
		} else {
			System.out.println("점수가 60점 미만입니다.");
			System.out.println("등급은 F입니다.");
		}
	}
}
